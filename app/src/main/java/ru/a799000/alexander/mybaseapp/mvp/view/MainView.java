package ru.a799000.alexander.mybaseapp.mvp.view;

import com.arellomobile.mvp.MvpView;


import ru.a799000.alexander.mybaseapp.ui.fragment.BaseFragment;

public interface MainView extends MvpView {
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
