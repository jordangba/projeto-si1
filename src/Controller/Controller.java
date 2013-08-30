package Controller;

import java.util.ArrayList;
import java.util.List;

import Exception.CadastroException;
import Exception.LoginException;
import Model.Carona;
import Model.SolicitacaoDeVaga;
import Model.Usuario;

public class Controller {

	private ControllerUsuario controllerUsuario;
	private ControllerCarona controllerCarona;

	public Controller() {
		this.controllerUsuario = new ControllerUsuario();
		this.controllerCarona = new ControllerCarona();
	}

	boolean logged = false;

	public String getNameUserLogged() {
	if(logged)
	return controllerUsuario.getNameUserLogged();
	return "";
	}

	public String getAddressUserLogged() {
	if(logged)
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

	public List<Carona> buscaCarona(String origem, String destino) {
		if (origem == null
				|| destino == null
				|| (origem.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%�&*0-9].*"))
				|| (origem.trim().equals(""))
				|| (destino
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%�&*0-9].*"))
				|| (destino.trim().equals(""))) {
			
			throw new IllegalArgumentException("Caracteres inv�lidos");
		}
		List<Carona> retorno = new ArrayList<Carona>();
		for (Carona carona : this.controllerCarona.getCaronas()) {
			// Checa se a Origem da carona tem o par�metro da busca
			if (carona.getOrigem().toLowerCase().contains(origem.toLowerCase())) {
				// Checa se o Destino da carona tem o par�metro da busca
				if (carona.getDestino().toLowerCase()
						.contains(destino.toLowerCase())) {
					retorno.add(carona);
				}
			}
		}
		return retorno;
	}
	
	public List<Carona> getCarona(){
		return this.controllerCarona.getCaronas();
	}

	public String addSolicitacao(SolicitacaoDeVaga solicitacao) {
		String nome = solicitacao.getCarona().getMotorista();
		Usuario user = controllerUsuario.getUsuarios().get(nome);
		
		user.addSolicitacao(solicitacao);
		return "";
		
	}
}