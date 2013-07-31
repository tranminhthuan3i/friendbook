package com.iii.sos;

import java.util.ArrayList;

import com.iii.adapter.AdapterKeyed;
import com.iii.favoris.favorisActivity;
import com.iii.favoris.favorisActivity.OnHeaderSelectedListener;
import com.iii.model.category;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

public class KeyedActivity extends Activity implements OnClickListener {
	private GridView grdKeyed;
	private AdapterKeyed adapterKeyed;
	private ArrayList<category> lstCategories;
	private ImageView imgbMore_keyed;
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
		setContentView(R.layout.keyed_layout);
		loadUI();
	}

	private void loadUI() {
		grdKeyed = (GridView) findViewById(R.id.grdkeyed);
		lstCategories = new ArrayList<category>();
		imgbMore_keyed = (ImageView) findViewById(R.id.imgvMore_keyed);
		ActionMenuItem settingItem = new ActionMenuItem(ID_SETTING, "Cai dat",
				getResources().getDrawable(R.drawable.menu_setting));
		ActionMenuItem shareItem = new ActionMenuItem(ID_SHARE, "Chia se",
				getResources().getDrawable(R.drawable.menu_share));
		ActionMenuItem contributeItem = new ActionMenuItem(ID_CONTRIBUTE,
				"Dong gop", getResources().getDrawable(R.drawable.menu_comment));
		ActionMenuItem infoItem = new ActionMenuItem(ID_INFO, "Thong tin",
				getResources().getDrawable(R.drawable.menu_info));

		quickAction = new QuickMenuAction(KeyedActivity.this,
				QuickMenuAction.VERTICAL);
		quickAction.addActionItem(settingItem);
		quickAction.addActionItem(shareItem);
		quickAction.addActionItem(contributeItem);
		quickAction.addActionItem(infoItem);

		CreateArray();
		adapterKeyed = new AdapterKeyed(lstCategories, KeyedActivity.this);
		grdKeyed.setAdapter(adapterKeyed);
		loadData();

	}

	private void loadData() {
		imgbMore_keyed.setOnClickListener(this);

	}

	private void CreateArray() {
		category category = new category("Bi quyet thanh cong", "",
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(category);
		category category2 = new category("17 tu duy", "",
				BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_launcher));
		lstCategories.add(category2);
		category category3 = new category("Tren dinh Phu Sy", "",
				BitmapFactory.decodeResource(getResources(),
						R.drawable.bookicon));
		lstCategories.add(category3);

	}

	@Override
	public void onClick(View v) {
		int btnKey = v.getId();
		if (quickAction != null) {
			if (R.id.imgvMore_keyed == btnKey) {
				quickAction.show(v);
			}
		}
		switch (btnKey) {
		case R.id.imgvMore_keyed:
			btnKey = 3;
			break;

		default:
			break;
		}

	}

}
