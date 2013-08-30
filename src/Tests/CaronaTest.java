package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Carona;

public class CaronaTest {

	Carona a;

	@Before
	public void inicializar(){
		a = new Carona("joao", "campina", "22/12/2013", "22:00", 5, "eu", "usuario");
	}
	@Test
	public void Origem() {
		try{
			a.setOrigem("");
			fail("origem invalida");
		}catch(Exception e){
			assertTrue("Origem Invalida", e instanceof IllegalArgumentException);
			assertEquals("Origem inválida", e.getMessage());
		}
		try{
			a.setOrigem(null);
			fail("origem invalida");
		}catch(Exception e){
			assertTrue("Origem Invalida", e instanceof IllegalArgumentException);
			assertEquals("Origem inválida", e.getMessage());
		}
		try{
			a.setOrigem("12..,asas");
			fail("origem invalida");
		}catch(Exception e){
			assertTrue("Origem Invalida", e instanceof IllegalArgumentException);
			assertEquals("Origem inválida", e.getMessage());
		}
	}
	@Test public void Destino(){
		try{
			a.setDestino("");
			fail("Destino invalido");
		}catch(Exception e){
			assertTrue("Destino Invalido", e instanceof IllegalArgumentException);
			assertEquals("Destino inválido", e.getMessage());
		}
		try{
			a.setDestino(null);
			fail("Destino Invalido");
		}catch(Exception e){
			assertTrue("Destino Invalido", e instanceof IllegalArgumentException);
			assertEquals("Destino inválido", e.getMessage());
		}
		try{
			a.setDestino("12..,asas");
			fail("Destino Invalido");
		}catch(Exception e){
			assertTrue("Destino Invalido", e instanceof IllegalArgumentException);
			assertEquals("Destino inválido", e.getMessage());
		}
	}
	
	@Test public void vagas(){
		try{
			a.setVagas(0);
			fail("vaga Invalida");
		}catch(Exception e){
			assertTrue("Vaga Invalida", e instanceof IllegalArgumentException);
			assertEquals("Vaga inválida", e.getMessage());
		}
		try{
			a.setVagas(-1);
			fail("vaga Invalida");
		}catch(Exception e){
			assertTrue("Vaga Invalida", e instanceof IllegalArgumentException);
			assertEquals("Vaga inválida", e.getMessage());
		}

	}
	@Test public void data(){
		try{
		a.setData(null);
		fail("data invalida");
	}catch(Exception e){
		assertTrue("Data Invalida", e instanceof IllegalArgumentException);
		assertEquals("Data inválida", e.getMessage());
	}
		try{
		a.setData("");
		fail("data invalida");
	}catch(Exception e){
		assertTrue("Data Invalida", e instanceof IllegalArgumentException);
		assertEquals("Data inválida", e.getMessage());
	}
		try{
		a.setData("30/02/2012");
		fail("data invalida");
	}catch(Exception e){
		assertTrue("Data Invalida", e instanceof IllegalArgumentException);
		assertEquals("Data inválida", e.getMessage());
	}
		try{
		a.setData("32/3/2012");
		fail("data invalida");
	}catch(Exception e){
		assertTrue("Data Invalida", e instanceof IllegalArgumentException);
		assertEquals("Data inválida", e.getMessage());
	}
		try{
		a.setData("31/3/2000");
		fail("data invalida");
	}catch(Exception e){
		assertTrue("Data Invalida", e instanceof IllegalArgumentException);
		assertEquals("Data inválida", e.getMessage());
	}
	}
	@Test public void hora(){
		try{
			a.setHora("");
			fail("chora invalida");
		}catch( Exception e){
			assertTrue("Hora Invalida", e instanceof IllegalArgumentException);
			assertEquals("Hora inválida", e.getMessage());
		}
		try{
			a.setHora(null);
			fail("chora invalida");
		}catch( Exception e){
			assertTrue("Hora Invalida", e instanceof IllegalArgumentException);
			assertEquals("Hora inválida", e.getMessage());
		}
		try{
			a.setHora("seis");
			fail("chora invalida");
		}catch( Exception e){
			assertTrue("Hora Invalida", e instanceof IllegalArgumentException);
			assertEquals("Hora inválida", e.getMessage());
		}
	}
		
	}


