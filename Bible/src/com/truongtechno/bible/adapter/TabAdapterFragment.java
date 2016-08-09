package com.truongtechno.bible.adapter;

import java.util.ArrayList;

import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Constant;
import com.truongtechno.bible.fragment.FragmentCuuUoc;
import com.truongtechno.bible.fragment.FragmentTanUoc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabAdapterFragment extends FragmentStatePagerAdapter {
	protected ArrayList<BaseFragment> mListFragment;
	protected ArrayList<String> mListTitle;

	public TabAdapterFragment(FragmentManager fm) {
		super(fm);
		mListFragment = new ArrayList<BaseFragment>();
		mListTitle = new ArrayList<String>();
		addFragment();
		addTitle();
	}

	@Override
	public Fragment getItem(int position) {
		return mListFragment.get(position);
	}

	@Override
	public int getCount() {
		return mListFragment.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mListTitle.get(position);
	}

	private void addFragment() {
		FragmentTanUoc frm_tanuoc = FragmentTanUoc.newInstance();
		FragmentCuuUoc frm_cuuuoc = FragmentCuuUoc.newIntance();
		mListFragment.add(frm_tanuoc);
		mListFragment.add(frm_cuuuoc);
	}

	private void addTitle() {
		mListTitle.add(Constant.ITEM_TANUOC);
		mListTitle.add(Constant.ITEM_CUUUOC);
	}

}
