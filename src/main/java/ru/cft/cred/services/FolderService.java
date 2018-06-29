package ru.cft.cred.services;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FolderService {

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
}
