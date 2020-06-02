package com.amazon.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
 public class Coordinates {
	 Double lat,lon;
	 public Coordinates(String pincode)
	 {
		 try {
				
				String url = "https://nominatim.openstreetmap.org/search?q=";
			     URL obj = new URL(url+pincode+"&format=json");
			     HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			     int responseCode = con.getResponseCode();

			     BufferedReader in = new BufferedReader(
			             new InputStreamReader(con.getInputStream()));
			     String inputLine;
			     StringBuffer response = new StringBuffer();
			     while ((inputLine = in.readLine()) != null) {
			     	response.append(inputLine);
			     }
			     in.close();
			     
			     JSONArray myresponse= new JSONArray(response.toString());
			     JSONObject object = myresponse.getJSONObject(0);
			     lat=Double.valueOf(object.getString("lat"));
			     lon=Double.valueOf(object.getString("lon"));
				}
			     catch (Exception e) {
					System.out.println(e);
					}

	 }
	public Double Lat()
	{
		return lat;
	}
	public Double Lon()
	{
		return lon;
	}

}
