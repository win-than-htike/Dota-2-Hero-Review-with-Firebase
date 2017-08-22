package xyz.winthan.dota2heros;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import xyz.winthan.dota2heros.models.HeroModel;

/**
 * Created by winthanhtike on 8/21/17.
 */

public class Dota2App extends Application {

    public static final String TAG = Dota2App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
