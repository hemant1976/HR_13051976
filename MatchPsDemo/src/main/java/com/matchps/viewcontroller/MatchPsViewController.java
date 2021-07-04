package com.matchps.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatchPsViewController {
	@RequestMapping("/viewRecords")
	public String viewRecords() {
		return "view-records";
	}
	
	@RequestMapping("/index")
	public String addRecords() {
		return "add-records";
	}
}
