package ru.a799000.alexander.mybaseapp;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ru.a799000.alexander.mybaseapp.di.component.ApplicationComponent;

import ru.a799000.alexander.mybaseapp.di.component.DaggerApplicationComponent;
import ru.a799000.alexander.mybaseapp.di.module.ApplicationModule;


public class MyApplication extends Application {


    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder, String tag) {
                Glide.with(imageView.getContext()).load(uri).into(imageView);
            }
        });

    }

    private void initComponent() {

        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
