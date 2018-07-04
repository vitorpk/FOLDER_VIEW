package ru.cft.cred.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import ru.cft.cred.entities.Folder;

@Service
public class FolderService {
	
	Map<String, Folder> folderList = new HashMap<String, Folder>();

	public String checkFolder(String folder) {
		if (StringUtils.isEmpty(folder))
			return "Пустое имя каталога";
		
		File fold = new File(folder);
		
		if (!fold.exists())
			return "Каталог " + folder + " не существует";
		
		if (!fold.isDirectory())
			return folder + " не является каталогом";
		
		if (!fold.canRead())
			return "У Вас нет права чтения в каталоге " + folder;
		
		if (!fold.canWrite())
			return "У Вас нет права записи в каталоге " + folder;
		
		return "OK";
	}
	
	public Map<String, Folder> getFolderList() {
		return folderList; 
	}
	
	public void setFolderList(String path) {
		
		//System.out.println("path = " + path);

		//List<Folder> folderList = new ArrayList<Folder>();
		//Map<String, Folder> folderList = new HashMap<String, Folder>();

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		Path filePath = Paths.get(absolutePath);
		String fileName = filePath.getFileName().toString();
		String realPath = getRealPath(filePath);
		
		if (!folderList.containsKey(realPath))
			folderList.put(realPath, Folder.builder()
					.name(fileName)
					.parent("")
					.path(realPath)
					.size(0)
					.build());

		File[] fileList = file.listFiles();
		
		if (fileList != null) {
			for (int j = 0; j < fileList.length; j++) {
				File fileInList = fileList[j];
				absolutePath = fileInList.getAbsolutePath();
				filePath = Paths.get(absolutePath);
				fileName = filePath.getFileName().toString();
				realPath = getRealPath(filePath);
				String parentPath = getParentPath(filePath);
				
				if (realPath.equals(absolutePath)) {
					if (fileList[j].isDirectory()) {
						//System.out.println(realPath + " " + parentPath);
						folderList.put(realPath, Folder.builder()
								.name(fileName)
								.parent(parentPath)
								.path(realPath)
								.size(0)
								.build());
						//System.out.println(realPath);
						/*folderList.add(Folder.builder()
								.name(.getFileName())
								.path(realPath)
								.build());*/
						setFolderList(absolutePath);
					} else {
						long size = fileInList.length();
						//System.out.println(size + " " + parentPath);
						if (size != 0 && folderList.containsKey(parentPath)) {
							Folder folder = folderList.get(parentPath);
							//folder.setSize(folder.getSize() + size);
							parentPath = String.valueOf(folder.getParent());
							while (parentPath != "") {
								folder = folderList.get(parentPath);
								folder.setSize(folder.getSize() + size);
								parentPath = folder.getParent();
							}
							//System.out.println(size + " " + parentPath + " " + fileName);
							//System.out.println(folder);
							//folderList.put(parentPath, folder);
						}
						/*folderList.add(Folder.builder()
								.name(.getFileName())
								.path(realPath)
								.build());*/
						//Path newLink3 = Paths.get("C:\\Documents and Settings");
					}
				} else {
					//System.out.println("diff " + absolutePath);
				}
			}
		}
		
		//System.out.println(folderList);
	}
	
	public void initFolderList() {
		folderList.clear();
	}
	
	private String getParentPath(Path filePath) {
		try {
			Path path = filePath.getParent();
			if (path == null)
				return "";
			path = path.toRealPath();
			if (path == null)
				return "";
			path = path.toAbsolutePath();
			if (path == null)
				return "";
			return path.toString();
		} catch (IOException e) {
			return "";
		}
	}
	
	private String getRealPath(Path filePath) {
		try {
			Path path = filePath.toRealPath();
			if (path == null)
				return "";
			path = path.toAbsolutePath();
			if (path == null)
				return "";
			return path.toString();
		} catch (IOException e) {
			return "";
		}
	}
}
