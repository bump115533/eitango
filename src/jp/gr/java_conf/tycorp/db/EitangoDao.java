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
	 * �f�[�^�o�^����
	 *
	 * @param dbhelper
	 */
	public void insertXXx() {
		db = dbhelper.getWritableDatabase();

		db.close();
	}

	/**
	 * �f�[�^��������
	 *
	 * @param dbhelper
	 */
	public Cursor searchForItemList(String date, int itemCount) {

		return searchForItemList(date, itemCount, -1);

	}

	/**
	 * �f�[�^��������
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

		// �N���[�Y
//		db.close();

		return c;
	}


	/**
	 * �s�����̃��X�g����o�^���鏈��
	 *
	 * @param date
	 * @param shortfallCnt
	 * @param difficulty
	 * @return �Ō�ɓo�^�����p�P��ID�F���o�^�̏ꍇ��-1��Ԃ�
	 */
	public int insertNotEnoughItemList(String date, int shortfallCnt, int difficulty) {
		db = dbhelper.getWritableDatabase();

		// �s�����̒P����p�P��}�X�^TBL����I�o
		c = searchMsEitangoForShortfallCnt(shortfallCnt, difficulty);

		int id = -1;

		while(c.moveToNext()) {

			// �������ʂ��擾
			id = c.getInt(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_ID));

			ContentValues values = new ContentValues();
			// ID
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_ID, id);
			// �w�K���t
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_DATE, date);
			//
			// �\���X�e�[�^�X�F�\���F�P
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_DISP_STATUS, 1);
			// �w�K�X�e�[�^�X�G�o�蒆�F�O
			values.put(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_STATUS, 0);

			db.insert(EitangoDatabaseConstant.TBNAME_KR_STUDY_RECORD, "", values);
		}

		return id;
	}

	/**
	 * �w�K�����Ǘ�TBL�̊w�K�X�e�[�^�X���X�V
	 *
	 * @param id
	 * @param date
	 * @param studyStatus
	 */
	public void updateStudyStatus(int id, String date, int studyStatus) {
		db = dbhelper.getWritableDatabase();

		// ���u���m�v��ԂƁu�o�����v��Ԃւ̕ύX�ŏ����𕪂���

		String sql = "update KR_STUDY_RECORD " +
				"set STUDY_STATUS = " + studyStatus + " " +
				"where ID = "+ id +" and STUDY_DATE = '" + date + "'";
		Log.d("SQL", "updateStudyStatus = " + sql);

		db.execSQL(sql);

		db.close();
//		db.update(table, values, whereClause, whereArgs)
	}

	/**
	 * �p�P��}�X�^TBL�̊����X�e�[�^�X���X�V
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
	 * �s�����̉p�P����}�X�^���璊�o
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
	 * �N���[�Y����
	 */
	public void close() {
		if (db != null) db.close();
		if (c != null) c.close();
	}
}
