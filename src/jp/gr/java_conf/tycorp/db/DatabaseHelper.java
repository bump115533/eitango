package jp.gr.java_conf.tycorp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private SQLiteDatabase db;

	public DatabaseHelper(Context context) {
		super(context, "eitangoapp.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlitedatabase) {
		this.db = sqlitedatabase;

		// �e�[�u���쐬
		// �P��}�X�^TBL�쐬
		db.execSQL("create table if not exists MS_EITANGO (ID integer primary key, ENGLISH text, WORD_CLASS1 text, JAPANESE1 text, WORD_CLASS2 text, JAPANESE2 text, DIFFICULTY integer, DONE_STATUS integer, TOROKU_DATE text, KOSIN_DATE text)");

		// �w�K�����Ǘ�TBL�쐬
		db.execSQL("create table if not exists KR_STUDY_RECORD (ID integer, STUDY_DATE text, DISP_STATUS integer, STUDY_STATUS integer, TOROKU_DATE text, KOSIN_DATE text, primary key(ID, STUDY_DATE))");

		// �����f�[�^����
		registerInitEitango();

	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}


	private void registerInitEitango() {

		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (1, 'accept', '����', '�󂯓����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (2, 'accommodate', '����', '���e����A�֋X���͂���@�y���zaccommodation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (3, 'account', '�����E����', '�����A��������@�y�ށzaccountant ��v�m', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (4, 'accumulate', '����', '�~�ς���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (5, 'acknowledge', '����', '�F�߂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (6, 'administration', '����', '�o�c�A�^�c�@�y���zadminister', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (7, 'advance', '�����E����', '�O�i�i����j�@in advance �O������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (8, 'alter', '����', '�ς���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (9, 'appropriate', '�`�e��', '�K�؂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (10, 'approximately', '����', '���悻', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (11, 'assign', '����', '�����蓖�Ă�A�C������@�y���zassignment', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (12, 'assure', '����', '�ۏ؂���y���zassurance', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (13, 'audit', '�����E����', '��v�č�(������)�y�ށzauditor �č���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (14, 'benefit', '�����E����', '���v�i�������炷�j�y�`�zbeneficial', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (15, 'budget', '����', '�\�Z', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (16, 'career', '����', '�L�����A�A�E��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (17, 'cause', '�����E����', '�����A�`�������N����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (18, 'classify', '����', '���ނ���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (19, 'colleague', '����', '�����A���Ǝ�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (20, 'commercial', '�`�e��', '���ƓI�ȁy���zcommerce', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (21, 'commodity', '����', '���i', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (22, 'complimentary', '�`�e��', '������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (23, 'comply', '����', '�]��(with)', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (24, 'conference', '����', '��c', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (25, 'confirm', '����', '�m�F����@�y���zconfirmation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (26, 'contract', '�����E����', '�_��i������j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (27, 'convert', '����', '�ς���A�]������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (28, 'decline', '�����E����', '�����i����j�A�f��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (29, 'defect', '����', '���_�A���ׁ@�y�`�zdefective', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (30, 'deposit', '�����E����', '�a���A�a����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (31, 'descendant', '����', '�q��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (32, 'detail', '����', '�ڍׁ@in detail �ڍׂ�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (33, 'diminish', '����', '����A���炷', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (34, 'diplomat', '����', '�O�����@�y�ށzdiplomacy �O��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (35, 'distribute', '����', '���z����A���ʂ�����y���zdistribution', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (36, 'eligible', '�`�e��', '�K�i�ł���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (37, 'enterprise', '����', '��ЁA����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (38, 'equipment', '����', '�ݔ��A���� �����`�͂Ȃ��y���zequip', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (39, 'estate', '����', '���Y�A�y�n�@real estate �s���Y', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (40, 'estimate', '�����E����', '���ς���i������j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (41, 'exceed', '����', '�z����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (42, 'exclusive', '�`�e��', '�r���I�ȁA�Ɛ�I�ȁy���zexclude', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (43, 'expand', '����', '�g������y���zexpansion', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (44, 'exploit', '����', '��悷��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (45, 'facilitate', '����', '�e�Ղɂ���A���i����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (46, 'facility', '����', '�{�݁A�ݔ�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (47, 'fascinate', '����', '�������� �y���zfascination', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (48, 'fasten', '����', '���߂�A�Œ肷�� fasten your seat belt �V�[�g�x���g����߂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (49, 'function', '�����E����', '�@�\�i����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (50, 'gigantic', '�`�e��', '����ȁy�ށzgiant ���l', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (51, 'gratitude', '����', '���� �y�ތ�zgrateful', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (52, 'grocery', '����', '�H���i�X�A�i�����`�Łj�H���i', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (53, 'hostile', '�`�e��', '�G�ӂ̂��� hostile takeover �G�ΓI����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (54, 'incur', '����', '�i���Ȃǂ��r�󂯂�A�����@ incur a loss�i�����j/debt�i�؋��j�Ƃ���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (55, 'indicate', '����', '�����A�\���@�y���zindication, indicator', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (56, 'indispensable', '�`�e��', '�K�v�s���ȁi���́j�y�ށzessential', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (57, 'industry', '����', '�Y�Ɓ@�@film industry �f��ƊE', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (58, 'inquiry', '����', '�₢���킹�@make an inquiry �₢���킹������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (59, 'inventory', '�����E����', '�݌�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (60, 'invest', '����', '��������@�y���zinvestor�i�����Ɓj, investment�i�����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (61, 'invoice', '����', '���׏��A�����A������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (62, 'isolate', '����', '�`���Ǘ�������@�y���zisolation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (63, 'itinerary', '����', '���s����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (64, 'labor', '����', '�J���i�ҁj�@labor union �J���g��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (65, 'merger', '����', '�����@merger and acquisition(M&A) �����z��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (66, 'notify', '����', '�m�点��A�ʒm����@�y���E���znotice', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (67, 'order', '�����E����', '���߁E�����i����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (68, 'overdue', '�`�e��', '�i�x�����Ȃǂ́j�������߂���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (69, 'participate', '����', '�Q������(in) = take part in', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (70, 'periodic', '�`�e��', '����I�ȁ@�y���zperiodical �i������s���j�Aperiod�i����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (71, 'pharmacy', '����', '���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (72, 'postpone', '����', '�`����������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (73, 'predict', '����', '�\������@�y���zprediction', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (74, 'prescribe', '����', '�`�i��Ȃǂ��j��������A�i�K���Ƃ��āj��߂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (75, 'privilege', '����', '����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (76, 'profit', '�����E����', '�@���v�i�𓾂�j�y���zprofitable�@profit and loss (P&L)�@���v', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (77, 'prompt', '�����E�`�e��', '�����A������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (78, 'purchase', '�����E����', '�w���i����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (79, 'quarter', '����', '�l�����A4����1', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (80, 'recommend', '����', '���E����y���zrecommendation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (81, 'refund', '�����E����', '�ԋ��A�����߂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (82, 'reimburse', '����', '�����߂�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (83, 'reliable', '�`�e��', '����ɂȂ�A�M���̂����@�y���zrely on �`�ɗ���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (84, 'remain', '�����E����', '�c��A�c��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (85, 'reserve', '�����E����', '�\�񂷂�A�~���A�����@�y���zreservation�@�\��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (86, 'resign', '����', '���E����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (87, 'retailer', '����', '�����Ǝ�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (88, 'retire', '����', '�ސE����@�y���zretirement', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (89, 'storage', '����', '�����@�y���zstore �~����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (90, 'subscribe', '����', '����w�ǂ���(to)', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (91, 'subtle', '�`�e��', '������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (92, 'suggest', '����', '��Ă���A��������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (93, 'summary', '����', '�v��A�܂Ƃ�', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (94, 'surcharge', '����', '�ǉ�����', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (95, 'surplus', '����', '�]��@�@trade surplus �@�f�Ս���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (96, 'survey', '�����E����', '�����i����j', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (97, 'urban', '�`�e��', '�s���', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (98, 'venture', '�����E����', '�i���@�I�ȁj�V���ƁA�v���؂��čs��,�x���`���[��� venturecompany', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (99, 'voucher', '����', '�N�[�|�����A������', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (100, 'warehouse', '����', '�q��', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (101, 'withdraw', '����', '�P�ނ���A�����o���@withdraw money �����������o��', null, null, 3, 0)");

	}
}
