package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
public class NewRepository implements AccountRepository {

	JSONUtil j = new JSONUtil();

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public String findAnAccount(String accountNumber) {
		return j.getJSONForObject(em.find(Account.class, accountNumber));
	}

	public String getAllAccounts() {
		return j.getJSONForObject(this.em.createQuery("SELECT a from Account a", Account.class).getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		this.em.persist(j.getObjectForJSON(account, Account.class));
		return SUCCESS;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountNumber) throws AccountNotFoundException {
		Account a = this.em.find(Account.class, accountNumber);
		if (a == null) {
			throw new AccountNotFoundException();
		}
		this.em.remove(a);
		return SUCCESS;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int accountNumber, String account) throws AccountNotFoundException {
		Account aNew = j.getObjectForJSON(account, Account.class);
		Account aOld = this.em.find(Account.class, accountNumber);
		if (aOld == null) {
			throw new AccountNotFoundException();
		}
		aOld.setFirstName(aNew.getFirstName());
		aOld.setLastName(aNew.getLastName());
		aOld.setId(aNew.getId());
		aOld.setAccountNumber(aNew.getAccountNumber());
		this.em.persist(aOld);
		return SUCCESS;
	}

}
