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
	 * �萔
	 *************************************/
	private final int DATE_FLAGS = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY | DateUtils.FORMAT_SHOW_YEAR;


	/*************************************
	 * DB�֘A
	 *************************************/
//	private SQLiteDatabase db;
	private DatabaseHelper dbhelper;


	/*************************************
	 * ���X�g�r���[����
	 *************************************/
	// ���X�g�r���[
	private ListView listView;
	// �A�_�v�^�[
	private EitangoListAdapter adapter;
	// ���X�g�A�C�e��
	private List<EitangoListItem> items = new ArrayList<EitangoListItem>();


	/*************************************
	 * �ϐ�
	 *************************************/
	// [���[�J�[]�p�P�ꃊ�X�g�A�C�e��
//	private EitangoListMaker maker;
	private EitangoListMakerDatabaseImpl maker;
	// ���t
	private Date date = new Date();
	// �\���p���t�t���O


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		/*************************************
		 * DB�֘A START
		 *************************************/
		dbhelper = new DatabaseHelper(this);


		/*************************************
		 * �V�K�P��o�^ START
		 *************************************/
//		EitangoJsonParser ep = new EitangoJsonParser();
//		ep.parseEitangoJson(getAssets(), "eitango_1.json");


		/*************************************
		 * ListView START
		 *************************************/
		// ���X�g�@�A�C�e�������A�ݒ�
		maker = new EitangoListMakerDatabaseImpl(dbhelper);

		// ���X�g�쐬
		listView = (ListView) findViewById(R.id.listview_dayDispEitango);
		setAdapters(listView);

		adapter.addAll(maker.getItemList(date, 3, false));

		// ���X�g�@�C�x���g�ݒ�
		listView.setOnItemClickListener(this);


		/*************************************
		 * ��ʕ\���p����
		 *************************************/
		TextView tv = (TextView)findViewById(R.id.text_date_eitango);
		tv.setText(DateUtils.formatDateTime(this, date.getTime(), DATE_FLAGS));

    }

    /**
     * ListView �̃A�C�e�����N���b�N�����ꍇ�ɍs���鏈��
     * �p��\���Ɠ��{��\���̐؂�ւ��������s����
     *
     */
	@Override
	public void onItemClick(AdapterView<?> adapterview, View view, int i, long l) {
		// �u�A�_�v�^�[���v�p��\���Ɠ��{��\���̐؂�ւ�
		adapter.selectListItem(i);
	}

	/**
	 * �O���{�^�����������ꂽ�ꍇ�̏���
	 *
	 * @param view
	 */
	public void onButtonPreviousDayClick(View view) {
		// �u�O���v�ɕύX
		changeDate(view, -1);
	}

	/**
	 * �����{�^�����������ꂽ�ꍇ�̏���
	 *
	 * @param view
	 */
	public void onButtonNextDayClick(View view) {
		// �u�����v�ɕύX
		changeDate(view, 1);
	}

	/**
	 * �����{�^�����������ꂽ�ꍇ�̏���
	 *
	 * @param view
	 */
	private void changeDate(View view, int diffDate) {
		// ���t��ύX
		date = EitangoDateUtils.addDays(date, diffDate);

		// ���X�g�A�C�e���̍Ď擾
		adapter.clear();
		adapter.addAll(maker.getItemList(date, 3, false));

		TextView tv = (TextView)findViewById(R.id.text_date_eitango);
		tv.setText(DateUtils.formatDateTime(this, date.getTime(), DATE_FLAGS));
	}

	/**
	 * ���X�g�ɃA�_�v�^�[��ݒ�
	 *
	 * @param listView
	 */
	private void setAdapters(ListView listView) {

		// �A�_�v�^�[�̍쐬
		adapter = new EitangoListAdapter(this,
				R.layout.row_listview_eitango, R.id.text_listrow_1, this.items, maker);

		listView.setAdapter(adapter);
	}



}