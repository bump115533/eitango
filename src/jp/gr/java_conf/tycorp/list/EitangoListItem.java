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
	 * id ���擾
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * id ��ݒ�
	 * @param id �Z�b�g���� id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * date ���擾
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * date ��ݒ�
	 * @param date �Z�b�g���� date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * english ���擾
	 * @return english
	 */
	public String getEnglish() {
		return english;
	}

	/**
	 * english ��ݒ�
	 * @param english �Z�b�g���� english
	 */
	public void setEnglish(String english) {
		this.english = english;
	}

	/**
	 * wordClass1 ���擾
	 * @return wordClass1
	 */
	public String getWordClass1() {
		return "[" + wordClass1 + "]";
	}

	/**
	 * wordClass1 ��ݒ�
	 * @param wordClass1 �Z�b�g���� wordClass1
	 */
	public void setWordClass1(String wordClass1) {
		this.wordClass1 = wordClass1;
	}

	/**
	 * japanese1 ���擾
	 * @return japanese1
	 */
	public String getJapanese1() {
		return japanese1;
	}

	/**
	 * japanese1 ��ݒ�
	 * @param japanese1 �Z�b�g���� japanese1
	 */
	public void setJapanese1(String japanese1) {
		this.japanese1 = japanese1;
	}

	/**
	 * wordClass2 ���擾
	 * @return wordClass2
	 */
	public String getWordClass2() {
		return "[" + wordClass2 + "]";
	}

	/**
	 * wordClass2 ��ݒ�
	 * @param wordClass2 �Z�b�g���� wordClass2
	 */
	public void setWordClass2(String wordClass2) {
		this.wordClass2 = wordClass2;
	}

	/**
	 * japanese2 ���擾
	 * @return japanese2
	 */
	public String getJapanese2() {
		return japanese2;
	}

	/**
	 * japanese2 ��ݒ�
	 * @param japanese2 �Z�b�g���� japanese2
	 */
	public void setJapanese2(String japanese2) {
		this.japanese2 = japanese2;
	}

	/**
	 * studyStatus ���擾
	 * @return studyStatus
	 */
	public int getStudyStatus() {
		return studyStatus;
	}

	/**
	 * studyStatus ��ݒ�
	 * @param studyStatus �Z�b�g���� studyStatus
	 */
	public void setStudyStatus(int studyStatus) {
		this.studyStatus = studyStatus;
	}

	/**
	 * difficulty ���擾
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * difficulty ��ݒ�
	 * @param difficulty �Z�b�g���� difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * dispStatus ���擾
	 * @return dispStatus
	 */
	public int getDispStatus() {
		return dispStatus;
	}

	/**
	 * dispStatus ��ݒ�
	 * @param dispStatus �Z�b�g���� dispStatus
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
