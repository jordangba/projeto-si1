package AcceptTest.Simulator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Controller.Controller;
import Exception.CadastroException;
import Exception.CaronaException;
import Exception.LoginException;
import Model.Carona;
import Model.Usuario;

public class CreateAcountSimulator {
	private Controller controller;

	public void zerarSistema() {
		this.controller = new Controller();
	}

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws CadastroException {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		this.controller.cadastraUsuario(usuario);
	}

	public String abrirSessao(String login, String senha) throws LoginException {
		Usuario usuario = controller.login(login, senha);
		return "sessao" + corrigeNomeSessao(usuario.getLogin());
	}

	private String corrigeNomeSessao(String nome) {
		String temp = nome.substring(0, 1);
		String retorno = temp.toUpperCase();
		retorno += nome.substring(1, nome.length());
		return retorno;
	}

	public String getAtributoUsuario(String login, String atributo)
			throws LoginException {
		String retorno = "";
		if (login == null || login.isEmpty())
			throw new LoginException("Login inválido");
		if (atributo == null || atributo.isEmpty())
			throw new LoginException("Atributo inválido");

		if (this.controller.buscaUsuario(login) == null)
			throw new LoginException("Usuário inexistente");

		if (atributo.equals("nome")) {
			retorno = controller.getNameUserLogged();
		} else if (atributo.equals("endereco")) {
			retorno = controller.getAddressUserLogged();
		} else {
			throw new LoginException("Atributo inexistente");
		}
		return retorno;
	}

	// public Map<String, Carona> localizarCarona(String idSessao, String
	// origem,
	// String destino) throws CaronaException {
	// if (idSessao == null || idSessao.isEmpty()) {
	// throw new CaronaException("Sessao inválida");
	// }
	// return this.controller.buscaCarona(idSessao, origem, destino);
	// }

	public String localizarCarona(String idSessao, String origem, String destino)
			throws CaronaException {
		return ColecaoParaString(this.controller.buscaCarona(idSessao, origem,
				destino).keySet());
	}

	private static String ColecaoParaString(Collection<String> collection) {
		if (collection.size() == 0)
			return "{}";
		List<String> lista = new ArrayList<String>(collection);
		Collections.sort(lista);
		String retorno = "";
		for (String numero : lista) {
			retorno = retorno + numero + ",";
		}
		return "{" + retorno.substring(0, retorno.length() - 1) + "}";
	}

	public String cadastrarCarona(String idSessao, String origem,
			String destino, String data, String hora, String vagas)
			throws Exception {
		if (idSessao == null || idSessao.isEmpty())
			throw new Exception("Sessão inválida");
		Usuario usuario = this.controller.getLoggedUser();

		if (!this.abrirSessao(usuario.getLogin(), usuario.getSenha()).equals(
				idSessao)) {
			throw new Exception("Sessão inexistente");
		}
		if (origem == null || origem.isEmpty()) {
			throw new Exception("Origem inválida");
		}
		if (destino == null || destino.isEmpty()) {
			throw new Exception("Destino inválido");
		}
		if (data == null || data.isEmpty()) {
			throw new Exception("Data inválida");
		}
		if (hora == null || hora.isEmpty() || hora.matches("[a-zA-Z]*")) {
			throw new Exception("Hora inválida");
		}
		if (vagas == null || vagas.matches("[a-zA-Z]*")) {
			throw new Exception("Vaga inválida");
		}

		try {
			Carona carona = new Carona(origem, destino, data, hora,
					Integer.parseInt(vagas), usuario.getLogin()
							+ usuario.getCaronas().size(), usuario.getLogin());
			this.controller.cadastraCarona(usuario, carona);
			return carona.getIdCarona();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getAtributoCarona(String idCarona, String atributo)
			throws Exception {
		if (idCarona == null || idCarona.isEmpty())
			throw new Exception("Identificador do carona é inválido");
		Carona carona = this.controller.getCaronaByID(idCarona);
			if (carona != null) {
				if(atributo == null || atributo.isEmpty()){
					throw new Exception("Atributo inválido");
				}				
				if (atributo.equals("origem")) {
					return carona.getOrigem();
				} else if (atributo.equals("destino")) {
					return carona.getDestino();
				} else if (atributo.equals("data")) {
					return carona.getData();
				} else if (atributo.equals("vagas")) {
					return ((Integer) carona.getVagas()).toString();
				} else{
					throw new Exception("Atributo inexistente");
				}
			} else {
				throw new Exception("Item inexistente");
			}
	}

	public String getCarona(String idCarona) throws Exception {
		if(idCarona == null){
			throw new Exception("Carona Inválida");
		}
		if(idCarona.isEmpty()){
			throw new Exception("Carona Inexistente");
		}
		Carona carona = this.controller.getCaronaByID(idCarona);
		if(carona == null){
			throw new Exception("Carona Inexistente");
		}
		return carona.toString();
	}

	public String getTrajeto(String idCarona) throws Exception {
		if(idCarona == null){
			throw new Exception("Trajeto Inválida");
		}
		if(idCarona.isEmpty()){
			throw new Exception("Trajeto Inexistente");
		}
		Carona carona = this.controller.getCaronaByID(idCarona);
		if (carona != null) {
			return carona.getTrajeto();
		}
		else{
			throw new Exception("Trajeto Inexistente");
		}
	}

	public void encerrarSistema() {

	}
}
