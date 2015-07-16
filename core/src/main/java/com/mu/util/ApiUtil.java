package com.mu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.mu.Constants;
import com.mu.model.Recharge;

public class ApiUtil {

	public ApiUtil() {
	}

	public static Map<String, Object> doRecharge(String joloUrl,
			String joloMode, String joloUserId, String joloKey,
			Recharge recharge) {
		String url = joloUrl + "?mode=" + joloMode + "&userid=" + joloUserId
				+ "&key=" + joloKey + "&operator=" + recharge.getOperator()
				+ "&service=" + recharge.getPhoneNumber() + "&amount="
				+ recharge.getAmount() + "&orderid=" + recharge.getId();
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("status", Constants.STATUS_FAILED);
		URL obj;
		StringBuffer response = new StringBuffer();
		int responseCode = 0;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("test", "1");

			responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (responseCode == 200) {
			responseMap.put("status", Constants.STATUS_SUCCESS);
			responseMap.put("response", response);
		} else {
			responseMap.put("response",
					"something went wrong.. please verify the api url");
		}
		return responseMap;
	}

	public static String getOperator(String joloUrl, String joloUserId,
			String joloKey, String number) {
		String url = joloUrl + "?userid=" + joloUserId + "&key=" + joloKey
				+ "&mob=" + number;
		return getRequest(url);
	}

	public static String getOperatorPlans(String joloUrl, String joloUserId,
			String joloKey, String operatorFinderCode, String circleCode) {
		String url = joloUrl + "?userid=" + joloUserId + "&key=" + joloKey
				+ "&opt=" + operatorFinderCode + "&cir=" + circleCode;
		return getRequest(url);
	}

	public static String getRequest(String url) {
		URL obj;
		StringBuffer response = new StringBuffer();
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String postRequest() {
		return "success";
	}
}
