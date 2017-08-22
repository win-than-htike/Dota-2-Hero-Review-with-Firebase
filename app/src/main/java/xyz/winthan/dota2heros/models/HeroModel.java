package xyz.winthan.dota2heros.models;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import xyz.winthan.dota2heros.Dota2App;
import xyz.winthan.dota2heros.events.DataEvent;
import xyz.winthan.dota2heros.utils.Constants;
import xyz.winthan.dota2heros.vos.HeroVO;

/**
 * Created by winthanhtike on 8/21/17.
 */

public class HeroModel {

    private static HeroModel objInstance;

    private DatabaseReference mDatabaseReference;
    private DatabaseReference mHeroes;

    private HeroModel(){
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public static HeroModel getInstance(){
        if (objInstance == null){
            objInstance = new HeroModel();
        }
        return objInstance;
    }

    public void loadHeros(final String heroType){

        mHeroes = mDatabaseReference.child(heroType);
        mHeroes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<HeroVO> heroVOList = new ArrayList<HeroVO>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    HeroVO heroVO = snapshot.getValue(HeroVO.class);
                    heroVOList.add(heroVO);
                }

                postData(heroType, heroVOList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                EventBus.getDefault().post(new DataEvent.ErrorLoadedEvent(databaseError.getMessage()));
            }
        });

    }

    private void postData(String heroType, List<HeroVO> heroList){

        switch (heroType) {

            case Constants.STRENGTH:
                EventBus.getDefault().post(new DataEvent.StrengthHeroDataLoadedEvent(heroList));
                break;

            case Constants.AGILITY:
                EventBus.getDefault().post(new DataEvent.AgilityHeroDataLoadedEvent(heroList));
                break;

            case Constants.INTELLIGENCE:
                EventBus.getDefault().post(new DataEvent.IntelligenceHeroDataLoadedEvent(heroList));
                break;

            default:
                Log.i(Dota2App.TAG, " Unknow Hero Type");
                break;

        }

    }

}
