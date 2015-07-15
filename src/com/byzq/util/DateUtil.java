package com.byzq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date StringtoDate(String str){
		//2015-07-02  10£º24  yyyy-MM-dd HH:mm:ss
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = (Date) sf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static String DatetoString(Date date,String s){
		SimpleDateFormat sdf=new SimpleDateFormat(s);
		String time = sdf.format(date);
		return time;
	}
	public static String DatetoString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
}
