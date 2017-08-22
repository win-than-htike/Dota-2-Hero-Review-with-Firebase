package xyz.winthan.dota2heros.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.utils.AlertDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroSpellFragment extends AlertDialogFragment {

    private static final String OVERVIEW = "OVERVIEW";

    @BindView(R.id.tv_spell_overview)
    TextView mSpellOverview;

    public HeroSpellFragment() {
        // Required empty public constructor
    }

    public static HeroSpellFragment newInstance(String overview){

        HeroSpellFragment fragment = new HeroSpellFragment();
        Bundle bundle = new Bundle();
        bundle.putString(OVERVIEW, overview);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hero_spell, container, false);
        ButterKnife.bind(this, rootView);

        Bundle bundle = getArguments();

        if (bundle != null){
            String overview = bundle.getString(OVERVIEW);
            mSpellOverview.setText(overview);
        }

        return rootView;
    }

}
