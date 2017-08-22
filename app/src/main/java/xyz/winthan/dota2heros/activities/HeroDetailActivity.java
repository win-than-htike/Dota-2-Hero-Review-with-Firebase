package xyz.winthan.dota2heros.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.activities.base.BaseActivity;
import xyz.winthan.dota2heros.adapters.HeroSpellListAdapter;
import xyz.winthan.dota2heros.component.MMExpendableTextView;
import xyz.winthan.dota2heros.fragments.HeroSpellFragment;
import xyz.winthan.dota2heros.utils.AlertDialogFragment;
import xyz.winthan.dota2heros.utils.clicklistener.OnSpellItemClickListener;
import xyz.winthan.dota2heros.vos.HeroSpellVO;
import xyz.winthan.dota2heros.vos.HeroVO;

public class HeroDetailActivity extends BaseActivity implements OnSpellItemClickListener {

    private static final String HERO = "HERO";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tv_role)
    TextView tvRole;

    @BindView(R.id.toolbar_title)
    TextView tvToolbarTitle;

    @BindView(R.id.tv_intelligence)
    TextView tvIntelligence;

    @BindView(R.id.tv_agility)
    TextView tvAgility;

    @BindView(R.id.tv_strength)
    TextView tvStrength;

    @BindView(R.id.tv_damage)
    TextView tvDamage;

    @BindView(R.id.tv_movement_speed)
    TextView tvMovementSpeed;

    @BindView(R.id.tv_armor)
    TextView tvArmor;

    @BindView(R.id.col_img_hero)
    ImageView imgHero;

    @BindView(R.id.tv_overview)
    MMExpendableTextView tvExpandableOverview;

    @BindView(R.id.tv_detail)
    MMExpendableTextView tvExpendableDetail;

    @BindView(R.id.rv_hero_spell)
    RecyclerView rvHeroSpell;

    private HeroVO heroVO;

    private HeroSpellListAdapter mAdapter;

    public static Intent newIntent(Context context, HeroVO heroVO){
        Intent intent = new Intent(context ,HeroDetailActivity.class);
        intent.putExtra(HERO, heroVO);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            collapsingToolbar.setTitleEnabled(false);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgHero.setTransitionName(getString(R.string.share_image_transition));
        }

        if (getIntent().getExtras() != null){

            heroVO = (HeroVO) getIntent().getSerializableExtra(HERO);

            if (heroVO != null){

                setupHeroSpellRecycler();

                bindData(heroVO);

            } else {
                throw new RuntimeException("Can't find obj");
            }

        }

    }

    public void setupHeroSpellRecycler(){

        mAdapter = new HeroSpellListAdapter(this, this);
        rvHeroSpell.setHasFixedSize(true);
        rvHeroSpell.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvHeroSpell.setAdapter(mAdapter);

    }

    @OnClick(R.id.btn_read_more_overview)
    public void displayOverView(View view){
        tvExpandableOverview.toggle();
        ((Button)view).setText(tvExpandableOverview.isExpanded()? R.string.read_more : R.string.read_less);
    }

    @OnClick(R.id.btn_read_more_detail)
    public void displayDetail(View view){
        tvExpendableDetail.toggle();
        ((Button)view).setText(tvExpendableDetail.isExpanded() ? R.string.read_more : R.string.read_less);
    }

    @OnClick(R.id.fab)
    public void shareHero(View view){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, heroVO.getShare_hero());
        startActivity(Intent.createChooser(shareIntent, "Share link using"));
    }

    private void bindData(HeroVO heroVO) {

        tvExpandableOverview.setText(heroVO.getHero_overview());
        tvExpendableDetail.setText(heroVO.getHero_detail());
        tvToolbarTitle.setText(heroVO.getHero_name());
        tvRole.setText(heroVO.getHero_role());
        tvIntelligence.setText(heroVO.getHero_intellgience());
        tvAgility.setText(heroVO.getHero_agility());
        tvStrength.setText(heroVO.getHero_strength());
        tvDamage.setText(heroVO.getHero_damage());
        tvMovementSpeed.setText(heroVO.getHero_movement_speed());
        tvArmor.setText(heroVO.getHero_armor());

        mAdapter.setNewData(heroVO.getHero_spell());

        Glide.with(this)
                .load(heroVO.getHero_image())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imgHero);

    }

    @Override
    public void onTapSpell(HeroSpellVO heroSpellVO) {

        HeroSpellFragment heroSpellFragment = HeroSpellFragment.newInstance(heroSpellVO.getSpell_overview());
        heroSpellFragment.setTitle(heroSpellVO.getSpell_name());
        heroSpellFragment.show(getSupportFragmentManager(), "hero_spell_fragment");

    }
}
