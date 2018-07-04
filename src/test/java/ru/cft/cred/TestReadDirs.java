package ru.cft.cred;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import ru.cft.cred.entities.Folder;
import ru.cft.cred.services.FolderService;

public class TestReadDirs {

	public static void main(String[] args) throws IOException {
		FolderService folderService = new FolderService();
		
		folderService.initFolderList();
		folderService.setFolderList("C:\\TEMP");
		
		Map<String, Folder> folderList = folderService.getFolderList();
		
		//System.out.println(folderList);
		
		for (Map.Entry<String, Folder> entry : folderList.entrySet()) {
			Folder folder = entry.getValue();
			System.out.println(entry.getKey());
			System.out.println("    " + folder.getName());
			System.out.println("    " + folder.getParent());
			System.out.println("    " + folder.getSize());
		}
	}

}
