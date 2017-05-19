package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.jkernel.ByteArrayToFromHexDigits;

public class CommonsUtil {

	public static String md5(String str){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(str.getBytes());
			return ByteArrayToFromHexDigits.bytesToHexString(bytes);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("md5 falue:"+e.getMessage());
		}
		return "";
	}
	
//	public static String format(Date date){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		return sdf.format(date);
//	}
//	
//	public static Date parse(String str){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			return sdf.parse(str);
//		} catch (ParseException e) {
//			//e.printStackTrace();
//		}
//		return null;
//	}
	
	private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		}
		
	};
	
	/**
	 * date转字符串
	 * @param date
	 * @return
	 */
	public static String format(Date date){
		return local.get().format(date);
	}
	
	/**
	 * 字符串转date
	 * @param str
	 * @return
	 */
	public static Date parse(String str){
		try {
			return local.get().parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(CommonsUtil.md5("123456"));
	}
}
