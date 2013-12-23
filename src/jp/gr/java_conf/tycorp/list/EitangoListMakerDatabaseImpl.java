package jp.gr.java_conf.tycorp.list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jp.gr.java_conf.tycorp.db.DatabaseHelper;
import jp.gr.java_conf.tycorp.db.EitangoDao;
import jp.gr.java_conf.tycorp.db.EitangoDatabaseConstant;
import jp.gr.java_conf.tycorp.utils.EitangoKbnConstant;
import android.database.Cursor;

public class EitangoListMakerDatabaseImpl implements EitangoListMaker {

	// DB用日付フォーマット
	private static final SimpleDateFormat DATE_FORMAT_FOR_DB = new SimpleDateFormat("yyyyMMdd");

	// DAO
	EitangoDao dao;

	// アイテムリスト
	ArrayList<EitangoListItem> list;

	// アイテム数
	private int itemCount = 3;

	public EitangoListMakerDatabaseImpl(DatabaseHelper dbhelper) {
		dao = new EitangoDao(dbhelper);
	}

	/**
	 * アイテムリストの取得
	 *
	 */
	public ArrayList<EitangoListItem> getItemList(Date date, int difficulty, boolean doneFlg) {

		// 日付変換
		String dateStr = DATE_FORMAT_FOR_DB.format(date);

		// 検索
		Cursor c = dao.searchForItemList(dateStr, itemCount);
//		c.getCount()
		// データベース登録済み件数と画面表示指定件数を比較
		if(c.getCount() < itemCount && !doneFlg) {
			// 指定数に満たない場合は、データ登録
			dao.insertNotEnoughItemList(dateStr, itemCount - c.getCount(), difficulty);
			dao.close();
			// 再帰処理
			list = this.getItemList(date, difficulty, true);

		} else {
			// 取得データをアイテムに詰め替え
			cursorToItem(c);
		}

		c.close();
		dao.close();
		// １日目
		return list;
	}

	/**
	 * 指定された英単語アイテムを「既知」にして削除する。
	 * 新しい英単語アイテムを１件取得する。
	 *
	 * @return
	 */
	public EitangoListItem changeOneItemList(String date, int id, int difficulty) {

		// 学習履歴管理TBLを更新：学習状況⇒「既知」に更新
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_WELLKNOWN);
		// 英単語マスタTBLを更新：英単語⇒「既知」に更新
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_DONE);

		// 新しい英単語アイテムの登録
		int newid = dao.insertNotEnoughItemList(date, 1, difficulty);

		// データがない場合、nullを返す
		if (newid == -1) {
			return null;
		}
		// 検索
		Cursor c = dao.searchForItemList(date, itemCount, newid);

		cursorToItem(c);

		return list.get(0);
	}

	/**
	 * 指定された英単語アイテムを「覚えた」状態にする
	 *
	 * @param date
	 * @param id
	 */
	public void memorizedEitangoItem(String date, int id) {
		// DB更新
		// 学習履歴管理TBLを更新：学習状況⇒「完了」に更新
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_FINISHED);
		// 英単語マスタTBLを更新：対象英単語⇒「完了」
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_DONE);

		// アイテム内容の変更
	}

	/**
	 * 指定された英単語アイテムを「覚えた」状態から解除する
	 *
	 * @param date
	 * @param id
	 */
	public void unMemorizedEitangoItem(String date, int id) {
		// DB更新
		// 学習履歴管理TBLを更新：学習状況⇒「完了」に更新
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_UNFINISHED);
		// 英単語マスタTBLを更新：対象英単語⇒「完了」
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_NOTDONE);

		// アイテム内容の変更
	}

	/**
	 * 指定された英単語アイテムを「知ってた」状態から解除する
	 *
	 * @param date
	 * @param id
	 */
	public void knewEitangoItem(String date, int id) {
		// DB更新
		// 学習履歴管理TBLを更新：学習状況⇒「完了」に更新
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_WELLKNOWN);
		// 英単語マスタTBLを更新：対象英単語⇒「完了」
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_WELLKNOWN);

	}

	/**
	 * カーソルからアイテムにデータの詰め替え
	 *
	 * @param c
	 * @return
	 */
	private ArrayList<EitangoListItem> cursorToItem(Cursor c) {
		list = new ArrayList<EitangoListItem>();

		while (c.moveToNext()) {
			EitangoListItem item = new EitangoListItem();
			// ID
			item.setId(c.getInt(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_ID)));
			// 日付
			item.setDate(c.getString(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_DATE)));
			// 英語
			item.setEnglish(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_ENGLISH)));
			// 助詞１
			item.setWordClass1(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_WORD_CLASS1)));
			// 日本語１
			item.setJapanese1(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_JAPANESE1)));
			// 助詞２
			item.setWordClass2(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_WORD_CLASS2)));
			// 日本語２
			item.setJapanese2(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_JAPANESE2)));
			// 表示ステータス
			item.setDispStatus(c.getInt(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_DISP_STATUS)));
			// 学習ステータス
			item.setStudyStatus(c.getInt(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_STATUS)));

			list.add(item);
		}
		return list;
	}

	/**
	 * 表示されるアイテム数を変更
	 *
	 * @param itemCount
	 */
	public void chengeItemCount(int count) {
		itemCount = count;
	}
}
