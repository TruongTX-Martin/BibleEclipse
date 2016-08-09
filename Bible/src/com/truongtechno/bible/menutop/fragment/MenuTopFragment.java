package com.truongtechno.bible.menutop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.base.manager.BaseManager;
import com.truongtechno.bible.config.Config;
import com.truongtechno.bible.menutop.block.MenuTopBlock;
import com.truongtechno.bible.menutop.controller.MenuTopController;
import com.truongtechno.bible.slidemenu.fragment.SlideMenuFragment;


public class MenuTopFragment extends BaseFragment {
    public View rootView;
    protected MenuTopBlock mBlock;
    protected MenuTopController mController;
    protected SlideMenuFragment mNavigationDrawerFragment;

    public static MenuTopFragment newInstance(SlideMenuFragment mNavigationDrawerFragment) {
        MenuTopFragment fragment = new MenuTopFragment();
        fragment.mNavigationDrawerFragment = mNavigationDrawerFragment;
        return fragment;
    }

    public MenuTopFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.core_menu_top, container, false);
        rootView.setBackgroundColor(Config.getInstance().getColorMain());
        Context mContext = getActivity();
        mBlock = new MenuTopBlock(rootView, mContext);
        mBlock.initView();
        if (mController == null) {
            mController = new MenuTopController();
            mController.setSlideMenu(mNavigationDrawerFragment);
            mController.setMenuTopDelegate(mBlock);
            mController.onStart();
        } else {

        }
        mBlock.setOnTouchMenu(mController.getTouchMenu());
        BaseManager.getIntance().setmMenuTopController(mController);
        return rootView;
    }
}
