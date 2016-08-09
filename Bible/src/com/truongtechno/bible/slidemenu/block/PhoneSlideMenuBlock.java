package com.truongtechno.bible.slidemenu.block;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.truongtechno.bible.R;
import com.truongtechno.bible.slidemenu.adapter.SlideMenuAdapter;
import com.truongtechno.bible.slidemenu.delegate.SlideMenuDelegate;
import com.truongtechno.bible.slidemenu.entity.ItemNavigation;

public class PhoneSlideMenuBlock implements SlideMenuDelegate {
	protected ListView list_navigation;
	protected View mView;
	protected Context mContext;
	protected SlideMenuAdapter mAdapter;

	public PhoneSlideMenuBlock(View mView, Context mContext) {
		super();
		this.mView = mView;
		this.mContext = mContext;
	}

	public void setListener(OnItemClickListener listener) {
		list_navigation.setOnItemClickListener(listener);
	}

	@Override
	public void onSelectedItem(int position) {
		// TODO Auto-generated method stub
		list_navigation.setItemChecked(position, true);
	}

	public void initView() {
		list_navigation = (ListView) mView.findViewById(R.id.lv_navigation
		);
	}

	@Override
	public void onRefresh() {

	}

	public void setClicker(OnItemClickListener clicker) {
		list_navigation.setOnItemClickListener(clicker);
	}

	@Override
	public void setAdapter(ArrayList<ItemNavigation> items) {
		// TODO Auto-generated method stub
		mAdapter = new SlideMenuAdapter(items, mContext);
		list_navigation.setAdapter(mAdapter);
	}

}
