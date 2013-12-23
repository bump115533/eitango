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

		// テーブル作成
		// 単語マスタTBL作成
		db.execSQL("create table if not exists MS_EITANGO (ID integer primary key, ENGLISH text, WORD_CLASS1 text, JAPANESE1 text, WORD_CLASS2 text, JAPANESE2 text, DIFFICULTY integer, DONE_STATUS integer, TOROKU_DATE text, KOSIN_DATE text)");

		// 学習履歴管理TBL作成
		db.execSQL("create table if not exists KR_STUDY_RECORD (ID integer, STUDY_DATE text, DISP_STATUS integer, STUDY_STATUS integer, TOROKU_DATE text, KOSIN_DATE text, primary key(ID, STUDY_DATE))");

		// 初期データ投入
		registerInitEitango();

	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
		// TODO 自動生成されたメソッド・スタブ

	}


	private void registerInitEitango() {

		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (1, 'accept', '動詞', '受け入れる', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (2, 'accommodate', '動詞', '収容する、便宜をはかる　【名】accommodation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (3, 'account', '動詞・名詞', '口座、説明する　【類】accountant 会計士', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (4, 'accumulate', '動詞', '蓄積する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (5, 'acknowledge', '動詞', '認める', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (6, 'administration', '名詞', '経営、運営　【動】administer', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (7, 'advance', '動詞・名詞', '前進（する）　in advance 前もって', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (8, 'alter', '動詞', '変える', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (9, 'appropriate', '形容詞', '適切な', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (10, 'approximately', '副詞', 'およそ', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (11, 'assign', '動詞', 'を割り当てる、任命する　【名】assignment', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (12, 'assure', '動詞', '保証する【名】assurance', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (13, 'audit', '動詞・名詞', '会計監査(をする)【類】auditor 監査役', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (14, 'benefit', '動詞・名詞', '利益（をもたらす）【形】beneficial', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (15, 'budget', '名詞', '予算', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (16, 'career', '名詞', 'キャリア、職業', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (17, 'cause', '動詞・名詞', '原因、～を引き起こす', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (18, 'classify', '動詞', '分類する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (19, 'colleague', '名詞', '同僚、同業者', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (20, 'commercial', '形容詞', '商業的な【名】commerce', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (21, 'commodity', '名詞', '商品', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (22, 'complimentary', '形容詞', '無料の', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (23, 'comply', '動詞', '従う(with)', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (24, 'conference', '名詞', '会議', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (25, 'confirm', '動詞', '確認する　【名】confirmation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (26, 'contract', '動詞・名詞', '契約（をする）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (27, 'convert', '動詞', '変える、転換する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (28, 'decline', '名詞・動詞', '減少（する）、断る', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (29, 'defect', '名詞', '欠点、欠陥　【形】defective', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (30, 'deposit', '動詞・名詞', '預金、預ける', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (31, 'descendant', '名詞', '子孫', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (32, 'detail', '名詞', '詳細　in detail 詳細に', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (33, 'diminish', '動詞', '減る、減らす', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (34, 'diplomat', '名詞', '外交官　【類】diplomacy 外交', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (35, 'distribute', '動詞', '分配する、流通させる【名】distribution', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (36, 'eligible', '形容詞', '適格である', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (37, 'enterprise', '名詞', '会社、事業', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (38, 'equipment', '名詞', '設備、装備 複数形はなし【動】equip', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (39, 'estate', '名詞', '財産、土地　real estate 不動産', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (40, 'estimate', '動詞・名詞', '見積もり（をする）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (41, 'exceed', '動詞', '越える', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (42, 'exclusive', '形容詞', '排他的な、独占的な【動】exclude', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (43, 'expand', '動詞', '拡張する【名】expansion', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (44, 'exploit', '動詞', '搾取する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (45, 'facilitate', '動詞', '容易にする、促進する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (46, 'facility', '名詞', '施設、設備', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (47, 'fascinate', '動詞', '魅了する 【名】fascination', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (48, 'fasten', '動詞', '締める、固定する fasten your seat belt シートベルトを締める', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (49, 'function', '動詞・名詞', '機能（する）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (50, 'gigantic', '形容詞', '巨大な【類】giant 巨人', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (51, 'gratitude', '名詞', '感謝 【類語】grateful', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (52, 'grocery', '名詞', '食料品店、（複数形で）食料品', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (53, 'hostile', '形容詞', '敵意のある hostile takeover 敵対的買収', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (54, 'incur', '動詞', '（負債などを〉受ける、招く　 incur a loss（損失）/debt（借金）という', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (55, 'indicate', '動詞', '示す、表す　【名】indication, indicator', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (56, 'indispensable', '形容詞', '必要不可欠な（もの）【類】essential', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (57, 'industry', '名詞', '産業　　film industry 映画業界', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (58, 'inquiry', '名詞', '問い合わせ　make an inquiry 問い合わせをする', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (59, 'inventory', '名詞・動詞', '在庫', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (60, 'invest', '動詞', '投資する　【名】investor（投資家）, investment（投資）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (61, 'invoice', '名詞', '明細書、送り状、請求書', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (62, 'isolate', '動詞', '～を孤立させる　【名】isolation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (63, 'itinerary', '名詞', '旅行日程', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (64, 'labor', '名詞', '労働（者）　labor union 労働組合', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (65, 'merger', '名詞', '合併　merger and acquisition(M&A) 合併吸収', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (66, 'notify', '動詞', '知らせる、通知する　【名・動】notice', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (67, 'order', '動詞・名詞', '命令・注文（する）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (68, 'overdue', '形容詞', '（支払いなどの）期限が過ぎた', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (69, 'participate', '動詞', '参加する(in) = take part in', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (70, 'periodic', '形容詞', '定期的な　【名】periodical （定期刊行物）、period（時代）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (71, 'pharmacy', '名詞', '薬局', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (72, 'postpone', '動詞', '～を延期する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (73, 'predict', '動詞', '予言する　【名】prediction', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (74, 'prescribe', '動詞', '～（薬などを）処方する、（規則として）定める', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (75, 'privilege', '名詞', '特権', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (76, 'profit', '動詞・名詞', '　利益（を得る）【名】profitable　profit and loss (P&L)　損益', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (77, 'prompt', '動詞・形容詞', '促す、即座の', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (78, 'purchase', '動詞・名詞', '購入（する）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (79, 'quarter', '名詞', '四半期、4分の1', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (80, 'recommend', '動詞', '推薦する【名】recommendation', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (81, 'refund', '名詞・動詞', '返金、払い戻す', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (82, 'reimburse', '動詞', '払い戻す', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (83, 'reliable', '形容詞', '頼りになる、信頼のおけ　【動】rely on ～に頼る', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (84, 'remain', '動詞・名詞', '残る、残り', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (85, 'reserve', '動詞・名詞', '予約する、蓄え、遠慮　【名】reservation　予約', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (86, 'resign', '動詞', '辞職する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (87, 'retailer', '名詞', '小売業者', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (88, 'retire', '動詞', '退職する　【名】retirement', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (89, 'storage', '名詞', '貯蔵　【動】store 蓄える', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (90, 'subscribe', '動詞', '定期購読する(to)', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (91, 'subtle', '形容詞', '微妙な', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (92, 'suggest', '動詞', '提案する、示唆する', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (93, 'summary', '名詞', '要約、まとめ', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (94, 'surcharge', '名詞', '追加料金', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (95, 'surplus', '名詞', '余剰　　trade surplus 　貿易黒字', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (96, 'survey', '動詞・名詞', '調査（する）', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (97, 'urban', '形容詞', '都会の', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (98, 'venture', '名詞・動詞', '（投機的な）新事業、思い切って行う,ベンチャー企業 venturecompany', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (99, 'voucher', '名詞', 'クーポン券、引換券', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (100, 'warehouse', '名詞', '倉庫', null, null, 3, 0)");
		db.execSQL("insert into MS_EITANGO (ID, ENGLISH, WORD_CLASS1, JAPANESE1, WORD_CLASS2, JAPANESE2, DIFFICULTY, DONE_STATUS) values (101, 'withdraw', '動詞', '撤退する、引き出す　withdraw money お金を引き出す', null, null, 3, 0)");

	}
}
