package com.truongtechno.bible.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truongtechno.bible.R;
import com.truongtechno.bible.adapter.TabAdapterFragment;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Config;
import com.truongtechno.bible.config.Constant;
import com.truongtechno.bible.style.PagerSlidingTabStrip;


public class FragmentHome extends BaseFragment {

	public static FragmentHome newInstance() {
		FragmentHome fragment = new FragmentHome();
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setScreenName(Constant.SCREEN_HOME);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.layout_fragment_home,
				container, false);
		initView(rootView);
		return rootView;
	}

	public void initView(View mRootView) {
		final TabAdapterFragment adapter = new TabAdapterFragment(
				getChildFragmentManager());
		final ViewPager mPager = (ViewPager) mRootView.findViewById(R.id.pager);
		mPager.setAdapter(adapter);

		PagerSlidingTabStrip title_tab = (PagerSlidingTabStrip) mRootView
				.findViewById(R.id.pager_title_strip);
		title_tab.setTextColor(Config.getInstance().getSection_text_color());
		title_tab.setBackgroundColor(Color.parseColor(Config.getInstance()
				.getSection_color()));
		title_tab.setDividerColor(Config.getInstance().getSection_text_color());
		title_tab.setIndicatorColor(Config.getInstance().getKey_color());
		title_tab.setIndicatorHeight(5);
		title_tab.setAllCaps(false);
		title_tab.setViewPager(mPager);
	}
}
