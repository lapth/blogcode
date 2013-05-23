package com.lapth82.jut.mockito.impl;

import com.lapth82.jut.mockito.exception.AccountLoginLimitReachedException;
import com.lapth82.jut.mockito.exception.AccountNotFoundException;
import com.lapth82.jut.mockito.exception.AccountRevokedException;
import com.lapth82.jut.mockito.intefaces.IAccount;
import com.lapth82.jut.mockito.intefaces.IAccountRepository;

public class LoginService {
	private final IAccountRepository accountRepository;
	private static int failledAttempts = 0;
	private String oldAccountId = "";
	
	public LoginService(IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void login(String accountId, String password) {
		IAccount account = this.accountRepository.find(accountId);
		
		if (account == null) {
			throw new AccountNotFoundException();
		}
		
		if (account.passwordMatches(password)) {
			if (account.isLoggedIn()) {
				throw new AccountLoginLimitReachedException();
			}
			if (account.isRevoked()) {
				throw new AccountRevokedException();
			}
			account.setLoggedIn(true);
		} else {
			if (!oldAccountId.equals(accountId)) {
				failledAttempts = 1;
				oldAccountId = accountId;
			} else {
				failledAttempts ++;
			}
		}
		
		if (failledAttempts == 3) {
			account.setRevoked(true);
		}
	}
}
