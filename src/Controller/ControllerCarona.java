package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Carona;
import Model.Usuario;

public class ControllerCarona {

	private List<Carona> caronas;

	public List<Carona> getCaronas() {
		return caronas;
	}

	public ControllerCarona() {
		this.caronas = new ArrayList<Carona>();
	}

	public void addCarona(Usuario usuario, Carona carona) {
		usuario.addCarona(carona);
		this.caronas.add(carona);
	}

	public List<Carona> search(String buscado) {
		if (buscado != null && !buscado.equals("")
				|| buscado.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%¨&*0-9].*")) {
			List<Carona> busca = new ArrayList<Carona>();
			for (Carona carona : this.caronas) {
				if (carona.getOrigem().toLowerCase().contains(buscado)) {
					busca.add(carona);
				}
			}
			return busca;
		} else {
			throw new IllegalArgumentException("Busca inválido");
		}
	}

	public Map<String, Carona> buscaCarona(String idSessao, String origem,
			String destino) {
		if (origem == null
				|| origem
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%ï¿½&*0-9].*")) {
			throw new IllegalArgumentException("Origem inválida");
		} else if (destino == null
				|| destino
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%ï¿½&*0-9].*")) {
			throw new IllegalArgumentException("Destino inválido");
		}

		Map<String, Carona> retorno = new HashMap<String, Carona>();

		for (Carona carona : this.caronas) {
			// Checa se a Origem da carona tem o parï¿½metro da busca
			if (carona.getOrigem().toLowerCase().contains(origem.toLowerCase())) {
				// Checa se o Destino da carona tem o parï¿½metro da busca
				if (carona.getDestino().toLowerCase()
						.contains(destino.toLowerCase())) {
					retorno.put(carona.getIdCarona(), carona);
				}
			}
		}
		return retorno;
	}

	public Carona getCaronaByID(String id) {
		for (Carona carona : this.caronas) {
			if (carona.getIdCarona().equals(id))
				return carona;
		}
		return null;
	}

}
