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

	// DB�p���t�t�H�[�}�b�g
	private static final SimpleDateFormat DATE_FORMAT_FOR_DB = new SimpleDateFormat("yyyyMMdd");

	// DAO
	EitangoDao dao;

	// �A�C�e�����X�g
	ArrayList<EitangoListItem> list;

	// �A�C�e����
	private int itemCount = 3;

	public EitangoListMakerDatabaseImpl(DatabaseHelper dbhelper) {
		dao = new EitangoDao(dbhelper);
	}

	/**
	 * �A�C�e�����X�g�̎擾
	 *
	 */
	public ArrayList<EitangoListItem> getItemList(Date date, int difficulty, boolean doneFlg) {

		// ���t�ϊ�
		String dateStr = DATE_FORMAT_FOR_DB.format(date);

		// ����
		Cursor c = dao.searchForItemList(dateStr, itemCount);
//		c.getCount()
		// �f�[�^�x�[�X�o�^�ς݌����Ɖ�ʕ\���w�茏�����r
		if(c.getCount() < itemCount && !doneFlg) {
			// �w�萔�ɖ����Ȃ��ꍇ�́A�f�[�^�o�^
			dao.insertNotEnoughItemList(dateStr, itemCount - c.getCount(), difficulty);
			dao.close();
			// �ċA����
			list = this.getItemList(date, difficulty, true);

		} else {
			// �擾�f�[�^���A�C�e���ɋl�ߑւ�
			cursorToItem(c);
		}

		c.close();
		dao.close();
		// �P����
		return list;
	}

	/**
	 * �w�肳�ꂽ�p�P��A�C�e�����u���m�v�ɂ��č폜����B
	 * �V�����p�P��A�C�e�����P���擾����B
	 *
	 * @return
	 */
	public EitangoListItem changeOneItemList(String date, int id, int difficulty) {

		// �w�K�����Ǘ�TBL���X�V�F�w�K�󋵁ˁu���m�v�ɍX�V
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_WELLKNOWN);
		// �p�P��}�X�^TBL���X�V�F�p�P��ˁu���m�v�ɍX�V
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_DONE);

		// �V�����p�P��A�C�e���̓o�^
		int newid = dao.insertNotEnoughItemList(date, 1, difficulty);

		// �f�[�^���Ȃ��ꍇ�Anull��Ԃ�
		if (newid == -1) {
			return null;
		}
		// ����
		Cursor c = dao.searchForItemList(date, itemCount, newid);

		cursorToItem(c);

		return list.get(0);
	}

	/**
	 * �w�肳�ꂽ�p�P��A�C�e�����u�o�����v��Ԃɂ���
	 *
	 * @param date
	 * @param id
	 */
	public void memorizedEitangoItem(String date, int id) {
		// DB�X�V
		// �w�K�����Ǘ�TBL���X�V�F�w�K�󋵁ˁu�����v�ɍX�V
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_FINISHED);
		// �p�P��}�X�^TBL���X�V�F�Ώۉp�P��ˁu�����v
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_DONE);

		// �A�C�e�����e�̕ύX
	}

	/**
	 * �w�肳�ꂽ�p�P��A�C�e�����u�o�����v��Ԃ����������
	 *
	 * @param date
	 * @param id
	 */
	public void unMemorizedEitangoItem(String date, int id) {
		// DB�X�V
		// �w�K�����Ǘ�TBL���X�V�F�w�K�󋵁ˁu�����v�ɍX�V
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_UNFINISHED);
		// �p�P��}�X�^TBL���X�V�F�Ώۉp�P��ˁu�����v
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_NOTDONE);

		// �A�C�e�����e�̕ύX
	}

	/**
	 * �w�肳�ꂽ�p�P��A�C�e�����u�m���Ă��v��Ԃ����������
	 *
	 * @param date
	 * @param id
	 */
	public void knewEitangoItem(String date, int id) {
		// DB�X�V
		// �w�K�����Ǘ�TBL���X�V�F�w�K�󋵁ˁu�����v�ɍX�V
		dao.updateStudyStatus(id, date, EitangoKbnConstant.STUDY_STATUS_WELLKNOWN);
		// �p�P��}�X�^TBL���X�V�F�Ώۉp�P��ˁu�����v
		dao.updateDoneStatus(id, EitangoKbnConstant.DONE_STATUS_WELLKNOWN);

	}

	/**
	 * �J�[�\������A�C�e���Ƀf�[�^�̋l�ߑւ�
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
			// ���t
			item.setDate(c.getString(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_DATE)));
			// �p��
			item.setEnglish(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_ENGLISH)));
			// �����P
			item.setWordClass1(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_WORD_CLASS1)));
			// ���{��P
			item.setJapanese1(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_JAPANESE1)));
			// �����Q
			item.setWordClass2(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_WORD_CLASS2)));
			// ���{��Q
			item.setJapanese2(c.getString(c.getColumnIndex(EitangoDatabaseConstant.MSEITANGO_JAPANESE2)));
			// �\���X�e�[�^�X
			item.setDispStatus(c.getInt(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_DISP_STATUS)));
			// �w�K�X�e�[�^�X
			item.setStudyStatus(c.getInt(c.getColumnIndex(EitangoDatabaseConstant.KRSTUDYRECORD_STUDY_STATUS)));

			list.add(item);
		}
		return list;
	}

	/**
	 * �\�������A�C�e������ύX
	 *
	 * @param itemCount
	 */
	public void chengeItemCount(int count) {
		itemCount = count;
	}
}
