package ru.a799000.alexander.mybaseapp.ui.fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.a799000.alexander.mybaseapp.R;
import ru.a799000.alexander.mybaseapp.mvp.presenter.ScreenOnePr;
import ru.a799000.alexander.mybaseapp.mvp.view.ScreenOneFrView;

public class OneScreenFragment extends BaseFragment implements ScreenOneFrView{

    @InjectPresenter
    ScreenOnePr mPresenter;

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_screen_one;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_one;
    }
}
