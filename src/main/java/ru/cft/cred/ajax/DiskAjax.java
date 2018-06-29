package ru.cft.cred.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.cft.cred.services.AjaxService;
import ru.cft.cred.services.DiskService;

@Controller
public class DiskAjax {
	
	@Autowired
	AjaxService ajaxService;
	
	@Autowired
	DiskService diskService;
	
	@RequestMapping(value = "/get_disk_list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody String getDiskList() {
		return ajaxService.toJson(diskService.getDiskList());
	}

}
