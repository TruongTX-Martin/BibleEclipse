package com.truongtechno.bible.fragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.truongtechno.bible.R;
import com.truongtechno.bible.base.fragment.BaseFragment;
import com.truongtechno.bible.config.Constant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentHome extends BaseFragment {

	public static FragmentHome newInstance() {
		FragmentHome fragment = new FragmentHome();
		return fragment;
	}

	private Context mContext;
	private Button btnImport;
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
		mContext = getActivity().getApplicationContext();
		btnImport = (Button) rootView.findViewById(R.id.btnImport);
		btnImport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				importData();
			}
		});
		return rootView;
	}
	
	private void importData() {
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(
		        new InputStreamReader(mContext.getAssets().open("TanUoc/1giang.txt"), "UTF-8")); 

		    // do reading, usually loop until end of file reading 
		    String mLine = "";
		    StringBuilder text = new StringBuilder();
		    while ((mLine = reader.readLine()) != null) {
		       //process line
		    	text.append(mLine);
		        text.append('\n');
		    }
		    System.out.println(text);
		    if(text.toString().contains("phandoan")) {
		    	String[] arrayDoan = text.toString().split("phandoan");
		    	if(arrayDoan.length > 0) {
		    		System.out.println("So Chuong la :" + arrayDoan.length);
		    		for(int i=0; i< arrayDoan.length ; i++) {
		    			String sentence = arrayDoan[i];
		    			if(sentence.contains("phancau")) {
		    				String[] arrayCau = sentence.split("phancau");
		    				System.out.println("Chuong " + i + "co " + arrayCau.length + "Cau");
		    			}
		    		}
		    	}
 		    }
		} catch (Exception e) {
		    //log the exception
			System.out.println("Exception:" + e.getMessage());
		} 

	}

}
