package ru.cft.cred;

import java.io.File;
import java.io.IOException;

public class TestFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File[] roots = File.listRoots();
		for (File file: roots) {
			System.out.println(file.getName());
			System.out.println(file.getFreeSpace());
		    System.out.println(file.getAbsolutePath());
		}
	}
}
