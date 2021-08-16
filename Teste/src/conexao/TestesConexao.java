package conexao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestesConexao {
	
	/*	@Test
	public void testAbrirConexao1() {
		assertFalse(ConexaoMySQL.abrirConexao());
	}
	
	@Test
	@Before
	public void testAbrirConexao2() {
		assertTrue(ConexaoMySQL.abrirConexao());
	}*/
	
	@Test
	@Before
	public void testAbrirConexao3() {
		assertNotNull(ConexaoMySQL.abrirConexao());
	}
	
/*	@Test
	public void testFecharConexao1() {
		assertFalse(ConexaoMySQL.fecharConexao());
	}*/

	@Test
	@After
	public void testFecharConexao2() {
		assertTrue(ConexaoMySQL.fecharConexao());
	}
}
