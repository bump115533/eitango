package jp.gr.java_conf.tycorp.list;

import java.util.List;

import jp.gr.java_conf.tycorp.R;
import jp.gr.java_conf.tycorp.utils.EitangoKbnConstant;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class EitangoListAdapter extends ArrayAdapter<EitangoListItem> {

	private LayoutInflater mLayoutInflater;

	private EitangoListMakerDatabaseImpl maker;


	/**
	 * コンストラクタ
	 *
	 * @param context
	 * @param resource
	 * @param textViewResourceId
	 * @param objects
	 */
	public EitangoListAdapter(Context context, int resource,
			int textViewResourceId, List<EitangoListItem> objects, EitangoListMakerDatabaseImpl maker) {

		super(context, resource, textViewResourceId, objects);
		mLayoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		this.maker = maker;
	}


	@Override
	public int getItemViewType(int position) {
		return getItem(position).getLayoutStyle();
	}


	@Override
	public int getViewTypeCount() {
		return 2;
	}

	/**
	 * リストアイテムが選択（タッチ）された場合に実行される処理
	 */
	public void selectListItem(int position) {

		// 選択アイテムの表示形式を変更
		EitangoListItem item = (EitangoListItem) getItem(position);
		item.changeLayoutStyle();

		// 変更を通知
		this.notifyDataSetChanged();
	}

	/**
	 * ビュー取得
	 */
	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {

		// リストアイテム生成
		EitangoListItem item = (EitangoListItem) getItem(position);

		// ボタン
		Button btn1;
		Button btn2;

		// convertView作成
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.row_listview_eitango,null);
		} else {

		}

		// リスト表示の切り替え
		if (getItemViewType(position) == EitangoListItem.ROW_LAYOUT_STYLY_ENG) {
			// 英語
			TextView tv2 = (TextView) convertView.findViewById(R.id.text_listrow_2);
			tv2.setText(item.getEnglish());
		} else {
			// 日本語
			TextView tv = (TextView) convertView.findViewById(R.id.text_listrow_1);
			tv.setText(item.getWordClass1());

			TextView tv2 = (TextView) convertView.findViewById(R.id.text_listrow_2);
			tv2.setText(item.getJapanese1());

			TextView tv3 = (TextView) convertView.findViewById(R.id.text_listrow_3);
			tv3.setText(item.getWordClass2());

			TextView tv4 = (TextView) convertView.findViewById(R.id.text_listrow_4);
			tv4.setText(item.getJapanese2());


		}

		// ボタン処理

		// 「覚えた」ボタン
		btn1 = (Button) convertView.findViewById(R.id.button_listrow_1);

		// 「知ってた」ボタン
		btn2 = (Button) convertView.findViewById(R.id.button_listrow_2);

		// 学習状況でのボタン表示切替
		if(item.getStudyStatus() == EitangoKbnConstant.DONE_STATUS_NOTDONE) {
			btn1.setText("覚えた！");
			btn2.setEnabled(true);
			convertView.setBackgroundColor(Color.WHITE);
		} else {
			btn1.setText("忘れた！");
			btn2.setEnabled(false);
			convertView.setBackgroundColor(Color.GRAY);
		}


		btn1.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				EitangoListItem item  = getItem(position);

				// 覚えたボタン押下時の処理

				// 表示内容の変更（色変更、ボタン変更）
				if(item.getStudyStatus() == EitangoKbnConstant.DONE_STATUS_NOTDONE) {
					// 「覚えた！」処理
					// データベース更新
					maker.memorizedEitangoItem(item.getDate(), item.getId());

					// 表示内容更新
					item.setStudyStatus(EitangoKbnConstant.DONE_STATUS_DONE);
					View vi = (View)v.getParent();
					vi.setBackgroundColor(Color.GRAY);
				} else {
					// 「忘れた！」処理
					// データベース更新
					maker.unMemorizedEitangoItem(item.getDate(), item.getId());

					// 表示内容更新
					item.setStudyStatus(EitangoKbnConstant.DONE_STATUS_NOTDONE);
					View vi = (View)v.getParent();
					vi.setBackgroundColor(Color.WHITE);
				}
				// 表示変更通知
				notifyDataSetChanged();
			}
		});

		btn2.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				EitangoListItem item = (EitangoListItem)v.getTag();
				// 知ってたボタン押下時の処理

				// データベース更新


				// アイテム削除
				EitangoListItem delItem = (EitangoListItem)v.getTag();
				remove(delItem);

				// 表示内容の変更（再取得）
				EitangoListItem addItem = maker.changeOneItemList(delItem.getDate(), delItem.getId(), delItem.getDifficulty());
				add(addItem);
//
			}
		});
		return convertView;
	}
}
