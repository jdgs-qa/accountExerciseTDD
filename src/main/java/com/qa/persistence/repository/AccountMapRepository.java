package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	private int count = 1;

	private JSONUtil json = new JSONUtil();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createAccount(String account) {
		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.put(this.count++, toAdd);
		if (this.accountMap.containsValue(toAdd)) {
			return SUCCESS;
		} else {
			return "Failed to add account";
		}
	}

	public String deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateAccount(int accountNumber, String account) {
		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.replace(accountNumber, toUpdate);
		if (this.accountMap.containsValue(toUpdate)) {
			return FAILURE;
		} else {
			return "Failed to add account";
		}
	}

}
