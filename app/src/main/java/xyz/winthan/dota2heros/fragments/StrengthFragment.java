package xyz.winthan.dota2heros.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.adapters.HeroListAdapter;
import xyz.winthan.dota2heros.events.DataEvent;
import xyz.winthan.dota2heros.models.HeroModel;
import xyz.winthan.dota2heros.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class StrengthFragment extends BaseFragment {

    @BindView(R.id.rv_strength)
    RecyclerView rvStrength;

    @BindView(R.id.swipe_strength)
    SwipeRefreshLayout swipeRefreshLayout;

    private HeroListAdapter mAdapter;

    public StrengthFragment() {
        // Required empty public constructor
    }

    public static StrengthFragment newInstance(){
        StrengthFragment fragment = new StrengthFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HeroModel.getInstance().loadHeros(Constants.STRENGTH);
        mAdapter = new HeroListAdapter(getContext(), heroItemClickListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_strength, container, false);
        ButterKnife.bind(this, rootView);

        swipeRefreshLayout.setRefreshing(true);
        setupHeroRecycler();

        return rootView;
    }

    public void setupHeroRecycler(){
        rvStrength.setHasFixedSize(true);
        rvStrength.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStrength.setAdapter(mAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void heroDataLoaded(DataEvent.StrengthHeroDataLoadedEvent event){
        Log.i("dotahero ==> ", "strength");
        mAdapter.setNewData(event.getHeroVOList());
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);
    }

}
