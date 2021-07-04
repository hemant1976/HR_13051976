package com.matchps.service;

import java.util.List;

import com.matchps.model.BankRecord;


public interface MatchPsService {
	public BankRecord createRecord(BankRecord bankRecord);
	public List<BankRecord> fetchRecords();
}
