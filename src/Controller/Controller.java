package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Exception.CadastroException;
import Exception.LoginException;
import Model.Carona;
import Model.SolicitacaoDeVaga;
import Model.Usuario;

public class Controller {

	private ControllerUsuario controllerUsuario;
	private ControllerCarona controllerCarona;
	private boolean logged = false;

	public Controller() {
		this.controllerUsuario = new ControllerUsuario();
		this.controllerCarona = new ControllerCarona();
	}

	public String getNameUserLogged() {
		if (logged) {
			return controllerUsuario.getNameUserLogged();
		}
		return "";
	}

	public String getAddressUserLogged() {
		if (logged)
			return controllerUsuario.getAddressUserLogged();
		return "";
	}

	public Usuario login(String login, String password) throws LoginException {
		Usuario user = this.controllerUsuario.login(login, password);
		logged = true;
		controllerUsuario.setNameLogged(login);
		return user;
	}

	public void cadastraUsuario(Usuario usuario) throws CadastroException {
		this.controllerUsuario.cadastraUsuario(usuario);
	}

	public String cadastraCarona(Usuario usuario, Carona carona) {
		this.controllerCarona.addCarona(usuario, carona);
		return carona.getIdCarona();
	}

	public Usuario buscaUsuario(String login) {
		return this.controllerUsuario.buscaUsuario(login);
	}

	public List<Carona> buscaCarona(String origem, String destino) {
		if (origem == null
				|| origem
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%ï¿½&*0-9].*")
				|| origem.trim().equals("")) {
			throw new IllegalArgumentException("Origem inválida");
		} else if (destino == null
				|| destino
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%ï¿½&*0-9].*")
				|| destino.trim().equals("")) {
			throw new IllegalArgumentException("Destino inválido");
		}
		List<Carona> retorno = new ArrayList<Carona>();
		for (Carona carona : this.controllerCarona.getCaronas()) {
			// Checa se a Origem da carona tem o parï¿½metro da busca
			if (carona.getOrigem().toLowerCase().contains(origem.toLowerCase())) {
				// Checa se o Destino da carona tem o parï¿½metro da busca
				if (carona.getDestino().toLowerCase()
						.contains(destino.toLowerCase())) {
					retorno.add(carona);
				}
			}
		}
		return retorno;
	}

	public Map<String, Carona> buscaCarona(String idSessao, String origem,
			String destino) {
		return this.controllerCarona.buscaCarona(idSessao, origem, destino);
	}

	public List<Carona> getCaronas() {
		return this.controllerCarona.getCaronas();
	}

	public String addSolicitacao(SolicitacaoDeVaga solicitacao) {
		String nome = solicitacao.getCarona().getMotorista();
		Usuario user = controllerUsuario.getUsuarios().get(nome);

		user.addSolicitacao(solicitacao);
		return "";
	}
	
	public Usuario getLoggedUser(){
		return this.controllerUsuario.getLoggedUser();
	}

	public Carona getCaronaByID(String id){
		return this.controllerCarona.getCaronaByID(id);
	}
	
}