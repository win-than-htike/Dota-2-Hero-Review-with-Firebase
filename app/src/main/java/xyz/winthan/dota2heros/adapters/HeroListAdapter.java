package xyz.winthan.dota2heros.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.adapters.base.BaseRecyclerAdapter;
import xyz.winthan.dota2heros.utils.clicklistener.OnHeroItemClickListener;
import xyz.winthan.dota2heros.viewholders.HeroViewHolder;
import xyz.winthan.dota2heros.vos.HeroVO;

/**
 * Created by winthanhtike on 8/21/17.
 */

public class HeroListAdapter extends BaseRecyclerAdapter<HeroViewHolder, HeroVO> {

    private OnHeroItemClickListener heroItemClickListener;

    public HeroListAdapter(Context context, OnHeroItemClickListener heroItemClickListener) {
        super(context);
        this.heroItemClickListener = heroItemClickListener;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_hero, parent, false);
        return new HeroViewHolder(view, heroItemClickListener);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
