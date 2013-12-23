package jp.gr.java_conf.tycorp.list;

import java.util.Date;
import java.util.List;

public interface EitangoListMaker {

	public List<EitangoListItem> getItemList(Date date, int difficulty, boolean doneFlg);

}
