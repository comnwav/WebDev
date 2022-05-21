package com.pro.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PayControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK ee0bd484f7e8f428c26131f4d6b29c03");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);

		System.out.println(conn.getResponseMessage());
		
//		Map<String, String> prm = new HashMap<String, String>();
//		prm.put("cid", "TC0ONETIME");
//		prm.put("partner_order_id", request.getParameter("orderId"));
//		prm.put("partner_user_id", request.getParameter("usrId"));
//		prm.put("item_name", "movie ticket");
//		prm.put("quantity", request.getParameter("quantity"));
//		prm.put("total_amount", request.getParameter("totAmount"));
//		prm.put("tax_free_amount", request.getParameter("tfAmount"));
//		prm.put("approval_url", "http://localhost:80/Cine/view/payApproval.html");
//		prm.put("cancel_url", "http://localhost:80/Cine/view/payCancel.html");
//		prm.put("fail_url", "http://localhost:80/Cine/view/payFail.html");
//		prm.put("payment_method_type", "CARD");
//
//		String params = new String();
//		for (Map.Entry<String, String> element : prm.entrySet()) {
//			params += (element.getKey() + "=" + element.getValue() + "&");
//		}
//		
//		System.out.println(params);
		
//		conn.getOutputStream().write(params.getBytes());
		
//		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		
//		System.out.println("input:" + in);
//		
//		JSONParser parser = new JSONParser(in);
//		try {
//			JSONObject obj = (JSONObject) parser.parse();
//			String redirect = (String) obj.get("next_redirect_pc_url");
//			System.out.println(redirect);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		

	}
}
