package Model;

import java.util.List;

public class SolicitacaoDeVaga {

	private Carona carona;
	private Usuario donoSolicitacao;
	private String idSolicitacao;
	private String pontos;
	private boolean aceitacao;


	public SolicitacaoDeVaga(Carona carona, String pontos,
			String idSolicitacao, Usuario donoSolicitacao) {
		this.carona = carona;
		this.pontos = pontos;
		this.idSolicitacao = idSolicitacao;
		this.donoSolicitacao = donoSolicitacao;
		this.aceitacao = false;
	}

	public boolean getAceitacao() {
		return aceitacao;
	}
	
	public void setAceitacao(boolean aceitacao) {
		this.aceitacao = aceitacao;
	}
	
	public Usuario getDonoSolicitacao() {
		return donoSolicitacao;
	}

	public String getOrigem() {
		return this.carona.getOrigem();
	}

	public String getDestino() {
		return this.carona.getDestino();
	}

	public String getMotorista() {
		return this.carona.getMotorista();
	}

	public String getPontos() {
		return this.pontos;
	}

	/**public void addPonto(String novoPonto) {
		this.pontos.add(novoPonto);
	}**/

	public String getIdSolicitacao() {
		return this.idSolicitacao;
	}

	public Carona getCarona() {
		return this.carona;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SolicitacaoDeVaga)) {
			return false;
		}
		if (!(((SolicitacaoDeVaga) obj).getIdSolicitacao()
				.equals(this.idSolicitacao))) {
			return false;
		}
		return true;
	}

}
