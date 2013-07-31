package com.iii.sos;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.iii.favoris.favorisActivity;
import com.iii.quotations.QuotationActivity;

public class MainSos extends Activity implements OnClickListener {
	private Button btnBook, btnQuotation, btnFavoris;
	private ImageView imgvMore;
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_sos);
		loadUI();
	}

	private void loadUI() {
		btnBook = (Button) findViewById(R.id.btnBook);
		btnQuotation = (Button) findViewById(R.id.btnQuotation);
		btnFavoris = (Button) findViewById(R.id.btnFavoris);
		imgvMore = (ImageView) findViewById(R.id.imgvMore);

		ActionMenuItem settingItem = new ActionMenuItem(ID_SETTING, "Cai dat",
				getResources().getDrawable(R.drawable.menu_setting));
		ActionMenuItem shareItem = new ActionMenuItem(ID_SHARE, "Chia se",
				getResources().getDrawable(R.drawable.menu_share));
		ActionMenuItem contributeItem = new ActionMenuItem(ID_CONTRIBUTE,
				"Dong gop", getResources().getDrawable(R.drawable.menu_comment));
		ActionMenuItem infoItem = new ActionMenuItem(ID_INFO, "Thong tin",
				getResources().getDrawable(R.drawable.menu_info));

		quickAction = new QuickMenuAction(MainSos.this,
				QuickMenuAction.VERTICAL);
		quickAction.addActionItem(settingItem);
		quickAction.addActionItem(shareItem);
		quickAction.addActionItem(contributeItem);
		quickAction.addActionItem(infoItem);
		loadData();

	}

	private void loadData() {
		btnBook.setOnClickListener(this);
		btnQuotation.setOnClickListener(this);
		btnFavoris.setOnClickListener(this);
		imgvMore.setOnClickListener(this);

		// Set listener for action item clicked
		quickAction
				.setOnActionItemClickListener(new QuickMenuAction.OnActionItemClickListener() {
					@Override
					public void onItemClick(QuickMenuAction source, int pos,
							int actionId) {
						if (actionId == ID_SHARE) {
							Toast.makeText(MainSos.this, "ID_LANGUAGE",
									Toast.LENGTH_SHORT).show();
							createDialogShare();
						}

					}
				});

	}

	private void createDialogShare() {
		final Dialog dialog = new Dialog(MainSos.this);
		dialog.setContentView(R.layout.facebook_layout);
		dialog.setCancelable(false);
		Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainSos.this, "Login",
						Toast.LENGTH_LONG).show();
				
			}
		});
		Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_sos, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		int btnKey = v.getId();
		if (quickAction != null) {
			if (R.id.imgvMore == btnKey) {
				quickAction.show(v);
			}
		}

		switch (btnKey) {
		case R.id.btnBook:
			Intent itentBook = new Intent(MainSos.this, KeyedActivity.class);
			startActivity(itentBook);
			break;
		case R.id.btnQuotation:
			Intent itentQuotation = new Intent(MainSos.this,
					QuotationActivity.class);
			startActivity(itentQuotation);
			break;
		case R.id.btnFavoris:
			Intent itentFavoris = new Intent(MainSos.this,
					favorisActivity.class);
			startActivity(itentFavoris);
			break;
		case R.id.imgvMore:
			btnKey = 3;
			break;

		default:
			break;
		}

	}

}
