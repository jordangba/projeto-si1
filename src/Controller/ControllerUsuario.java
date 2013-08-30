package Controller;

import java.util.HashMap;
import java.util.Map;

import Exception.CadastroException;
import Exception.LoginException;
import Model.Usuario;

public class ControllerUsuario {

	private Map<String, Usuario> usuarios;

	public ControllerUsuario() {
		this.usuarios = new HashMap<String, Usuario>();
	}

	public Map<String, Usuario> getUsuarios() {
		return this.usuarios;
	}

	String logged = "";

	public void setNameLogged(String name) {
		this.logged = name;
	}

	public String getNameUserLogged() {
		String retorno = "";
		Usuario user = usuarios.get(logged);
		retorno = user.getNome();
		return retorno;
	}

	public String getAddressUserLogged() {
		String retorno = "";
		Usuario user = usuarios.get(logged);
		retorno = user.getEndereco();
		return retorno;
	}

	public Usuario login(String login, String password) throws LoginException {
		// Checa se � passado null ou string vazia
		if (login == null || login.isEmpty()) {
			throw new LoginException("Login inv�lido");
		}
		// Busca pelo usu�rio
		Usuario user = usuarios.get(login);
		if (user != null) {
			// Checando se a senha � a mesma
			if (user.getSenha().equals(password)) {
				return user;
			} else {
				throw new LoginException("Atributo inv�lido");
			}
			// Caso n�o encontre nenhum usu�rio com o login passado
		} else {
			throw new LoginException("Usu�rio inexistente");
		}
	}

	// public void cadastraUsuario(String login, String senha, String nome,
	// String endereco, String email) throws CadastroException,
	// UsuarioException {
	// // Checando se j� houver usu�rio cadastrado
	//
	// if (this.usuarios.containsKey(login)) {
	// throw new CadastroException("Login j� cadastrado");
	// } else {
	// // Checando se tem algum email j� cadastrado
	// for (Usuario user : this.usuarios.values()) {
	// if (user.getEmail().equals(email)) {
	// throw new CadastroException("Email j� cadastrado");
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
		// Checando se tem algum login j� cadastrado
		if (this.usuarios.containsKey(usuario.getLogin())) {
			throw new CadastroException("Login j� cadastrado");
		} else {
			// Checando se tem algum email j� cadastrado
			for (Usuario user : this.usuarios.values()) {
				if (user.getEmail().equals(usuario.getEmail())) {
					throw new CadastroException("Email j� cadastrado");
				}
			}
			// Adicionando novo usu�rio
			this.usuarios.put(usuario.getLogin(), usuario);
		}
	}

}
