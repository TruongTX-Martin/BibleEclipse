package com.truongtechno.bible.slidemenu.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.base.manager.BaseManager;
import com.truongtechno.bible.slidemenu.block.PhoneSlideMenuBlock;
import com.truongtechno.bible.slidemenu.controller.PhoneSlideMenuController;
import com.truongtechno.bible.slidemenu.delegate.CloseSlideMenuDelegate;


public class PhoneSlideMenuFragment extends BaseFragment {
	protected CloseSlideMenuDelegate mCLoseDelegate;
	protected PhoneSlideMenuController mController;
	protected PhoneSlideMenuBlock mBlock;
	public void setCloseDelegate(CloseSlideMenuDelegate mCLoseDelegate) {
		this.mCLoseDelegate = mCLoseDelegate;
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.core_phone_slide_menu, null,
				false);
		Context context = getActivity();
		mBlock = new PhoneSlideMenuBlock(view, context);
		mBlock.initView();
		
		mController = new PhoneSlideMenuController(mBlock, context);
		mController.setCloseDelegate(mCLoseDelegate);
		mController.create();
		
		mBlock.setListener(mController.getListener());
		BaseManager.getIntance().setSlideMenuController(mController);
		return view;
	}
}
