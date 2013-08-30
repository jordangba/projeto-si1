package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login, senha, nome, endereco, email;
	private List<Carona> caronasUser;
	private List<SolicitacaoDeVaga> solicitacoes;

	public Usuario() {
		this.login = "";
		this.senha = "";
		this.nome = "";
		this.email = "";
		this.endereco = "";
		caronasUser = new ArrayList<Carona>();
		this.solicitacoes = new ArrayList<SolicitacaoDeVaga>();
	}

	public List<SolicitacaoDeVaga> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoDeVaga> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public void addSolicitacao(SolicitacaoDeVaga solicitacao) {
		if (this.login.equals(solicitacao.getDonoSolicitacao().getLogin())) {
			throw new IllegalArgumentException("Solicita��o inv�lida");
		}

		if (caronasUser.contains(solicitacao.getCarona())
				&& !solicitacoes.contains(solicitacao)) {
			this.solicitacoes.add(solicitacao);
			
		} else {
			throw new IllegalArgumentException("Solicita��o inv�lida");
		}
	}
	
	public void confirmaSolicitacao(SolicitacaoDeVaga solicitacao){
		if(solicitacao.getCarona().getVagas() > 0){
			solicitacao.getCarona().subtrairVagas();
			solicitacao.setAceitacao(true);
		}
	}
	public void recusarSolicitacao(SolicitacaoDeVaga solicitacao){
			solicitacao.setAceitacao(false);
			solicitacoes.remove(solicitacao);
	}

	public List<Carona> getCaronasUser() {
		return caronasUser;
	}

	public void setCaronasUser(List<Carona> caronasUser) {
		this.caronasUser = caronasUser;
	}

	private void verificaLogin(String login) {
		if (login == null || login.equals("")) {
			throw new IllegalArgumentException("Login inv�lido");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		verificaLogin(login);
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		verificaSenha(senha);
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNome(nome);
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificaEmail(email);
		this.email = email;
	}

	private void verificaSenha(String senha) {
		if (senha == null || senha.isEmpty()) {
			throw new IllegalArgumentException("Senha inv�lida");
		}
	}

	private void verificaNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome inv�lido");
		}
	}

	private void verificaEmail(String email) {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Email inv�lido");
		}
	}

	public void addCarona(Carona carona) {
		caronasUser.add(carona);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			if (this.login.equals(((Usuario) obj).getLogin())
					&& this.email.equals(((Usuario) obj).getEmail())) {
				return true;
			}
			if (this.login.equals(((Usuario) obj).getLogin())) {
				return true;
			}
			if (this.email.equals(((Usuario) obj).getEmail())) {
				return true;
			}
		}
		return false;
	}
}
