package com.qdhualing.app.util;

/**
 * �������ǵ�ϵͳ��GBK���룬��ʹ��jquery ajax��������ʱ���ں�̨action������(��ԭ��������jquery����ΪUTF-8������)��
 * ʹ��encodeURI�Ⱦ��ں�̨���޷�ת���������ġ�ʹ��escape��������⣬������Ҫ�����ں�̨���루��дjs unescape��������
 * ���뷽�����µ�unescape������
 */
public class Escape {

	public static String unescape(String src) {
		if (src == null) {
			return null;
		}

		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;

		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(
							src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(
							src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}

		return tmp.toString();
	}

}
