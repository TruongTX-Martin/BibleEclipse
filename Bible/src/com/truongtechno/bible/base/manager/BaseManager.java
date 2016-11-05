package com.truongtechno.bible.base.manager;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Constant;
import com.truongtechno.bible.database.DatabaseHandler;
import com.truongtechno.bible.menutop.controller.MenuTopController;
import com.truongtechno.bible.slidemenu.controller.PhoneSlideMenuController;


public class BaseManager {
	private PhoneSlideMenuController mSlideMenuController;
	private Activity mCurrentActivity;
	private static BaseManager instance;
	private Context mCurrentContext;
	protected MenuTopController mMenuTopController;
	private FragmentManager mManager;
	private DatabaseHandler databaseHandler;
	
	public static BaseManager getIntance() {
		if (null == instance) {
			instance = new BaseManager();
		}
		return instance;
	}
	
	public void setDatabaseHandler(DatabaseHandler databaseHandler) {
		this.databaseHandler = databaseHandler;
	}
	
	public DatabaseHandler getDatabaseHandler() {
		return databaseHandler;
	}

	public Context getCurrentContext() {
		return mCurrentContext;
	}

	public Activity getCurrentActivity() {
		return mCurrentActivity;
	}

	public void setCurrentActivity(Activity mCurrentActivity) {
		this.mCurrentActivity = mCurrentActivity;
	}

	public void setCurrentContext(Context mCurrentContext) {
		this.mCurrentContext = mCurrentContext;
	}

	public void setChildFragment(FragmentManager childFragment) {
		mManager = childFragment;
	}

	public FragmentManager getChilFragmentManager() {
		return mManager;
	}

	public FragmentManager getManager() {
		return mManager;
	}

	public void setManager(FragmentManager mManager) {
		this.mManager = mManager;
	}

	

	public void setSlideMenuController(PhoneSlideMenuController controller) {
		mSlideMenuController = controller;
	}

	public void setmMenuTopController(MenuTopController mMenuTopController) {
		this.mMenuTopController = mMenuTopController;
	}

	public Fragment getCurrentFragment() {
		List<Fragment> fragments = mManager.getFragments();
		for (Fragment fragment : fragments) {
			if (fragment != null && fragment.isVisible()) {
				return fragment;
			}
		}
		return null;
	}

	public void addFragment(BaseFragment fragment) {
		if (null != mManager) {
			String nameFragment = fragment.getClass().getName();
			FragmentTransaction ft = mManager.beginTransaction();
			ft.setCustomAnimations(
					R.anim.in_from_right,
					R.anim.out_to_left,
					R.anim.in_from_left,
					R.anim.out_to_right
			);
			ft.replace(R.id.container, fragment);
			ft.addToBackStack(nameFragment);
			ft.commit();
			mManager.executePendingTransactions();
		}
	}

	public void replaceFragment(BaseFragment fragment) {
		System.out.println(mManager);
		if (mManager != null) {
			String nameFragment = fragment.getClass().getName();
			boolean isHome = false;
			String screen_name = fragment.getScreenName();
			if (null != screen_name && screen_name.equals(Constant.SCREEN_HOME)) {
				isHome = true;
			}

			mManager.popBackStack(nameFragment,
					FragmentManager.POP_BACK_STACK_INCLUSIVE);
			FragmentTransaction fragmentTransaction = mManager
					.beginTransaction();
			if (!isHome) {
				fragmentTransaction.setCustomAnimations(
						R.anim.in_from_right,
						R.anim.out_to_left,
						R.anim.in_from_left,
						R.anim.out_to_right);
			}
			fragmentTransaction.replace(
					R.id.container, fragment);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}

	}

}
