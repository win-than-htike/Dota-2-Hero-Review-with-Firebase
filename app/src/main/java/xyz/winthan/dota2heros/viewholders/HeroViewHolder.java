package xyz.winthan.dota2heros.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.utils.clicklistener.OnHeroItemClickListener;
import xyz.winthan.dota2heros.viewholders.base.BaseViewHolder;
import xyz.winthan.dota2heros.vos.HeroVO;

/**
 * Created by winthanhtike on 8/21/17.
 */

public class HeroViewHolder extends BaseViewHolder<HeroVO> {

    @BindView(R.id.iv_hero_image)
    ImageView ivHeroImage;

    @BindView(R.id.tv_hero_name)
    TextView mHeroName;

    private HeroVO data;

    private OnHeroItemClickListener heroItemClickListener;

    public HeroViewHolder(View itemView, OnHeroItemClickListener heroItemClickListener) {
        super(itemView);
        this.heroItemClickListener = heroItemClickListener;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (heroItemClickListener != null) heroItemClickListener.onTapHero(ivHeroImage, data);

    }

    @Override
    public void bind(HeroVO data) {
        this.data = data;

        mHeroName.setText(data.getHero_name());

        Glide.with(ivHeroImage.getContext())
                .load(data.getHero_image())
                .centerCrop()
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(ivHeroImage);

    }

}
