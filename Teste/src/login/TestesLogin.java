package login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestesLogin {

	@Test
	public void testLogin1() {
		assertTrue(LoginDAO.verificaLogin(null, null));
	}
	@Test
	public void testLogin2() {
		assertFalse(LoginDAO.verificaLogin("user", "user"));
	}
	
	@Test
	public void testLogin3() {
		assertTrue(LoginDAO.verificaLogin("teste", "1234"));
	}
	
}
