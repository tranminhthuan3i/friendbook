package com.iii.quotations;

import java.util.ArrayList;

import com.iii.adapter.AdapterQuoDetail;
import com.iii.adapter.AdapterQuotation;
import com.iii.model.Quote;
import com.iii.model.category;
import com.iii.sos.ActionMenuItem;
import com.iii.sos.KeyedActivity;
import com.iii.sos.QuickMenuAction;
import com.iii.sos.R;
import com.iii.sos.KeyedActivity.OnHeaderSelectedListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class QuotationDetail extends Activity implements OnClickListener{
	private ListView lsvQuotationDetail;
	private AdapterQuoDetail adapter;
	private ArrayList<Quote> lstQuote;
	private ImageView imgvMore_quoDetail;
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
		setContentView(R.layout.quotations_detail_layout);
		loadUI();
		
	}
	private void loadUI() {
		lsvQuotationDetail=(ListView)findViewById(R.id.lisviewQuoDetail);
		imgvMore_quoDetail=(ImageView)findViewById(R.id.imgvMore_quoDetail);
		ActionMenuItem settingItem = new ActionMenuItem(ID_SETTING, "Cai dat",
				getResources().getDrawable(R.drawable.menu_setting));
		ActionMenuItem shareItem = new ActionMenuItem(ID_SHARE, "Chia se",
				getResources().getDrawable(R.drawable.menu_share));
		ActionMenuItem contributeItem = new ActionMenuItem(ID_CONTRIBUTE,
				"Dong gop", getResources().getDrawable(R.drawable.menu_comment));
		ActionMenuItem infoItem = new ActionMenuItem(ID_INFO, "Thong tin",
				getResources().getDrawable(R.drawable.menu_info));

		quickAction = new QuickMenuAction(QuotationDetail.this,
				QuickMenuAction.VERTICAL);
		quickAction.addActionItem(settingItem);
		quickAction.addActionItem(shareItem);
		quickAction.addActionItem(contributeItem);
		quickAction.addActionItem(infoItem);
		
		
		
		lstQuote = new ArrayList<Quote>();
		createArray();
		adapter = new AdapterQuoDetail(lstQuote, QuotationDetail.this);
		lsvQuotationDetail.setAdapter(adapter);
		loadData();
	}
	private void loadData() {
		imgvMore_quoDetail.setOnClickListener(this);
		
	}
	private void createArray() {
	Quote quote1 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote1);
 	
	Quote quote2 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote2);
	
	Quote quote3 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote3);
	
	Quote quote4 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote4);
	
	Quote quote5 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote5);
	
	Quote quote7 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote7);
	
	Quote quote8 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote8);
	
	Quote quote9 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote9);
	
	Quote quote10 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote10);
	
	Quote quote11 = new Quote("As long as, you love me ","Mien la anh yeu em", "Somebody");
	lstQuote.add(quote11);
	}
	@Override
	public void onClick(View v) {
		int btnKey = v.getId();
		if (quickAction != null) {
			if (R.id.imgvMore_quoDetail == btnKey) {
				quickAction.show(v);
			}
		}
		switch (btnKey) {
		case R.id.imgvMore_quoDetail:
			btnKey = 3;
			break;

		default:
			break;
		}

		
	}

}
