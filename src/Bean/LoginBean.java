package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Controller.Controller;
import Exception.CadastroException;
import Exception.LoginException;
import Model.Carona;
import Model.SolicitacaoDeVaga;
import Model.Usuario;

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	private String nome;
	private String loginCadastro;
	private String senhaCadastro;
	private String endereco;
	private String email;
	private Usuario usuario;
	private Controller controller;
	private List<Carona> caronas;
	private String origem;
	private String destino;
	private int vagas;
	private String data;
	private String hora;
	private String buscaOrigem;
	private String buscaDestino;
	private List<Carona> buscaDeCaronas;
	private Carona carona;
	private List<SolicitacaoDeVaga> solicitacoes;
	private String sugestaoLocal;
	private SolicitacaoDeVaga solicitacao;

	public SolicitacaoDeVaga getSolicitacao() {

		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDeVaga solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getSugestaoLocal() {
		return sugestaoLocal;
	}

	public void setSugestaoLocal(String sugestaoLocal) {
		this.sugestaoLocal = sugestaoLocal;
	}

	public List<SolicitacaoDeVaga> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoDeVaga> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public String getBuscaDestino() {
		return buscaDestino;
	}

	public void setBuscaDestino(String buscaDestino) {
		this.buscaDestino = buscaDestino;
	}

	public String getBuscaOrigem() {
		return buscaOrigem;
	}

	public void setBuscaOrigem(String buscaOrigem) {
		this.buscaOrigem = buscaOrigem;
	}

	public LoginBean() {
		this.controller = new Controller();
		this.login = "";
		this.password = "";
		this.nome = "";
		this.loginCadastro = "";
		this.senhaCadastro = "";
		this.endereco = "";
		this.email = "";
		this.data = "";
		this.origem = "";
		this.destino = "";
		this.hora = "";
		// this.vagas = "";
		this.usuario = null;
		this.caronas = new ArrayList<Carona>();
		this.buscaOrigem = "";
		this.buscaDestino = "";
		// this.buscaDeCaronas = new ArrayList<Carona>();

		Usuario usuario1 = new Usuario();
		usuario1.setNome("usuario1");
		usuario1.setEmail("usuario1@email.com");
		usuario1.setEndereco("usuario1");
		usuario1.setLogin("usuario1");
		usuario1.setSenha("usuario1");
		Carona carona1 = new Carona("A", "B", "24/08/2014", "22:22", 22,
				"asdasdadadasdadvlsdldvlsdvsld", "usuario1");
		Carona carona2 = new Carona("C", "D", "25/08/2014", "22:22", 22,
				"dvlsdvsld", "usuario1");

		Usuario usuario2 = new Usuario();
		usuario2.setNome("a");
		usuario2.setEmail("a@gmail.com");
		usuario2.setEndereco("a");
		usuario2.setLogin("a");
		usuario2.setSenha("123456");
		try {
			this.controller.cadastraUsuario(usuario1);
			this.controller.cadastraUsuario(usuario2);
			this.controller.cadastraCarona(usuario1, carona1);
			this.controller.cadastraCarona(usuario1, carona2);
		} catch (CadastroException e) {
		}

	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<Carona> getCaronas() {
		return caronas;
	}

	public void setCaronas(List<Carona> caronas) {
		this.caronas = caronas;
	}

	public String logar() {
		try {
			usuario = this.controller.login(login, password);
			caronas = usuario.getCaronas();
			solicitacoes = usuario.getSolicitacoes();
			limpa();
			return "telaInicial.xhtml";
		} catch (LoginException e) {
			msgUsuario("Login Não realizado", e.getMessage());
			return "";
		}

	}

	public String cadastra() {
		Usuario newUsuario = new Usuario();
		newUsuario.setEmail(email);
		newUsuario.setEndereco(endereco);
		newUsuario.setLogin(loginCadastro);
		newUsuario.setNome(nome);
		newUsuario.setSenha(senhaCadastro);
		try {
			this.controller.cadastraUsuario(newUsuario);
			this.usuario = newUsuario;
			limpa();
			return "telaInicial.seam";
		} catch (CadastroException e) {
			msgUsuario("Cadastro invalido", e.getMessage());
			return "";
		} catch (IllegalArgumentException e) {
			msgUsuario("Usuario invalido", e.getMessage());
			return "";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLoginCadastro() {
		return loginCadastro;
	}

	public void setLoginCadastro(String loginCadastro) {
		this.loginCadastro = loginCadastro;
	}

	public String getSenhaCadastro() {
		return senhaCadastro;
	}

	public void setSenhaCadastro(String senhaCadastro) {
		this.senhaCadastro = senhaCadastro;
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
		this.email = email;
	}

	private void msgUsuario(String string1, String string2) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(string1, string2));
	}

	public void limpa() {
		this.login = "";
		this.password = "";
		this.nome = "";
		this.loginCadastro = "";
		this.senhaCadastro = "";
		this.endereco = "";
		this.email = "";
		this.data = "";
		this.origem = "";
		this.destino = "";
		this.hora = "";
		this.sugestaoLocal = "";
	}

	public String logout() {
		usuario = null;
		caronas = null;
		solicitacoes = null;
		return "Login.xhtml";
	}

	public String cadastraCarona() {
		try {
			Carona carona = new Carona(origem, destino, data, hora, vagas,
					usuario.getNome() + usuario.getCaronas().size(),
					usuario.getLogin());
			this.controller.cadastraCarona(this.usuario, carona);
			msgUsuario("Carona Cadastrada", "");
			return cancela();
		} catch (IllegalArgumentException e) {
			msgUsuario("Carona nï¿½o cadastrada", e.getMessage());
		}
		return "";
	}

	public String cancela() {
		limpa();
		return "telaInicial.xhtml";
	}

	public String novaCaronaButton() {
		return "cadastroCarona.xhtml";
	}

	public String searchButton() {
		this.buscaDeCaronas = new ArrayList<Carona>();
		return "buscaCarona.xhtml";
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public List<Carona> getBuscaDeCaronas() {
		return buscaDeCaronas;
	}

	public void setBuscaDeCaronas(List<Carona> buscaDeCaronas) {
		this.buscaDeCaronas = buscaDeCaronas;
	}

	public void buscarButton() {
		try {
			this.buscaDeCaronas = this.controller.buscaCarona(this.buscaOrigem,
					this.buscaDestino);
		} catch (IllegalArgumentException e) {
			msgUsuario("Busca nï¿½o realizada", e.getMessage());
			this.buscaDeCaronas = new ArrayList<Carona>();
			this.buscaOrigem = "";
			this.buscaDestino = "";
			return;
		}
		this.buscaOrigem = "";
		this.buscaDestino = "";
	}

	public String backButton() {
		return "telaInicial.xhtml";
	}

	public Carona getCarona() {
		return carona;
	}

	public void setCarona(Carona carona) {
		this.carona = carona;
	}

	public String addSolicitacao() {
		try {
			System.out.println("AAAAAA");
			SolicitacaoDeVaga solicitacao = new SolicitacaoDeVaga(carona,
					sugestaoLocal, carona.getMotorista() + carona.getData()
							+ carona.getHora(), usuario);
			System.out.println("BBBBBBBBBBBB");
			controller.addSolicitacao(solicitacao);
			System.out.println("CCCCCCCCCCCCCC");
			sugestaoLocal = "";
		} catch (Exception e) {
			System.out.println("DDDDDDDDDDDDDDDDDDD");
			msgUsuario("Solicitacao ja existe ", e.getMessage());
			sugestaoLocal = "";
		}
		System.out.println("EEEEEEEEEEEEEee");
		return "buscaCarona.xhtml";

	}

	public void aceitar() {
		System.out.println(solicitacao);
		usuario.confirmaSolicitacao(solicitacao);
	}

	public void recusar(){
		System.out.println(solicitacao);
		usuario.recusarSolicitacao(solicitacao);
	}
}
