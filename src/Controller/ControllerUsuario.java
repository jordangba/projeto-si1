package Controller;

import java.util.HashMap;
import java.util.Map;

import Exception.CadastroException;
import Exception.LoginException;
import Model.Usuario;

public class ControllerUsuario {

	private Map<String, Usuario> usuarios;
	private String logged = "";
	
	public ControllerUsuario() {
		this.usuarios = new HashMap<String, Usuario>();
	}

	public Map<String, Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setNameLogged(String name) {
		this.logged = name;
	}

	public Usuario getLoggedUser(){
		return this.usuarios.get(logged);
	}
	
	public String getNameUserLogged() {
		String retorno = "";
		Usuario user = usuarios.get(logged);
		retorno = user.getNome();
		return retorno;
	}

	public Usuario buscaUsuario(String login){
		return this.usuarios.get(login);
	}
	
	public String getAddressUserLogged() {
		String retorno = "";
		Usuario user = usuarios.get(logged);
		retorno = user.getEndereco();
		return retorno;
	}

	public Usuario login(String login, String password) throws LoginException {
		// Checa se ï¿½ passado null ou string vazia
		if (login == null || login.isEmpty()) {
			throw new LoginException("Login inválido");
		}
		// Busca pelo usuï¿½rio
		Usuario user = usuarios.get(login);
		if (user != null) {
			// Checando se a senha ï¿½ a mesma
			if (user.getSenha().equals(password)) {
				return user;
			} else {
				throw new LoginException("Login inválido");
			}
			// Caso nï¿½o encontre nenhum usuï¿½rio com o login passado
		} else {
			throw new LoginException("Usuário inexistente");
		}
	}

	// public void cadastraUsuario(String login, String senha, String nome,
	// String endereco, String email) throws CadastroException,
	// UsuarioException {
	// // Checando se jï¿½ houver usuï¿½rio cadastrado
	//
	// if (this.usuarios.containsKey(login)) {
	// throw new CadastroException("Login jï¿½ cadastrado");
	// } else {
	// // Checando se tem algum email jï¿½ cadastrado
	// for (Usuario user : this.usuarios.values()) {
	// if (user.getEmail().equals(email)) {
	// throw new CadastroException("Email jï¿½ cadastrado");
	// }
	// }
	// Usuario newUsuario = new Usuario();
	// newUsuario.setEmail(email);
	// newUsuario.setEndereco(endereco);
	// newUsuario.setLogin(login);
	// newUsuario.setNome(nome);
	// newUsuario.setSenha(senha);
	// this.usuarios.put(login, newUsuario);
	// }
	// }

	public void cadastraUsuario(Usuario usuario) throws CadastroException {
		// Checando se tem algum login jï¿½ cadastrado
		if (this.usuarios.containsKey(usuario.getLogin())) {
			throw new CadastroException("Já existe um usuário com este login");
		} else {
			// Checando se tem algum email jï¿½ cadastrado
			for (Usuario user : this.usuarios.values()) {
				if (user.getEmail().equals(usuario.getEmail())) {
					throw new CadastroException("Já existe um usuário com este email");
				}
			}
			// Adicionando novo usuï¿½rio
			this.usuarios.put(usuario.getLogin(), usuario);
		}
	}

}
