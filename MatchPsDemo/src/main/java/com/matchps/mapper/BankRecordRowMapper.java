package com.matchps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.matchps.model.BankRecord;

public class BankRecordRowMapper implements RowMapper<BankRecord> {

	public BankRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankRecord bankRecord = new BankRecord();
		bankRecord.setId(rs.getInt("ID"));
		bankRecord.setBankName(rs.getString("BankName"));
		bankRecord.setCardNumber(format(rs.getString("CardNumber")));
		bankRecord.setExpiryDate(rs.getString("ExpiryDate"));
		return bankRecord;
	}
	
	private String format(String cardNumber) {
		 StringBuilder sb = new StringBuilder(cardNumber);
		 int lastIndex = sb.lastIndexOf("-");
		 sb.replace(0, lastIndex+1, "XXXX-XXXX-XXXX-");
		 return sb.toString();		
	}

}
