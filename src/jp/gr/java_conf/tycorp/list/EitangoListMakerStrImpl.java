package jp.gr.java_conf.tycorp.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EitangoListMakerStrImpl implements EitangoListMaker {


	private String[] eng = {"english", "mayby", "study"};

	private String[] wClass1 = {"名詞","助動詞","動詞"};

	private String[] jap1 = {"英語", "たぶん, たいてい", "勉強する, 学ぶ"};

//	EitangoListMakerStrImpl(Context context) {
//
//	}

	public List<EitangoListItem> getItemList(Date date, int difficulty, boolean doneFlg) {

		ArrayList<EitangoListItem> list = new ArrayList<EitangoListItem>();

		// １日目
		for(int i=0; i < eng.length; i++) {
			EitangoListItem item = new EitangoListItem();

			item.setEnglish(eng[i]);

			item.setWordClass1(wClass1[i]);

			item.setJapanese1(jap1[i]);

			item.changeLayoutStyle();

			list.add(item);
		}
		return list;
	}
}
