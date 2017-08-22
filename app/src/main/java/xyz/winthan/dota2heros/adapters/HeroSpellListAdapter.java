package xyz.winthan.dota2heros.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.adapters.base.BaseRecyclerAdapter;
import xyz.winthan.dota2heros.utils.clicklistener.OnSpellItemClickListener;
import xyz.winthan.dota2heros.viewholders.HeroSpellViewHolder;
import xyz.winthan.dota2heros.vos.HeroSpellVO;

/**
 * Created by winthanhtike on 8/22/17.
 */

public class HeroSpellListAdapter extends BaseRecyclerAdapter<HeroSpellViewHolder, HeroSpellVO> {

    private OnSpellItemClickListener itemClickListener;

    public HeroSpellListAdapter(Context context, OnSpellItemClickListener itemClickListener) {
        super(context);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public HeroSpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_spell, parent, false);
        return new HeroSpellViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(HeroSpellViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

}
