package jp.gr.java_conf.tycorp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.gr.java_conf.tycorp.db.DatabaseHelper;
import jp.gr.java_conf.tycorp.list.EitangoListAdapter;
import jp.gr.java_conf.tycorp.list.EitangoListItem;
import jp.gr.java_conf.tycorp.list.EitangoListMakerDatabaseImpl;
import jp.gr.java_conf.tycorp.utils.EitangoDateUtils;
import jp.gr.java_conf.tycorp.utils.EitangoJsonParser;
import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class DayDispEitangoAppActivity extends Activity implements OnItemClickListener  {

	/*************************************
	 * 定数
	 *************************************/
	private final int DATE_FLAGS = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY | DateUtils.FORMAT_SHOW_YEAR;


	/*************************************
	 * DB関連
	 *************************************/
//	private SQLiteDatabase db;
	private DatabaseHelper dbhelper;


	/*************************************
	 * リストビュー項目
	 *************************************/
	// リストビュー
	private ListView listView;
	// アダプター
	private EitangoListAdapter adapter;
	// リストアイテム
	private List<EitangoListItem> items = new ArrayList<EitangoListItem>();


	/*************************************
	 * 変数
	 *************************************/
	// [メーカー]英単語リストアイテム
//	private EitangoListMaker maker;
	private EitangoListMakerDatabaseImpl maker;
	// 日付
	private Date date = new Date();
	// 表示用日付フラグ


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		/*************************************
		 * DB関連 START
		 *************************************/
		dbhelper = new DatabaseHelper(this);


		/*************************************
		 * 新規単語登録 START
		 *************************************/
//		EitangoJsonParser ep = new EitangoJsonParser();
//		ep.parseEitangoJson(getAssets(), "eitango_1.json");


		/*************************************
		 * ListView START
		 *************************************/
		// リスト　アイテム生成、設定
		maker = new EitangoListMakerDatabaseImpl(dbhelper);

		// リスト作成
		listView = (ListView) findViewById(R.id.listview_dayDispEitango);
		setAdapters(listView);

		adapter.addAll(maker.getItemList(date, 3, false));

		// リスト　イベント設定
		listView.setOnItemClickListener(this);


		/*************************************
		 * 画面表示用処理
		 *************************************/
		TextView tv = (TextView)findViewById(R.id.text_date_eitango);
		tv.setText(DateUtils.formatDateTime(this, date.getTime(), DATE_FLAGS));

    }

    /**
     * ListView のアイテムをクリックした場合に行われる処理
     * 英語表示と日本語表示の切り替え処理が行われる
     *
     */
	@Override
	public void onItemClick(AdapterView<?> adapterview, View view, int i, long l) {
		// 「アダプター内」英語表示と日本語表示の切り替え
		adapter.selectListItem(i);
	}

	/**
	 * 前日ボタンが押下された場合の処理
	 *
	 * @param view
	 */
	public void onButtonPreviousDayClick(View view) {
		// 「前日」に変更
		changeDate(view, -1);
	}

	/**
	 * 翌日ボタンが押下された場合の処理
	 *
	 * @param view
	 */
	public void onButtonNextDayClick(View view) {
		// 「翌日」に変更
		changeDate(view, 1);
	}

	/**
	 * 翌日ボタンが押下された場合の処理
	 *
	 * @param view
	 */
	private void changeDate(View view, int diffDate) {
		// 日付を変更
		date = EitangoDateUtils.addDays(date, diffDate);

		// リストアイテムの再取得
		adapter.clear();
		adapter.addAll(maker.getItemList(date, 3, false));

		TextView tv = (TextView)findViewById(R.id.text_date_eitango);
		tv.setText(DateUtils.formatDateTime(this, date.getTime(), DATE_FLAGS));
	}

	/**
	 * リストにアダプターを設定
	 *
	 * @param listView
	 */
	private void setAdapters(ListView listView) {

		// アダプターの作成
		adapter = new EitangoListAdapter(this,
				R.layout.row_listview_eitango, R.id.text_listrow_1, this.items, maker);

		listView.setAdapter(adapter);
	}



}