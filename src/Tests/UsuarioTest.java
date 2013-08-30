package Tests;

import static org.junit.Assert.*;

import org.junit.Test;


import Model.Usuario;

public class UsuarioTest {

	@Test
	public void setEmailUsuario() {
		try{
			Usuario a = new Usuario();
			a.setEmail(null);
			fail("email invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Email Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Email inv�lido", e.getMessage());
		}
		try{
			Usuario a = new Usuario();
			a.setEmail("");
			fail("email invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Email Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Email inv�lido", e.getMessage());
		}
		
	}
	@Test
	public void setLoginUsuario() {
		try{
			Usuario a = new Usuario();
			a.setLogin(null);
			fail("Login invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Login Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Login inv�lido", e.getMessage());
		}
		try{
			Usuario a = new Usuario();
			a.setLogin("");
			fail("Login invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Login Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Login inv�lido", e.getMessage());
		}
		
	}
	@Test
	public void setSenhaUsuario() {
		try{
			Usuario a = new Usuario();
			a.setSenha(null);
			fail("Senha invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou uma Senha Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Senha inv�lida", e.getMessage());
		}
		try{
			Usuario a = new Usuario();
			a.setSenha("");
			fail("Senha invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou uma Senha Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Senha inv�lida", e.getMessage());
		}
		
	}
	@Test
	public void setNomeUsuario() {
		try{
			Usuario a = new Usuario();
			a.setNome(null);
			fail("Nome invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Nome Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Nome inv�lido", e.getMessage());
		}
		try{
			Usuario a = new Usuario();
			a.setNome("");
			fail("Nome invalido");
		}catch(Exception e){
			 assertTrue("Nao disparou um Nome Invalido",e instanceof IllegalArgumentException);
			 assertEquals("Nome inv�lido", e.getMessage());
		}
		
	}

}
