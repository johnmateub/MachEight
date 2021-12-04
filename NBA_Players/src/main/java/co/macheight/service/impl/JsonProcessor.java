package co.macheight.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import co.macheight.model.Player;
import co.macheight.service.ServiceProcessor;

public class JsonProcessor implements ServiceProcessor {

	public List<Player> processData() {
		JSONParser parser = new JSONParser();

		try {
			Player player;
			List<Player> players = new ArrayList<Player>();
			String json = readUrl("https://mach-eight.uc.r.appspot.com/");
			Object obj = parser.parse(json);
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject jsonPlayer;
			JSONArray values = (JSONArray) jsonObject.get("values");
			Iterator<JSONObject> iterator = values.iterator();
			while (iterator.hasNext()) {
				jsonPlayer = iterator.next();
				player = new Player((String) jsonPlayer.get("first_name"), (String) jsonPlayer.get("last_name"),
						Integer.valueOf((String) jsonPlayer.get("h_in")),
						Double.valueOf((String) jsonPlayer.get("h_meters")));
				players.add(player);
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Player>();
		}

	}

	/**
	 * Took from: https://stackoverflow.com/questions/7467568/parsing-json-from-url
	 * 
	 * @param urlString
	 * @return
	 * @throws Exception
	 */

	private String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
