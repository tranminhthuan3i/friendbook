package com.iii.adapter;

import java.util.ArrayList;

import com.iii.model.Quote;
import com.iii.model.category;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterQuoDetail extends BaseAdapter {
	private ArrayList<Quote> listQuote;
	private Activity context;

	public AdapterQuoDetail(ArrayList<Quote> listQuote,
			Activity context) {
		super();
		this.listQuote = listQuote;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listQuote.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return listQuote.get(arg0);
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
					com.iii.sos.R.layout.item_quotationdetail_layout, null);
			holder.txtQuoteEng = (TextView) convertView
					.findViewById(com.iii.sos.R.id.txtQuoDetailEng);
			holder.txtQuoteVn = (TextView) convertView
					.findViewById(com.iii.sos.R.id.txtQuoDetailVN);
			holder.txtAuthor = (TextView) convertView
					.findViewById(com.iii.sos.R.id.txtAuthor);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Quote quote = listQuote.get(arg0);
		holder.txtQuoteEng.setText(quote.getQuoteEng());
		holder.txtQuoteVn.setText(quote.getQuoteVn());
		holder.txtAuthor.setText(quote.getAuthor());

		return convertView;
	}

	class ViewHolder {
		TextView txtQuoteVn,txtQuoteEng, txtAuthor;
	}

}
