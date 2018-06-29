package ru.cft.cred.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.cft.cred.services.FolderService;

@Controller
public class FolderAjax {
	
	@Autowired
	FolderService folderService;
	
	@RequestMapping(value = "/check_folder", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public @ResponseBody String checkFolder(@RequestParam(required = true) String folder) {
		return folderService.checkFolder(folder);
	}

}
