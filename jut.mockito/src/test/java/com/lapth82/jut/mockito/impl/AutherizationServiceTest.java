package com.lapth82.jut.mockito.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.lapth82.jut.mockito.bean.User;
import com.lapth82.jut.mockito.intefaces.IUserManager;

import static org.mockito.Mockito.*;

public class AutherizationServiceTest {

	@Mock
	IUserManager userManagerMock;
	
	AutherizationService service;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		service = new AutherizationService(userManagerMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {
		// stub
		when(userManagerMock.getUser("1")).thenReturn(new User("1", "lap", "lapth@gmail.com"));
		when(userManagerMock.getUser("2")).thenReturn(new User("2", "a", "nothing@gmail.com"));
		when(userManagerMock.getUser("3")).thenThrow(new RuntimeException("Out of range"));
		
		User user = service.getUser("1");
		assertEquals(user.getUserName(), "lap");
		
		User user1 = service.getUser("2");
		assertEquals(user1.getEmail(), "nothing@gmail.com");
	}

	@Test
	public void testSetUser() {
		final List<User> lstUser = new ArrayList<>();
		
		// capture the arguments of a method
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				
				if (args != null && args.length > 0 && args[0] != null) {
					User user = (User) args[0];
					
					lstUser.add(user);
				}
				return null;
			}
		}).when(userManagerMock).setUser(any(User.class));
		
		User u1 = new User("1", "lap", "lap@gmail.com");
		User u2 = new User("2", "lap2", "lap2@gmail.com");
		
		service.setUser(u1);
		service.setUser(u2);
		
		assertEquals(u1, lstUser.get(0));
		assertEquals(u2, lstUser.get(1));
	}
}
