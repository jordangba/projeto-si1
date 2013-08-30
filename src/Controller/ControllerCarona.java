package Controller;

import java.util.ArrayList;
import java.util.List;

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

}
