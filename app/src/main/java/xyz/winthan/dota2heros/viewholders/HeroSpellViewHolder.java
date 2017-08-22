package xyz.winthan.dota2heros.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.utils.clicklistener.OnSpellItemClickListener;
import xyz.winthan.dota2heros.viewholders.base.BaseViewHolder;
import xyz.winthan.dota2heros.vos.HeroSpellVO;

/**
 * Created by winthanhtike on 8/22/17.
 */

public class HeroSpellViewHolder extends BaseViewHolder<HeroSpellVO> {

    @BindView(R.id.iv_spell)
    ImageView ivSpell;

    @BindView(R.id.tv_spell_name)
    TextView mSpellName;

    private OnSpellItemClickListener itemClickListener;

    private HeroSpellVO data;

    public HeroSpellViewHolder(View itemView, OnSpellItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (itemClickListener != null) itemClickListener.onTapSpell(data);
    }

    @Override
    public void bind(HeroSpellVO data) {
        this.data = data;

        mSpellName.setText(data.getSpell_name());

        Glide.with(ivSpell.getContext())
                .load(data.getSpell_image())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivSpell);

    }
}
