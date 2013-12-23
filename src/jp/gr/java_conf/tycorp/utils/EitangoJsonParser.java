package jp.gr.java_conf.tycorp.utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager;
import android.util.Log;

public class EitangoJsonParser {

	public void parseEitangoJson(AssetManager asset, String fileName) {

		String jsonString = "";
		JSONArray jsons = null;

		try {

			jsonString = getStringFromAssets(fileName, asset);
			jsons = new JSONArray(jsonString);

			for (int i = 0; i < jsons.length(); i++) {
				JSONObject o = jsons.getJSONObject(i);

				// Še€–Ú‚Ì’lÝ’è
				int id = o.getInt("id");
				String eng = o.getString("eng");
				String cl1 = o.getString("class1");
				String jap1 = o.getString("jap1");
				String cl2 = o.getString("calss2");
				String jap2 = o.getString("jap2");
				int diff = o.getInt("diff");

				Log.d("id", String.valueOf(id));
				Log.d("eng", eng);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private String getStringFromAssets(String fileName, AssetManager asset) throws IOException {

		String str = "";
		InputStream is = asset.open(fileName);

		int size = is.available();
		byte[] buffer = new byte[size];
		is.read(buffer);
		is.close();
		str = new String(buffer);

		return str;
	}

}
