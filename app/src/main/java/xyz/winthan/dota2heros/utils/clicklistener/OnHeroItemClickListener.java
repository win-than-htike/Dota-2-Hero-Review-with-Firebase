package xyz.winthan.dota2heros.utils.clicklistener;

import android.widget.ImageView;

import xyz.winthan.dota2heros.vos.HeroVO;

/**
 * Created by winthanhtike on 8/21/17.
 */

public interface OnHeroItemClickListener {
    void onTapHero(ImageView imageView, HeroVO heroVO);
}
