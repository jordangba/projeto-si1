//package Tests;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import Controller.Controller;
//import Controller.ControllerUsuario;
//import Exception.CadastroException;
//import Exception.LoginException;
//import Exception.UsuarioException;
//import Model.Carona;
//import Model.Usuario;
//
//public class ControllerUsuarioTest {
//
//	private ControllerUsuario controller;
//	private Usuario usuario1;
//
//	@Before
//	public void inicia() {
//		this.controller = new ControllerUsuario();
//		this.usuario1 = new Usuario();
//	}
//
//	private void helpMetodo(Usuario usuario) {
//		try {
//			usuario.setNome("usuario1");
//			usuario.setLogin("usuario1");
//			usuario.setEmail("usuario1");
//			usuario.setEndereco("usuario1");
//			usuario.setSenha("usuario1");
//		} catch (Exception e) {
//		}
//	}
//
//	@Test
//	public void testCadastraUsuario() throws UsuarioException {
//		helpMetodo(usuario1);
//		Assert.assertTrue(this.controller.getUsuarios().size() == 0);
//		// Cadastrando usuário correto.
//		try {
//			controller.cadastraUsuario(usuario1);
//		} catch (CadastroException e) {
//			Assert.fail();
//		}
//
//		// Usuario Cadastrado.
//		Assert.assertTrue(this.controller.getUsuarios().size() == 1);
//
//		Usuario usuario2 = new Usuario();
//		helpMetodo(usuario2);
//
//		// Adicionando novo usuário com atributos iguais
//		try {
//			controller.cadastraUsuario(usuario2);
//			Assert.fail();
//		} catch (CadastroException e) {
//			Assert.assertEquals(e.getMessage(), "Login já cadastrado");
//		}
//
//		Usuario usuario3 = new Usuario();
//		helpMetodo(usuario3);
//		usuario3.setLogin("Usuario3");
//		Assert.assertTrue(this.controller.getUsuarios().size() == 1);
//
//		// Adicionando novo usuario com login diferente mas com email igual
//		try {
//			controller.cadastraUsuario(usuario3);
//			Assert.fail();
//		} catch (CadastroException e) {
//			Assert.assertEquals(e.getMessage(), "Email já cadastrado");
//		}
//		Assert.assertTrue(this.controller.getUsuarios().size() == 1);
//
//		// Criando um novo usuário com atributos diferentes.
//		Usuario usuario4 = new Usuario();
//		usuario4.setLogin("usuario4");
//		usuario4.setEmail("usuario4");
//		usuario4.setNome("usuario4");
//		usuario4.setSenha("usuario4");
//
//		// Adicionando novo usuário correto;
//		try {
//			controller.cadastraUsuario(usuario4);
//		} catch (CadastroException e) {
//			Assert.fail();
//		}
//
//		Assert.assertTrue(this.controller.getUsuarios().size() == 2);
//
//	}
//
//	@Test
//	public void testLogin() {
//		Assert.assertTrue(this.controller.getUsuarios().size() == 0);
//		Usuario usuario2 = new Usuario();
//		Usuario usuario3 = new Usuario();
//		Usuario usuario4 = new Usuario();
//		Usuario usuario5 = new Usuario();
//		createECadastraUsuarios(usuario2, usuario3, usuario4, usuario5);
//		Assert.assertTrue(this.controller.getUsuarios().size() == 5);
//		Usuario user = null;
//
//		// Login com string vazio;
//		try {
//			user = controller.login("", "usuario1");
//			Assert.fail();
//		} catch (LoginException e) {
//			Assert.assertEquals(e.getMessage(), "Login inválido");
//		}
//
//		// Login enviando null
//		try {
//			user = controller.login(null, "usuario1");
//			Assert.fail();
//		} catch (LoginException e) {
//			Assert.assertEquals(e.getMessage(), "Login inválido");
//		}
//
//		// Login com usuário existente mas com senha errada
//		try {
//			user = controller.login(usuario3.getLogin(), "senhaErrada");
//			Assert.fail();
//		} catch (LoginException e) {
//			Assert.assertEquals(e.getMessage(), "Atributo inválido");
//		}
//
//		// Login com usuário inexistente
//		try {
//			user = controller.login("UsuarioInexistente", usuario1.getSenha());
//			Assert.fail();
//		} catch (LoginException e) {
//			Assert.assertEquals(e.getMessage(), "Usuário inexistente");
//		}
//
//		Assert.assertTrue(user == null);
//		// Login com usuario cadastrado
//		try {
//			user = controller.login(usuario1.getLogin(), usuario1.getSenha());
//		} catch (LoginException e) {
//			Assert.fail();
//		}
//
//		Assert.assertTrue(user.equals(usuario1));
//
//		// Login com usuario cadastrado
//		try {
//			user = controller.login(usuario2.getLogin(), usuario2.getSenha());
//		} catch (LoginException e) {
//			Assert.fail();
//		}
//
//		Assert.assertTrue(user.equals(usuario2));
//		
//		Controller con = new Controller();
//		helpMetodo(usuario1);
//		Carona carona = new Carona("A", "B", "28/08/2013", "20:00", 11, "ASASADASDASDADSaaaa", "usuario1");
//		Carona carona1 = new Carona("C", "D", "28/08/2013", "20:00", 11, "1111ASASADASDASDADSaaaa", "usuario1");
//		try {
//			con.cadastraUsuario(usuario1);
//		} catch (CadastroException e) {
//		}
//		con.cadastraCarona(usuario1, carona);
//		con.cadastraCarona(usuario1, carona1);
//		System.out.println(con.getCarona().size());
//		System.out.println(con.buscaCarona("a", "B").size());
//		
//
//	}
//
//	private void createECadastraUsuarios(Usuario usuario2, Usuario usuario3,
//			Usuario usuario4, Usuario usuario5) {
//		helpMetodo(usuario1);
//
//		usuario2.setLogin("usuario2");
//		usuario2.setEmail("usuario2");
//		usuario2.setNome("usuario2");
//		usuario2.setSenha("usuario2");
//
//		usuario3.setLogin("usuario3");
//		usuario3.setEmail("usuario3");
//		usuario3.setNome("usuario3");
//		usuario3.setSenha("usuario3");
//
//		usuario4.setLogin("usuario4");
//		usuario4.setEmail("usuario4");
//		usuario4.setNome("usuario4");
//		usuario4.setSenha("usuario4");
//
//		usuario5.setLogin("usuario5");
//		usuario5.setEmail("usuario5");
//		usuario5.setNome("usuario5");
//		usuario5.setSenha("usuario5");
//
//		try {
//			this.controller.cadastraUsuario(usuario1);
//			this.controller.cadastraUsuario(usuario2);
//			this.controller.cadastraUsuario(usuario3);
//			this.controller.cadastraUsuario(usuario4);
//			this.controller.cadastraUsuario(usuario5);
//		} catch (CadastroException e) {
//		}
//	}
//
//}
