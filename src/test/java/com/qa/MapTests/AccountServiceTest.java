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
	private final String ACCOUNT_JSON_1 = "{'id':1,'accountNumber':'ADC123','firstName':'ADAM','lastName':'SMITH'}";
	private final String ACCOUNT_JSON_2 = "{'id':2,'accountNumber':'ADC124','firstName':'JOSEPH','lastName':'ADAMSON'}";
	private final String ACCOUNT_JSON_3 = "{'id':3,'accountNumber':'ADC125','firstName':'JOSEPH','lastName':'JOSEPHSON'}";
	private final String ACCOUNT_JSON_4 = "{'id':4,'accountNumber':'ADC126','firstName':'ANDREW','lastName':'ADAMSON'}";

	private final Account ACCOUNT_1 = new Account(1, "ADC123", "SCOOT", "PACINO");

	@Before
	public void setup() {
		this.amr = new AccountMapRepository();
		this.amr.createAccount(this.ACCOUNT_JSON_1);
		this.amr.createAccount(this.ACCOUNT_JSON_2);
		this.amr.createAccount(this.ACCOUNT_JSON_3);
		this.amr.createAccount(this.ACCOUNT_JSON_4);
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
		Integer i = 0;
		assertEquals(i, this.amr.countFirstNames("NATHAN"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		Integer i = 1;
		assertEquals(i, this.amr.countFirstNames("ANDREW"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		Integer i = 2;
		assertEquals(i, this.amr.countFirstNames("JOSEPH"));
	}

}
