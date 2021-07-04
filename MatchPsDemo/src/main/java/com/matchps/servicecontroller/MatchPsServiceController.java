package com.matchps.servicecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.matchps.model.BankRecord;
import com.matchps.service.MatchPsService;

@RestController
public class MatchPsServiceController {
	
	@Autowired
	private MatchPsService matchPsService;
	
	@RequestMapping(value = "/createRecord", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createBankRecord(@RequestBody BankRecord bankRecord) {
		bankRecord = matchPsService.createRecord(bankRecord);		
		return new ResponseEntity<>("Record created successfully." + bankRecord.getId(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/fetchRecords", method = RequestMethod.GET)
	@ResponseBody
	public String fetchRecords() {
		Gson gson = new Gson();  
		String jsonString = gson.toJson(matchPsService.fetchRecords()); 		
		return jsonString;
	}

}
