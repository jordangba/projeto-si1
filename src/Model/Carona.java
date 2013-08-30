package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;

public class Carona {

	private String origem, destino, idCarona, data, hora, horaDoSistema,
			dataDoSistema, motorista;
	private int vagas;

	private HashSet<Usuario> caroneiros;

	public Carona(String origem, String destino, String data, String hora,
			int vagas, String idCarona, String motorista) {
		setHoraDoSistema(new SimpleDateFormat("HH:mm").format(Calendar
				.getInstance().getTime()));
		setDataDoSistema(new SimpleDateFormat("dd/MM/yyyy").format(Calendar
				.getInstance().getTime()));
		checaHoraEData(data, hora);
		setOrigem(origem);
		setDestino(destino);
		setData(data);
		setHora(hora);
		setVagas(vagas);
		this.idCarona = idCarona;
		setMotorista(motorista);
		this.setCaroneiros(new HashSet<Usuario>());
	}

	private void checaHoraEData(String data, String hora) {
		if (this.dataDoSistema.toString().compareTo(data.toString()) == 0) {
			if (this.horaDoSistema.toString().compareTo(hora.toString()) > 0) {
				throw new IllegalArgumentException("Hora inv�lida");
			}
		}
	}

	public String getDataDoSistema() {
		return dataDoSistema;
	}

	private Calendar calendar;

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}

	public String getData() {
		return data;
	}

	public void setDataDoSistema(String dataDoSistema) {
		this.dataDoSistema = dataDoSistema;
	}

	public void setData(String data) {
		checaData(data);
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		checaHoraInvalida(hora);
		this.hora = hora;
	}

	public void setOrigem(String origem) {
		if ((origem == null)
				|| (origem.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%�&*0-9].*"))
				|| (origem.trim().equals(""))) {
			throw new IllegalArgumentException("Origem inv�lida");
		}
		this.origem = origem.trim();
	}

	public String getOrigem() {
		return this.origem;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		if ((destino == null)
				|| (destino
						.matches("[\\-/.\\[_\\]()!\"+,:;<=>{|}#@$%�&*0-9].*"))
				|| (destino.trim().equals(""))) {
			throw new IllegalArgumentException("Destino inv�lido");
		}
		this.destino = destino.trim();
	}

	public void setCalendario(Calendar calendar) {
		this.calendar = calendar;
	}

	public Calendar getCalendario() {
		return this.calendar;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		if (vagas < 1) {
			throw new IllegalArgumentException("Vaga inv�lida");
		}
		this.vagas = vagas;
	}
	
	public void subtrairVagas(){
		if (vagas < 1) {
			throw new IllegalArgumentException("Vaga inv�lida");
		}
		this.vagas--;
	}

	public String getIdCarona() {
		return this.idCarona;
	}

	private void checaData(String stringData) {

		if (stringData == null || stringData.isEmpty()) {
			throw new IllegalArgumentException("Data inv�lida");
		}

		Calendar data = Calendar.getInstance();
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			data.setTime(formato.parse(stringData));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Data inv�lida");
		}

		Calendar dataAtual = Calendar.getInstance();
		data.add(Calendar.HOUR_OF_DAY, 24);
		data.add(Calendar.MINUTE, 59);
		if (dataAtual.getTime().compareTo(data.getTime()) == 1) { // -1 data
																	// valida, 1
																	// data
																	// invalida
			throw new IllegalArgumentException("Data inv�lida");
		}
	}

	private void checaHoraInvalida(String hora) {
		if (hora == null || hora.isEmpty() || hora.matches("[a-zA-Z]*")) {
			throw new IllegalArgumentException("Hora inv�lida");
		}
		String[] listaHoraMinuto = hora.split(":");
		try {
			int horas = Integer.parseInt(listaHoraMinuto[0]);
			int minutos = Integer.parseInt(listaHoraMinuto[1]);
			if ((horas >= 24) || (minutos >= 60)) {
				throw new IllegalArgumentException("Hora inv�lida");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Hora inv�lida");
		}
	}

	public String getHoraDoSistema() {
		return horaDoSistema;
	}

	public void setHoraDoSistema(String horaDoSistema) {
		this.horaDoSistema = horaDoSistema;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public HashSet<Usuario> getCaroneiros() {
		return caroneiros;
	}

	public void setCaroneiros(HashSet<Usuario> caroneiros) {
		this.caroneiros = caroneiros;
	}

}
