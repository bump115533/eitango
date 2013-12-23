package jp.gr.java_conf.tycorp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EitangoDao {

	private DatabaseHelper dbhelper;

	private SQLiteDatabase db;

	private Cursor c;

	public EitangoDao(DatabaseHelper dbhelper) {
		this.dbhelper = dbhelper;
	}

	/**
	 * データ登録処理
	 *
	 * @param dbhelper
	 */
	public void insertXXx() {
		db = dbhelper.getWritableDatabase();

		db.close();
	}

	/**
	 * データ検索処理
	 *
	 * @param dbhelper
	 */
	public Cursor searchForItemList(String date, int itemCount) {

		return searchForItemList(date, itemCount, -1);

	}

	/**
	 * データ検索処理
	 *
	 * @param dbhelper
	 */
	public Cursor searchForItemList(String date, int itemCount, int id) {
		db = dbhelper.getReadableDatabase();

		String sql = "select A.ID, B.ENGLISH, B.WORD_CLASS1, B.JAPANESE1, B.WORD_CLASS2, B.JAPANESE2, A.DISP_STATUS, A.STUDY_STATUS, A.STUDY_DATE  " +
				"from KR_STUDY_RECORD A left outer join MS_EITANGO B on A.ID = B.ID " +
				"where A.STUDY_DATE = '" + date + "' and A.DISP_STATUS = 1";

		if (id != -1) {
			sql = sql + " and A.ID = " + id;
		}

		Log.d("SQL", "searchForItemList = " + sql);
		c = db.rawQuery(sql, null);

		// クローズ
//		db.close();

		return c;
	}


	/**
	 * 不足分のリスト情報を登録する処理
	 *
	 * @param date
	 * @param shortfallCnt
	 * @param difficulty
	 * @return 最後に登録した英単語ID：未登録の場合は-1を返す
	 */
	public int insertNotEnoughItemList(String date, int shortfallCnt, int difficulty) {
		db = dbhelper.getWritableDatabase();

		// 不足数の単語を英単語マスタTBLから選出
		c = searchMsEitangoForShortfallCnt(shortfallCnt, difficulty);

		int id = -1;

		while(c.moveToNext()) {

			// 検索結果を取得
			id = c.getInt(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_ID));

			ContentValues values = new ContentValues();
			// ID
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_ID, id);
			// 学習日付
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_DATE, date);
			//
			// 表示ステータス：表示：１
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_DISP_STATUS, 1);
			// 学習ステータス；出題中：０
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_STATUS, 0);

			db.insert(EitangoDatabaseConstant.TBNAME_KR_STUDY_RECORD, "", values);
		}

		return id;
	}

	/**
	 * 学習履歴管理TBLの学習ステータスを更新
	 *
	 * @param id
	 * @param date
	 * @param studyStatus
	 */
	public void updateStudyStatus(int id, String date, int studyStatus) {
		db = dbhelper.getWritableDatabase();

		// ※「既知」状態と「覚えた」状態への変更で処理を分ける

		String sql = "update KR_STUDY_RECORD " +
				"set STUDY_STATUS = " + studyStatus + " " +
				"where ID = "+ id +" and STUDY_DATE = '" + date + "'";
		Log.d("SQL", "updateStudyStatus = " + sql);

		db.execSQL(sql);

		db.close();
//		db.update(table, values, whereClause, whereArgs)
	}

	/**
	 * 英単語マスタTBLの完了ステータスを更新
	 *
	 * @param id
	 * @param doneStatus
	 */
	public void updateDoneStatus(int id, int doneStatus) {
		db = dbhelper.getWritableDatabase();

		String sql = "update MS_EITANGO set DONE_STATUS = " + doneStatus + " where ID = " + id;
		Log.d("SQL", "updateDoneStatus = " + sql);

		db.execSQL(sql);

		db.close();
//		db.update(table, values, whereClause, whereArgs)
	}


	/**
	 * 不足分の英単語をマスタから抽出
	 *
	 * @param shortfallCnt
	 * @param difficulty
	 * @return
	 */
	private Cursor searchMsEitangoForShortfallCnt(int shortfallCnt, int difficulty) {

		String sql = "select ID from MS_EITANGO " +
				"where DIFFICULTY = '" + difficulty + "' and DONE_STATUS <> 1 order by random() limit " + shortfallCnt ;

		Log.d("SQL", "searchMsEitangoForShortfallCnt = " + sql);
		c = db.rawQuery(sql, null);

		return c;
	}

	/**
	 * クローズ処理
	 */
	public void close() {
		if (db != null) db.close();
		if (c != null) c.close();
	}
}
