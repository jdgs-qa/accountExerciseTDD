package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.Status;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository amr;
	private JSONUtil j;
	private final String ACCOUNT_JSON_1 = "{\"id\":1,\"accountNumber\":\"ADC123\",\"firstName\":\"JOSEPH\",\"lastName\":\"SMITH\"}";
	private final String ACCOUNT_JSON_2 = "{\"id\":2,\"accountNumber\":\"ADC124\",\"firstName\":\"ADAM\",\"lastName\":\"ADAMSON\"}";
	private final String ACCOUNT_JSON_3 = "{\"id\":3,\"accountNumber\":\"ADC125\",\"firstName\":\"JOSEPH\",\"lastName\":\"JOSEPHSON\"}";
	private final String ACCOUNT_JSON_4 = "{\"id\":4,\"accountNumber\":\"ADC126\",\"firstName\":\"ANDREW\",\"lastName\":\"ADAMSON\"}";

	private final Account ACCOUNT_1 = new Account(1, "ADC123", "JOSEPH", "SMITH");

	@Before
	public void setup() {
		this.amr = new AccountMapRepository();
		this.j = new JSONUtil();
		this.amr.createAccount(this.ACCOUNT_JSON_1);
		this.amr.createAccount(this.ACCOUNT_JSON_2);
		this.amr.createAccount(this.ACCOUNT_JSON_3);
		this.amr.createAccount(this.ACCOUNT_JSON_4);
	}

	@Test
	public void addAccountTest() {
		assertEquals("Failed to add account", Status.SUCCESS, this.amr.createAccount(this.ACCOUNT_JSON_1));
	}

	@Test
	public void updateAccountTest() {
		this.amr.createAccount(this.ACCOUNT_JSON_1);
		assertEquals("Failed to update account", Status.FAILURE, this.amr.updateAccount(1, this.ACCOUNT_JSON_2));
	}

//	@Test
//	public void remove2AccountTestAnd1ThatDoesntExist() {
//		fail("TODO");
//	}

//	@Test
//	public void jsonStringToAccountConversionTest() {
//		assertEquals(this.ACCOUNT_1, j.getObjectForJSON(this.ACCOUNT_JSON_1, Account.class));
//	}

	@Test
	public void accountConversionToJSONTest() {
		assertEquals(this.ACCOUNT_JSON_1, j.getJSONForObject(this.ACCOUNT_1));
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
