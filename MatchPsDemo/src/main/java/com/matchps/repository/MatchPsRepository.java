package com.matchps.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matchps.mapper.BankRecordRowMapper;
import com.matchps.model.BankRecord;

@Repository
public class MatchPsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Transactional
	public BankRecord createRecord(BankRecord bankRecord)
	{
		String sql = "INSERT INTO BANKRECORD " + "(BANKNAME, CARDNUMBER,EXPIRYDATE) VALUES (?, ?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator()
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException
			{
				PreparedStatement ps = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, bankRecord.getBankName());
				ps.setString(2, bankRecord.getCardNumber());
				ps.setString(3,bankRecord.getExpiryDate());
				return ps;
			}
		}, holder);

		//int generatedId = holder.getKey().intValue();
		//bankRecord.setId(generatedId);
		return bankRecord;
	}

	@Transactional(readOnly = true)
	public List<BankRecord> getBankRecords()
	{
		return jdbcTemplate.query("select * from BANKRECORD ORDER BY EXPIRYDATE DESC", new BankRecordRowMapper());
	}
}
