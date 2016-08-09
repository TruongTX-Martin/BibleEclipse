package com.truongtechno.bible.fragment;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.truongtechno.bible.R;
import com.truongtechno.bible.adapter.AdapterBible;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Config;
import com.truongtechno.bible.entity.ItemBible;

public class FragmentCuuUoc extends BaseFragment {

	private ListView lvCuuUoc;
	private List<ItemBible> listCuuUoc;
	private AdapterBible mAdapter;
	private Context mContext;
	public static FragmentCuuUoc newIntance() {
		FragmentCuuUoc fragment = new FragmentCuuUoc();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.layout_fragment_cuuuoc,
				container, false);
		lvCuuUoc = (ListView) rootView.findViewById(R.id.lvCuuUoc);
		mContext = getActivity().getApplicationContext();
		listCuuUoc = Config.getInstance().getListCuuUoc();
		mAdapter = new AdapterBible(mContext, listCuuUoc);
		lvCuuUoc.setAdapter(mAdapter);
		return rootView;
	}

}
