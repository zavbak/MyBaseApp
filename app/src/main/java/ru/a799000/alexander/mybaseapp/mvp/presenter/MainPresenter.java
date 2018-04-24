package ru.a799000.alexander.mybaseapp.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;


import ru.a799000.alexander.mybaseapp.MyApplication;
import ru.a799000.alexander.mybaseapp.common.manager.MyFragmentManager;
import ru.a799000.alexander.mybaseapp.mvp.view.MainView;
import ru.a799000.alexander.mybaseapp.ui.fragment.BaseFragment;
import ru.a799000.alexander.mybaseapp.ui.fragment.OneScreenFragment;
import ru.a799000.alexander.mybaseapp.ui.fragment.TwoScreenFragment;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    MyFragmentManager myFragmentManager;


    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }


    public void drawerItemClick(int id) {
        BaseFragment fragment = null;

        switch (id) {
            case 1:
                fragment = new OneScreenFragment();
                break;
            case 2:
                fragment = new TwoScreenFragment();
                break;
        }

        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)) {
            getViewState().showFragmentFromDrawer(fragment);
        }

    }


}