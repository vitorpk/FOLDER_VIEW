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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import ru.cft.cred.entities.Folder;
import ru.cft.cred.services.FolderService;

public class TestReadDirs {
	private final static String INIT_DIR = "C:\\";

	public static void main(String[] args) throws IOException {
		FolderService folderService = new FolderService();
		
		folderService.initFolderList();
		folderService.setFolderList(INIT_DIR);
		
		Map<String, Folder> folderMap = folderService.getFolderList();
		List<Folder> folderList = new ArrayList<Folder>();
		
		for (Map.Entry<String, Folder> entry : folderMap.entrySet()) {
			Folder folder = entry.getValue();
			//System.out.println(entry.getKey() + ", size = " + folder.getSize());
			folderList.add(folder);
			//System.out.println("    " + folder.getName());
			//System.out.println("    " + folder.getParent());
			//System.out.println("    " + folder.getSize());
		}
		
		/*folderList.sort(new Comparator<Folder>() {
		    public int compare(Folder folder1, Folder folder2) {
		    	String path1 = folder1.getPath();
		    	String path2 = folder2.getPath();
		    	if (path1.equals(path2))
		    		return 0;
		    	else if (path1.compareToIgnoreCase(path2) > 0)
		    		return 1;
		    	else
		    		return -1;
		    }
		});*/
		
		for (Folder folder : folderList) {
			if (folder.getParent().equals(INIT_DIR) || folder.getPath().equals(INIT_DIR))
			//if (folder.getPath().indexOf("\\", 8) < 0)
				System.out.println(folder.getPath() + "\t" + folder.getSize());
		}
	}

}
