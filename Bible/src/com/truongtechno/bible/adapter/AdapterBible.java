package com.truongtechno.bible.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.truongtechno.bible.R;
import com.truongtechno.bible.entity.ItemBible;

public class AdapterBible extends BaseAdapter{

	private List<ItemBible> listTanUoc;
	private Context context;
	
	public AdapterBible(Context context,List<ItemBible> list) {
		this.context = context;
		this.listTanUoc = list;
	}
	@Override
	public int getCount() {
		return listTanUoc.size();
	}

	@Override
	public Object getItem(int position) {
		return listTanUoc.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(
					R.layout.layout_item_tanuoc, null);
			holder = new ViewHolder();
			holder.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
			holder.imgExtend = (ImageView) convertView.findViewById(R.id.img_expand);
			holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ItemBible item = (ItemBible) getItem(position);
		holder.txtName.setText(item.getName());
		return convertView;
	}

	private static class ViewHolder {
		ImageView imgIcon;
		ImageView imgExtend;
		TextView txtName;
	}

}
