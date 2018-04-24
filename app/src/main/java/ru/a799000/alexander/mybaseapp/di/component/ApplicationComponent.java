package ru.a799000.alexander.mybaseapp.di.component;

import javax.inject.Singleton;

import dagger.Component;

import ru.a799000.alexander.mybaseapp.di.module.ApplicationModule;
import ru.a799000.alexander.mybaseapp.di.module.ManagerModule;
import ru.a799000.alexander.mybaseapp.mvp.presenter.MainPresenter;
import ru.a799000.alexander.mybaseapp.ui.activity.BaseActivity;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {

    //activity
    void inject(BaseActivity activity);

    //presenter
    void inject(MainPresenter mainPresenter);
}
