package com.qa;

import com.qa.persistence.repository.AccountMapRepository;

public class App {

	private static final String ACCOUNT_JSON_1 = "{'id':1,'accountNumber':'ADC123','firstName':'ADAM','lastName':'SMITH'}";
	private static final String ACCOUNT_JSON_2 = "{'id':2,'accountNumber':'ADC124','firstName':'JOSEPH','lastName':'ADAMSON'}";
	private static final String ACCOUNT_JSON_3 = "{'id':3,'accountNumber':'ADC125','firstName':'JOSEPH','lastName':'JOSEPHSON'}";
	private static final String ACCOUNT_JSON_4 = "{'id':4,'accountNumber':'ADC126','firstName':'ANDREW','lastName':'ADAMSON'}";
	private static AccountMapRepository amr;

	public static void main(String[] args) {
		amr = new AccountMapRepository();
		amr.createAccount(ACCOUNT_JSON_1);
		amr.createAccount(ACCOUNT_JSON_2);
		amr.createAccount(ACCOUNT_JSON_3);
		amr.createAccount(ACCOUNT_JSON_4);
	}

}
