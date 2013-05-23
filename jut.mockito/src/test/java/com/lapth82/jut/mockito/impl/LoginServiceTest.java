package com.lapth82.jut.mockito.impl;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lapth82.jut.mockito.exception.AccountLoginLimitReachedException;
import com.lapth82.jut.mockito.exception.AccountNotFoundException;
import com.lapth82.jut.mockito.exception.AccountRevokedException;
import com.lapth82.jut.mockito.intefaces.IAccount;
import com.lapth82.jut.mockito.intefaces.IAccountRepository;

public class LoginServiceTest {

	private IAccount account;
	private IAccountRepository accountRepository;
	private LoginService loginService;
	
	@Before
	public void setUp() throws Exception {
		account = mock(IAccount.class);
		accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);
		
		loginService = new LoginService(accountRepository);
	}

	private void willPasswordMatches(boolean value) {
		when(account.passwordMatches(anyString())).thenReturn(value);
	}
	
	@Test
	public void itShouldSetAccountLoogedInWhenPasswordMatches() {
		willPasswordMatches(true);
		loginService.login("lap", "pass");
		verify(account, times(1)).setLoggedIn(true);
	}
	
	@Test
	public void itShouldSetRevokedAfterThreeFailedLonginAttempts() {
		willPasswordMatches(false);
		for (int i=0; i<3; i++)
			loginService.login("accountId", "password");
		verify(account, times(1)).setRevoked(true);
	}
	
	@Test
	public void isShouldNotRevokedSecondAccountAfterTwoFailedAttemptFirstAccount() {
		IAccount secondAccount = mock(IAccount.class);
		
		when(accountRepository.find("lap")).thenReturn(secondAccount);
		when(secondAccount.passwordMatches(anyString())).thenReturn(false);
		willPasswordMatches(false);
		
		loginService.login("ac1", "pass");
		loginService.login("ac2", "pass");
		loginService.login("lap", "pass");
		
		verify(secondAccount, never()).setRevoked(true);
	}
	
	@Test(expected = AccountLoginLimitReachedException.class)
	public void itShouldNotAllowConcurrentLogin() {
		willPasswordMatches(true);
		when(account.isLoggedIn()).thenReturn(true);
		loginService.login("ac", "password");
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void isAccountNotFound() {
		when(accountRepository.find(anyString())).thenReturn(null);
		loginService.login("ac", "password");
	}
	
	@Test(expected = AccountRevokedException.class)
	public void itShouldNotBePossibleLoginIntoRevokedAccount() {
		when(account.isRevoked()).thenReturn(true);
		willPasswordMatches(true);
		loginService.login("a", "p");
	}
	@After
	public void tearDown() throws Exception {
	}
}
