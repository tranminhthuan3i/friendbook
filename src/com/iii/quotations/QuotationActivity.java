package com.iii.quotations;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.iii.adapter.AdapterQuotation;
import com.iii.model.category;
import com.iii.quotations.QuotationDetail.OnHeaderSelectedListener;
import com.iii.sos.ActionMenuItem;
import com.iii.sos.QuickMenuAction;
import com.iii.sos.R;

public class QuotationActivity extends Activity implements OnItemClickListener, OnClickListener {
	private ListView lsvQuotation;
	private AdapterQuotation adapterQuotation;
	private ArrayList<category> lstCategories;
	private ImageView imgvMore_quo;
	private QuickMenuAction quickAction;
	private static final int ID_SETTING = 1;
	private static final int ID_SHARE = 2;
	private static final int ID_CONTRIBUTE = 3;
	private static final int ID_INFO = 4;
	OnHeaderSelectedListener mCallback;

	public interface OnHeaderSelectedListener {
		/** Called by HeadlinesFragment when a list item is selected */
		public void onMenuButtonClick(int btnKey, View view);

		public void updateLanguage(String languageKey, View view);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quotations_layout);
		loadUI();
	}

	private void loadUI() {
		lsvQuotation = (ListView) findViewById(R.id.lisviewQuo);
		imgvMore_quo = (ImageView) findViewById(R.id.imgvMore_quo);

		ActionMenuItem settingItem = new ActionMenuItem(ID_SETTING, "Cai dat",
				getResources().getDrawable(R.drawable.menu_setting));
		ActionMenuItem shareItem = new ActionMenuItem(ID_SHARE, "Chia se",
				getResources().getDrawable(R.drawable.menu_share));
		ActionMenuItem contributeItem = new ActionMenuItem(ID_CONTRIBUTE,
				"Dong gop", getResources().getDrawable(R.drawable.menu_comment));
		ActionMenuItem infoItem = new ActionMenuItem(ID_INFO, "Thong tin",
				getResources().getDrawable(R.drawable.menu_info));

		quickAction = new QuickMenuAction(QuotationActivity.this,
				QuickMenuAction.VERTICAL);
		quickAction.addActionItem(settingItem);
		quickAction.addActionItem(shareItem);
		quickAction.addActionItem(contributeItem);
		quickAction.addActionItem(infoItem);

		lstCategories = new ArrayList<category>();
		createArray();
		adapterQuotation = new AdapterQuotation(lstCategories,
				QuotationActivity.this);
		lsvQuotation.setAdapter(adapterQuotation);
		lsvQuotation.setOnItemClickListener(this);
		loadData();

	}

	private void loadData() {
		imgvMore_quo.setOnClickListener(this);
	}

	private void createArray() {
		category cate1 = new category("Thanh cong", null,
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(cate1);

		category cate2 = new category("Cuoc song", null,
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(cate2);

		category cate3 = new category("Thoi gian", null,
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(cate3);

		category cate4 = new category("Hanh phuc", null,
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(cate4);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {
		Intent intent = new Intent(QuotationActivity.this,
				QuotationDetail.class);
		startActivity(intent);

	}

	@Override
	public void onClick(View v) {
		int btnKey = v.getId();
		if (quickAction != null) {
			if (R.id.imgvMore_quo == btnKey) {
				quickAction.show(v);
			}
		}
		switch (btnKey) {
		case R.id.imgvMore_quo:
			btnKey = 3;
			break;

		default:
			break;
		}
		
	}

}
