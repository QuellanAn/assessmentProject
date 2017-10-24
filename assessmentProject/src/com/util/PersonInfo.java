package com.util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonInfo {
	private int day;
	private double year;
	private int sex;
	private String address;
	
	public void setNo(String personNo) throws UnsupportedEncodingException{
    
		InputStream inputStream = PersonInfo.class.getResourceAsStream("/com/info/Information.txt");
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        
        Map<String,String> map = new HashMap<String,String>();
        String line;
        try {
			while((line = reader.readLine())!=null){
					map.put(line.substring(0,6), line.substring(6).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        address = map.get(personNo.substring(0,6)).replace("null", "");
        
        long time = 0;
		try {
			time = new Date().getTime() - new SimpleDateFormat("yyyyMMdd").parse(personNo.substring(6, 14)).getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        
        day = (int)(time/(long)(24*3600*1000));
        year = Double.parseDouble(String.format("%.0f", (double)(day/365.0)));
        
        sex = (Integer.parseInt(personNo.substring(14,17))%2 == 1)? 1:2;
        
        try {
			inputStream.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public int getDay() {
		return day;
	}

	public double getYear() {
		return year;
	}

	public int getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}
	
	
}
