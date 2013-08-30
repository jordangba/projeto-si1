package AcceptTest.Simulator;

import Controller.Controller;
import Exception.CadastroException;
import Exception.LoginException;
import Model.Usuario;

public class CreateAcountSimulator {
	Controller controller;
	
	public void zerarSistema() {
		controller = new Controller();
	}
	
	public void criarUsuario(String login, String senha, String nome, String endereco, String email){
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		
		try {
			controller.cadastraUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int abrirSessao(String login, String senha){
		int retorno = 0;
		
		try {
			//retorno = controller.login(login, senha);
			controller.login(login, senha);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String getAtributoUsuario(String login, String atributo){
		String retorno = "";
		
		if(atributo.equals("nome")){
			retorno = controller.getNameUserLogged();
		}else if(atributo.equals("endereco")){
			retorno = controller.getAddressUserLogged();			
		}
		
		return retorno;
	}
	
	public void encerrarSistema() {
		
	}
}
