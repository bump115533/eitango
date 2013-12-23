package jp.gr.java_conf.tycorp.widget;

import jp.gr.java_conf.tycorp.R;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class EitangoWidget extends AppWidgetProvider {

	/*
	 * @see android.appwidget.AppWidgetProvider#onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[])
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
//		super.onUpdate(context, appWidgetManager, appWidgetIds);

		Intent intent = new Intent(context, EitangoService.class);

		if (context.startService(intent) == null) {
			Log.e("onUpdate", "サービス実行失敗");
		}


	}

	public static class EitangoService extends Service {

		@Override
		public void onStart(Intent intent, int startId) {
			//

			RemoteViews rv = new RemoteViews(getPackageName(), R.layout.widget_layout_eitango);
			rv.setTextViewText(R.id.text_widget1, "ウィジェットテストだよ");

			// 画面更新
			ComponentName thisWidget = new ComponentName(this, EitangoWidget.class);
			AppWidgetManager mg = AppWidgetManager.getInstance(this);
			mg.updateAppWidget(thisWidget, rv);

		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}

	}
}
