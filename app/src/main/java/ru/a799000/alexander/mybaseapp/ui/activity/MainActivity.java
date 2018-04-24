package ru.a799000.alexander.mybaseapp.ui.activity;


import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import ru.a799000.alexander.mybaseapp.MyApplication;
import ru.a799000.alexander.mybaseapp.R;
import ru.a799000.alexander.mybaseapp.mvp.presenter.MainPresenter;
import ru.a799000.alexander.mybaseapp.mvp.view.MainView;
import ru.a799000.alexander.mybaseapp.ui.fragment.BaseFragment;
import ru.a799000.alexander.mybaseapp.ui.fragment.OneScreenFragment;

public class MainActivity extends BaseActivity implements MainView{

    @InjectPresenter
    MainPresenter mPresenter;

    private Drawer mDrawer;

    private AccountHeader mAccountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setUpDrawer();
        showFragmentFromDrawer(new OneScreenFragment());

    }


    public void setUpDrawer() {

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Screen 1")
                .withIcon(GoogleMaterial.Icon.gmd_home);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Screen 2")
                .withIcon(GoogleMaterial.Icon.gmd_list);

        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Screen 3")
                .withIcon(GoogleMaterial.Icon.gmd_settings).withSelectable(false);

        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Screen 4")
                .withIcon(GoogleMaterial.Icon.gmd_people).withSelectable(false);

        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Screen 5")
                .withIcon(GoogleMaterial.Icon.gmd_record_voice_over).withSelectable(false);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName("Screen 6")
                .withIcon(GoogleMaterial.Icon.gmd_info).withSelectable(false);

        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName("Screen 7")
                .withIcon(GoogleMaterial.Icon.gmd_assignment).withSelectable(false);

        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(item1, item2, item3,
                        new SectionDrawerItem().withName("Группа"),
                        item4, item5, item6, item7)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    mPresenter.drawerItemClick((int) drawerItem.getIdentifier());
                    return false;
                })
                .build();

    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showFragmentFromDrawer(BaseFragment baseFragment) {
        setContent(baseFragment);
    }

}
