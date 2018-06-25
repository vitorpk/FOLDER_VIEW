package ru.cft.cred;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class TestOther {

	public static void main(String[] args) {
		testEncode64("Base64 - это специальный метод кодирования информации в 64-разрядный код (6 бит).");
		testImmutableList();
	}

	private static void testEncode64(String str) {
		System.out.println(Base64.encode(str.getBytes()));
	}

	private static void testImmutableList() {
		List<Integer> list = ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
		// list.add(17);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(list);
	}

}
