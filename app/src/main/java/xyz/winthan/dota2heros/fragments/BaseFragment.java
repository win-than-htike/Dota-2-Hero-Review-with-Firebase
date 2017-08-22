package xyz.winthan.dota2heros.fragments;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.winthan.dota2heros.events.DataEvent;
import xyz.winthan.dota2heros.utils.clicklistener.OnHeroItemClickListener;

/**
 * Created by winthanhtike on 8/21/17.
 */

public abstract class BaseFragment extends Fragment {

    protected OnHeroItemClickListener heroItemClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        heroItemClickListener = (OnHeroItemClickListener) context;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

    }

    @Override
    public void onStop() {
        super.onStop();

        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }

    }

    @Subscribe
    public void event(Object o){}

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void errorLoadedEvent(DataEvent.ErrorLoadedEvent event){
        Snackbar.make(getView(), event.getMessage(), Snackbar.LENGTH_LONG).show();
    }

}
