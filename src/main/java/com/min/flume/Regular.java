package com.min.flume;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher matcher = pattern.matcher("d湿答答");
		while (matcher.find()) {
			System.out.println(matcher.group(0));
		}
	
		//charReplace();
		//getStr();
		//email();
	}

	public static boolean getData(String string) {
		String regex = "[a-z][A-Z]{3}\\s+[0-9]{1,2},[0-9]{4}";
		return string.matches(regex);
	}

	public static void charReplace() {
		String regex = "g+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("fgfefsfdgfDFSFSsggggswgaufgaysfgy");
		String string = matcher.replaceAll("1");
		System.out.println(string);
	}

	public static void getStr() {
		boolean matches = Pattern.matches(".+/(.+)$", "d://sys/f1/f2.txt");
		System.out.println(matches);
	}
	
	public static void email() {
		System.out.println(Pattern.matches("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}", "1111"));
	}
}