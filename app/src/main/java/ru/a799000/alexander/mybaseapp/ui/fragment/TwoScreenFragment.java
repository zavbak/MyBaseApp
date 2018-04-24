package ru.a799000.alexander.mybaseapp.ui.fragment;

import ru.a799000.alexander.mybaseapp.R;

public class TwoScreenFragment extends BaseFragment {
    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_screen_two;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_two;
    }
}
