package cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestesCliente {

	@Test
	public void testCadadastro1() {
		Cliente cli = new Cliente(null, null, ' ', null, null, null, null, null);
		assertEquals(ClienteDAO.cadastraCliente(cli), true);
	}

	@Test
	@Before
	public void testCadadastro2() {
		Cliente cli = new Cliente("646.119.630-71", "Ciclana de Tal", 'F', "Programador", "Rua Ciclana, 1234",
				"ciclana@mail.com", "(81) 72636-2046", "10/08/1980");
		assertEquals(ClienteDAO.cadastraCliente(cli), true);
	}
	
	@Test
	@Before
	public void testCadadastro3() {
		Cliente cli = new Cliente("646.119.630-71", "Ciclana de Tal", 'F', "Programador", "Rua Ciclana, 1234",
				"ciclana@mail.com", "(81) 72636-2046", "10/08/1980");
		assertEquals(ClienteDAO.cadastraCliente(cli), false);
	}
	
	@Test
	public void testConsulta1() {
		Cliente cli = new Cliente("541.887.160-96", null, (char) 0, null, null, null, null, null);
		assertEquals(ClienteDAO.consultaCliente(cli), false);
	}
	
	@Test
	public void testConsulta2() {
		Cliente cli = new Cliente("646.119.630-71", null, (char) 0, null, null, null, null, null);
		assertEquals(ClienteDAO.consultaCliente(cli), true);
	}


	@Test
	public void testAtualiza1() {
		Cliente cli = new Cliente("541.887.160-96", "Ciclana de Tal", 'F', "Nutricionista", "Rua Ciclana, 1234",
				"ciclana@mail.com", "(81) 72636-2046", "10/08/1980");
		assertEquals(ClienteDAO.atualizaCliente(cli), true);
	}
	
	@Test
	public void testAtualiza2() {
		Cliente cli = new Cliente("646.119.630-71", "Ciclana de Tal", 'F', "Nutricionista", "Rua Ciclana, 1234",
				"ciclana@mail.com", "(81) 72636-2046", "10/08/1980");
		assertEquals(ClienteDAO.atualizaCliente(cli), true);
	}
	
	@Test
	@After
	public void testRemove1() {
		Cliente cli = new Cliente("541.887.160-96", null, (char) 0, null, null, null, null, null);
		assertEquals(ClienteDAO.deletaCliente(cli.getCpf()), false);
	}
	@Test
	@After
	public void testRemove2() {
		Cliente cli = new Cliente("646.119.630-71", null, (char) 0, null, null, null, null, null);
		assertEquals(ClienteDAO.deletaCliente(cli.getCpf()), true);
	}

}
