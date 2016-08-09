package com.truongtechno.bible.fragment;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.truongtechno.bible.R;
import com.truongtechno.bible.adapter.AdapterBible;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Config;
import com.truongtechno.bible.entity.ItemBible;

public class FragmentTanUoc extends BaseFragment{
	
	private ListView lvTanUoc;
	private List<ItemBible> listTanUoc;
	private AdapterBible mAdapter;
	private Context mContext;
	public static FragmentTanUoc newInstance() {
		FragmentTanUoc tanUoc = new FragmentTanUoc();
		return tanUoc;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.layout_fragment_tanuoc,
				container, false);
		mContext = getActivity().getApplicationContext();
		lvTanUoc = (ListView) rootView.findViewById(R.id.lvTanUoc);
		listTanUoc = Config.getInstance().getListTanUoc();
		mAdapter = new AdapterBible(mContext, listTanUoc);
		lvTanUoc.setAdapter(mAdapter);
		return rootView;
	}

}
