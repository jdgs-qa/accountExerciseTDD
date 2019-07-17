package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;

public class AccountServiceTest {

	private AccountMapRepository amr;
	private final String ACCOUNT_JSON_1 = "{'ID':1,'ACCOUNTNUMBER':'ADC123','FIRSTNAME':'SCOOT','LASTNAME':'PACINO'}";
	private final String ACCOUNT_JSON_2 = "{'ID':1,'ACCOUNTNUMBER':'ADC123','FIRSTNAME':'CHAD','LASTNAME':'THUNDER'}";

	private final Account ACCOUNT_1 = new Account(1, "ADC123", "SCOOT", "PACINO");

	@Before
	public void setup() {
		this.amr = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		assertEquals("Failed to add account", AccountRepository.SUCCESS, this.amr.createAccount(this.ACCOUNT_JSON_1));
	}

	@Test
	public void updateAccountTest() {
		this.amr.createAccount(this.ACCOUNT_JSON_1);
		assertEquals("Failed to update account", AccountRepository.FAILURE,
				this.amr.updateAccount(1, this.ACCOUNT_JSON_2));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	public void jsonStringToAccountConversionTest() {
//		assertEquals("Failed to convert JSON to Account", )
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
