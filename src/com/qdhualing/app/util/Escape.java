package com.qdhualing.app.util;

/**
 * 由于我们的系统是GBK编码，在使用jquery ajax传递中文时，在后台action中乱码(该原因是由于jquery编码为UTF-8产生的)，
 * 使用encodeURI等均在后台中无法转成正常中文。使用escape解决此问题，但是需要自行在后台解码（重写js unescape方法），
 * 解码方法如下的unescape方法。
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
