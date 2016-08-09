package com.truongtechno.bible.slidemenu.controller;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.controller.BaseController;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.base.manager.BaseManager;
import com.truongtechno.bible.config.Constant;
import com.truongtechno.bible.fragment.FragmentHome;
import com.truongtechno.bible.slidemenu.delegate.CloseSlideMenuDelegate;
import com.truongtechno.bible.slidemenu.delegate.SlideMenuDelegate;
import com.truongtechno.bible.slidemenu.entity.ItemNavigation;

public class PhoneSlideMenuController extends BaseController {

	protected CloseSlideMenuDelegate mCloseDelegate;
	protected Context mContext;
	protected SlideMenuDelegate mDelegate;
	protected OnItemClickListener mListener;
	protected ArrayList<ItemNavigation> mItems = new ArrayList<ItemNavigation>();
	protected int DEFAULT_POSITION = 0;

	public PhoneSlideMenuController(SlideMenuDelegate delegate, Context context) {
		mDelegate = delegate;
		mContext = context;
		mItems = new ArrayList<ItemNavigation>();
	}

	public void setCloseDelegate(CloseSlideMenuDelegate delegate) {
		mCloseDelegate = delegate;
	}

	public OnItemClickListener getListener() {
		return mListener;
	}

	public void closeSlideMenutab() {
		mCloseDelegate.closeSlideMenu();
	}

	public void setListener(OnItemClickListener mListener) {
		this.mListener = mListener;
	}


	@Override
	public void onStart() {
	}

	public void create() {

		mListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				onNaviagte(position);
				// mMenuTopDelegate.controllCartLayout();
			}

		};


		initial();
	}

	private void initial() {
		initDataAdapter();
		mDelegate.setAdapter(mItems);
		onNaviagte(DEFAULT_POSITION);
	}

	public void initDataAdapter() {
		addDocKinhThanh();
		addNgheKinhThanh();
		addThanhKinhThongLam();
		addPhongTucXuThanh();
	}


	private void addDocKinhThanh(){
		int index = checkElement(Constant.ITEM_DOC_KINHTHANH);
		if (index == -1) {
			ItemNavigation item = new ItemNavigation();
			item.setName(Constant.ITEM_DOC_KINHTHANH);
			int id_icon = R.drawable.ic_menu_home;
			Drawable icon = mContext.getResources().getDrawable(id_icon);
			icon.setColorFilter(Color.parseColor("#ffffff"),
					PorterDuff.Mode.SRC_ATOP);
			item.setDrawble(icon);
			mItems.add(item);
		}
	}
	private void addNgheKinhThanh(){
		int index = checkElement(Constant.ITEM_NGHE_KINHTHANH);
		if (index == -1) {
			ItemNavigation item = new ItemNavigation();
			item.setName(Constant.ITEM_NGHE_KINHTHANH);
			int id_icon = R.drawable.ic_menu_home;
			Drawable icon = mContext.getResources().getDrawable(id_icon);
			icon.setColorFilter(Color.parseColor("#ffffff"),
					PorterDuff.Mode.SRC_ATOP);
			item.setDrawble(icon);
			mItems.add(item);
		}
	}
	private void addThanhKinhThongLam(){
		int index = checkElement(Constant.ITEM_THANHKINH_THONGLAM);
		if (index == -1) {
			ItemNavigation item = new ItemNavigation();
			item.setName(Constant.ITEM_THANHKINH_THONGLAM);
			int id_icon = R.drawable.ic_menu_home;
			Drawable icon = mContext.getResources().getDrawable(id_icon);
			icon.setColorFilter(Color.parseColor("#ffffff"),
					PorterDuff.Mode.SRC_ATOP);
			item.setDrawble(icon);
			mItems.add(item);
		}
	}

	private void addPhongTucXuThanh(){
		int index = checkElement(Constant.ITEM_PHONGTUC_XUTHANH);
		if (index == -1) {
			ItemNavigation item = new ItemNavigation();
			item.setName(Constant.ITEM_PHONGTUC_XUTHANH);
			int id_icon = R.drawable.ic_menu_home;
			Drawable icon = mContext.getResources().getDrawable(id_icon);
			icon.setColorFilter(Color.parseColor("#ffffff"),
					PorterDuff.Mode.SRC_ATOP);
			item.setDrawble(icon);
			mItems.add(item);
		}
	}


	public void onNaviagte(int position) {
		ItemNavigation item = mItems.get(position);
		if (null != item) {
			BaseFragment fragment = null;
			fragment = navigateNormal(item);
			if(fragment != null) {
				BaseManager.getIntance().replaceFragment(fragment);
			}
		}
		mDelegate.onSelectedItem(position);
		if (mCloseDelegate != null) {
			mCloseDelegate.closeSlideMenu();
		}
	}

	public BaseFragment navigateNormal(ItemNavigation item) {
		BaseFragment fragment = null;
		String name = item.getName();
		switch (name) {
		case Constant.ITEM_DOC_KINHTHANH:
			fragment = FragmentHome.newInstance();
			break;
		case "Category":
			break;
		default:
			break;
		}
		return fragment;
	}

	protected int checkElement(String name) {
		if (null != mItems || mItems.size() > 0) {
			for (int i = 0; i < mItems.size(); i++) {
				ItemNavigation item = mItems.get(i);
				if (item.getName().equals(name)) {
					return i;
				}
			}
			return -1;
		}
		return -1;
	}

	@Override
	public void onResume() {
		
	}
}
