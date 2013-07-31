package com.iii.adapter;

import java.util.ArrayList;

import com.iii.model.category;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterKeyed extends BaseAdapter {
	private ArrayList<category> listCategory;
	private Activity context;

	public AdapterKeyed(ArrayList<category> lstCategories,
			Activity context) {
		super();
		this.listCategory = lstCategories;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listCategory.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return listCategory.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = context.getLayoutInflater().inflate(
					com.iii.sos.R.layout.item_keyed_layout, null);
			holder.imgStt = (ImageView) convertView
					.findViewById(com.iii.sos.R.id.imgStt);
			holder.txtNameCategory = (TextView) convertView
					.findViewById(com.iii.sos.R.id.txtNameMucluc);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		category category = listCategory.get(arg0);
		holder.imgStt.setImageBitmap(category.getImageview());
		holder.txtNameCategory.setText(category.getName());

		return convertView;
	}

	class ViewHolder {
		TextView txtNameCategory;
		ImageView imgStt;
	}

}
