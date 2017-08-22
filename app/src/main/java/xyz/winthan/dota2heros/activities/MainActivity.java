package xyz.winthan.dota2heros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winthan.dota2heros.R;
import xyz.winthan.dota2heros.activities.base.BaseActivity;
import xyz.winthan.dota2heros.adapters.ViewPagerAdapter;
import xyz.winthan.dota2heros.fragments.AgilityFragment;
import xyz.winthan.dota2heros.fragments.IntelligenceFragment;
import xyz.winthan.dota2heros.fragments.StrengthFragment;
import xyz.winthan.dota2heros.utils.clicklistener.OnHeroItemClickListener;
import xyz.winthan.dota2heros.vos.HeroVO;

public class MainActivity extends BaseActivity implements OnHeroItemClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragment(StrengthFragment.newInstance(), getString(R.string.strength));
        mAdapter.setFragment(AgilityFragment.newInstance(), getString(R.string.agility));
        mAdapter.setFragment(IntelligenceFragment.newInstance(), getString(R.string.intell));
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(mAdapter.getCount());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTapHero(ImageView imageView, HeroVO heroVO) {
        Intent heroDetailInten = HeroDetailActivity.newIntent(this, heroVO);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(imageView,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,heroDetailInten,activityOptions.toBundle());
    }
}
