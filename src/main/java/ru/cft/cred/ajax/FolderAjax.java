package ru.cft.cred.ajax;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FolderAjax {
	
	@RequestMapping(value = "/check_folder", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public @ResponseBody String checkFolder(@RequestParam(required = true) String folder) {
		
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
