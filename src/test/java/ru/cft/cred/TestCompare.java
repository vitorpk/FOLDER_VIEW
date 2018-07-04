package ru.cft.cred;

import java.io.IOException;

public class TestCompare {
	
	public static void main(String[] args) {
		String str1 = "е";
		String str2 = "ё";
		String str3 = "ж";
		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str3));
		System.out.println(str1.compareTo(str3));
	}
}
