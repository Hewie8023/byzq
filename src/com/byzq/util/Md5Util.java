package com.byzq.util;

import java.security.MessageDigest;


public class Md5Util {

	public static String MD5(String sourceStr) {
		try {
			// ���MD5ժҪ�㷨�� MessageDigest����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(sourceStr.getBytes());
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int tmp = md[i];
				if (tmp < 0)
					tmp += 256;
				if (tmp < 16)
					buf.append("0");
				buf.append(Integer.toHexString(tmp));
			}
			return buf.toString().substring(8, 24);// 16λ����
			// return buf.toString();// 32λ����
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		System.out.println(Md5Util.MD5("123456"));
//	}

}
