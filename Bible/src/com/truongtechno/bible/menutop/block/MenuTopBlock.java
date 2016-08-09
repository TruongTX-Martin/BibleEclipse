package com.truongtechno.bible.menutop.block;

import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.block.BaseBlock;
import com.truongtechno.bible.menutop.delegate.MenuTopDelegate;

public class MenuTopBlock extends BaseBlock implements MenuTopDelegate {
	protected View view;
	protected Context context;
	protected ImageView imv_menu;
	protected Button btn_cartnavigation;
	protected RelativeLayout layout_cart;
	
	public static MenuTopBlock newInstance(View v,Context context){
		MenuTopBlock menuBlock = new MenuTopBlock(v, context);
		return menuBlock;
	}
	
	public MenuTopBlock(View v, Context mcontext) {
		super(v, mcontext);
		this.view = v;
		this.context = mcontext;
	}
	
	public MenuTopBlock() {
		super();
	}

	@Override
	public void initView() {
		initButtonMenu();
	}
	
	private void initButtonMenu() {
		imv_menu = (ImageView) mView.findViewById(R.id.img_menu);
	}
	public void setOnTouchMenu(OnTouchListener touchMenu) {
		imv_menu.setOnTouchListener(touchMenu);
	}

	@Override
	public void controllCartLayout() {
		// TODO Auto-generated method stub
		if (layout_cart.getVisibility() == View.VISIBLE) {
			layout_cart.setVisibility(View.GONE);
		} else {
			layout_cart.setVisibility(View.VISIBLE);
		}
	}
}
