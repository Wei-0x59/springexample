package com.fdm.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.entity.User;



public class LoginControllerTest {
	
	
	@Test 
	public void given_getRequestForLogin_when_noActiveSession_then_returnLoginPage() {
		HttpSession mockSession = mock(HttpSession.class);
		User mockUser = mock(User.class);
		
		LoginController controller = new LoginController();
		String nextPage = controller.loadLoginPage(mockSession, mockUser);
		
		verify(mockSession).getAttribute("activeUser");
		assertEquals("login", nextPage);
		
	}
	
	@Test 
	public void given_getRequestForLogin_when_an_ActiveSession_then_returnHomePage() {
		HttpSession mockSession = mock(HttpSession.class);
		User mockUser = mock(User.class);
		
		Mockito.when(mockSession.getAttribute("activeUser")).thenReturn("Test User Name");
		
		LoginController controller = new LoginController();
		String nextPage = controller.loadLoginPage(mockSession, mockUser);
		
		verify(mockSession).getAttribute("activeUser");
		assertEquals("home", nextPage);
		
	}

}
