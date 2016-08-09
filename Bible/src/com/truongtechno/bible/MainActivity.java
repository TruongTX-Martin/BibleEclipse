package com.truongtechno.bible;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import com.truongtechno.bible.base.manager.BaseManager;
import com.truongtechno.bible.menutop.fragment.MenuTopFragment;
import com.truongtechno.bible.slidemenu.fragment.SlideMenuFragment;

public class MainActivity extends FragmentActivity {

    private SlideMenuFragment mNavigationDrawerFragment;
    public static Activity context;
    public static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseManager.getIntance().setCurrentActivity(this);
        BaseManager.getIntance().setCurrentContext(
                getApplicationContext());
        context = this;
        try {
            setContentView(R.layout.core_main_activity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mNavigationDrawerFragment = (SlideMenuFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setup(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        FragmentTransaction mFragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        MenuTopFragment fragmentMenuTop = MenuTopFragment
                .newInstance(mNavigationDrawerFragment);
        mFragmentTransaction.replace(
                R.id.menu_top, fragmentMenuTop);
        mFragmentTransaction.commit();

        BaseManager.getIntance()
                .setManager(getSupportFragmentManager());
    }
}
