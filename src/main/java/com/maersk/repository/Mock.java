package com.maersk.repository;

import org.json.JSONObject;

public class Mock {

	public static String getAvailableSpace() {
		return new JSONObject().put("availableSpace", 6).toString();
	}

}
