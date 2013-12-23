package jp.gr.java_conf.tycorp.list;


public class EitangoListItem {

	public static final int ROW_LAYOUT_STYLY_ENG = 0;

	public static final int ROW_LAYOUT_STYLY_JAP = 1;

	private int id;

	private String date;

	private String english;

	private String wordClass1;

	private String japanese1;

	private String wordClass2;

	private String japanese2;

	private int studyStatus;

	private int difficulty;

	private int dispStatus;

	private int layoutStyle = 0;



	/**
	 * id を取得
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * id を設定
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * date を取得
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * date を設定
	 * @param date セットする date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * english を取得
	 * @return english
	 */
	public String getEnglish() {
		return english;
	}

	/**
	 * english を設定
	 * @param english セットする english
	 */
	public void setEnglish(String english) {
		this.english = english;
	}

	/**
	 * wordClass1 を取得
	 * @return wordClass1
	 */
	public String getWordClass1() {
		return "[" + wordClass1 + "]";
	}

	/**
	 * wordClass1 を設定
	 * @param wordClass1 セットする wordClass1
	 */
	public void setWordClass1(String wordClass1) {
		this.wordClass1 = wordClass1;
	}

	/**
	 * japanese1 を取得
	 * @return japanese1
	 */
	public String getJapanese1() {
		return japanese1;
	}

	/**
	 * japanese1 を設定
	 * @param japanese1 セットする japanese1
	 */
	public void setJapanese1(String japanese1) {
		this.japanese1 = japanese1;
	}

	/**
	 * wordClass2 を取得
	 * @return wordClass2
	 */
	public String getWordClass2() {
		return "[" + wordClass2 + "]";
	}

	/**
	 * wordClass2 を設定
	 * @param wordClass2 セットする wordClass2
	 */
	public void setWordClass2(String wordClass2) {
		this.wordClass2 = wordClass2;
	}

	/**
	 * japanese2 を取得
	 * @return japanese2
	 */
	public String getJapanese2() {
		return japanese2;
	}

	/**
	 * japanese2 を設定
	 * @param japanese2 セットする japanese2
	 */
	public void setJapanese2(String japanese2) {
		this.japanese2 = japanese2;
	}

	/**
	 * studyStatus を取得
	 * @return studyStatus
	 */
	public int getStudyStatus() {
		return studyStatus;
	}

	/**
	 * studyStatus を設定
	 * @param studyStatus セットする studyStatus
	 */
	public void setStudyStatus(int studyStatus) {
		this.studyStatus = studyStatus;
	}

	/**
	 * difficulty を取得
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * difficulty を設定
	 * @param difficulty セットする difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * dispStatus を取得
	 * @return dispStatus
	 */
	public int getDispStatus() {
		return dispStatus;
	}

	/**
	 * dispStatus を設定
	 * @param dispStatus セットする dispStatus
	 */
	public void setDispStatus(int dispStatus) {
		this.dispStatus = dispStatus;
	}

	public int getLayoutStyle() {
		return layoutStyle;
	}

	public void changeLayoutStyle() {
		layoutStyle = ~layoutStyle;
	}
}
