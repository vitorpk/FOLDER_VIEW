package ru.cft.cred.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.cft.cred.entities.Folder;

@Service
public class FolderService {
	
	private final Logger logger = LoggerFactory.getLogger(FolderService.class);
	
	private Map<String, Folder> folderList = new HashMap<String, Folder>();
	
	private long numProc;

	public String checkFolder(String folder) {
		
		if (logger.isInfoEnabled()) logger.info("checkFolder: folder = " + folder);
		
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
		
		boolean isInfoEnabled = logger.isInfoEnabled();
		
		if (isInfoEnabled) logger.info("setFolderList: path = " + path);

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		Path filePath = Paths.get(absolutePath);
		String fileName = file.getName();
		if (fileName.equals(""))
			fileName = file.getPath();
		String realPath = getRealPath(filePath);
		
		if (isInfoEnabled) logger.info("setFolderList: fileName = " + fileName + ", realPath = " + realPath);
		
		if (!folderList.containsKey(realPath)) {
			folderList.put(realPath, Folder.builder()
					.name(fileName)
					.parent("")
					.path(realPath)
					.size(0)
					.build());
			if (isInfoEnabled) logger.info("setFolderList:     + folder " + realPath);
		}

		File[] fileList = file.listFiles();
		
		if (isInfoEnabled) logger.info("setFolderList: fileList.length = " + (fileList == null ? "null" : fileList.length));
		
		if (fileList != null) {
			for (int j = 0; j < fileList.length; j++) {
				numProc++;
				if (numProc % 1000 == 0)
					System.out.println(numProc);
				File fileInList = fileList[j];
				absolutePath = fileInList.getAbsolutePath();
				filePath = Paths.get(absolutePath);
				fileName = filePath.getFileName().toString();
				realPath = getRealPath(filePath);
				String parentPath = getRealPath(filePath.getParent());
				
				if (isInfoEnabled) {
					logger.info("setFolderList:   fileName = " + fileName);
					logger.info("setFolderList:     realPath = " + realPath);
					logger.info("setFolderList:     absolutePath = " + absolutePath);
					logger.info("setFolderList:     parentPath = " + parentPath);
					logger.info("setFolderList:     isDirectory = " + fileInList.isDirectory());
				}
				
				if (realPath.equals(absolutePath)) {
					if (fileInList.isDirectory()) {
						folderList.put(realPath, Folder.builder()
								.name(fileName)
								.parent(parentPath)
								.path(realPath)
								.size(0)
								.build());
						if (isInfoEnabled) logger.info("setFolderList:     + folder " + realPath);
						setFolderList(absolutePath);
					} else {
						long size = fileInList.length();
						if (isInfoEnabled) logger.info("setFolderList:     size = " + size);
						if (size != 0 && folderList.containsKey(parentPath)) {
							if (isInfoEnabled) logger.info("setFolderList:     set size");
							Folder folder = folderList.get(parentPath);
							while (parentPath != "") {
								folder = folderList.get(parentPath);
								folder.setSize(folder.getSize() + size);
								parentPath = folder.getParent();
							}
						}
					}
				} else {
					if (isInfoEnabled) logger.info("setFolderList:     other way");
				}
			}
		}
	}
	
	public void initFolderList() {
		folderList.clear();
		numProc = 0;
	}
	
	private String getRealPath(Path filePath) {
		if (filePath == null)
			return "";
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
