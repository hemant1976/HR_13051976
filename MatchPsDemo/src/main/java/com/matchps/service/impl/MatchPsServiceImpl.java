package com.matchps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchps.model.BankRecord;
import com.matchps.repository.MatchPsRepository;
import com.matchps.service.MatchPsService;

@Service
public class MatchPsServiceImpl implements MatchPsService {
	
	@Autowired
	private MatchPsRepository matchPsRepository;

	@Override
	public BankRecord createRecord(BankRecord bankRecord) {
		return matchPsRepository.createRecord(bankRecord);		
	}

	@Override
	public List<BankRecord> fetchRecords() {
		return matchPsRepository.getBankRecords();		
	}

}
