package com.truongtechno.bible.fragment;

import com.truongtechno.bible.R;
import com.truongtechno.bible.adapter.TabAdapterFragment;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Config;
import com.truongtechno.bible.style.PagerSlidingTabStrip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentReadBible extends BaseFragment {

	public static FragmentReadBible newInstance() {
		FragmentReadBible fragmentReadBible = new FragmentReadBible();
		return fragmentReadBible;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.layout_fragment_readbible, container, false);
		initView(rootView);
		
		return rootView;
	}

	public void initView(View mRootView) {
		final TabAdapterFragment adapter = new TabAdapterFragment(getChildFragmentManager());
		final ViewPager mPager = (ViewPager) mRootView.findViewById(R.id.pager);
		mPager.setAdapter(adapter);

		PagerSlidingTabStrip title_tab = (PagerSlidingTabStrip) mRootView.findViewById(R.id.pager_title_strip);
		title_tab.setTextColor(Config.getInstance().getSection_text_color());
		title_tab.setBackgroundColor(Color.parseColor(Config.getInstance().getSection_color()));
		title_tab.setDividerColor(Config.getInstance().getSection_text_color());
		title_tab.setIndicatorColor(Config.getInstance().getKey_color());
		title_tab.setIndicatorHeight(5);
		title_tab.setAllCaps(false);
		title_tab.setViewPager(mPager);
	}

}
