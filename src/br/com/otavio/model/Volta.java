package br.com.otavio.model;

import java.time.LocalTime;

public class Volta {

	private LocalTime horaVolta;
	private Piloto piloto;
	private Integer numeroVolta;
	private LocalTime tempoVolta;
	private Double velocidadeMedia;

	public Volta(LocalTime horaVolta, Piloto piloto, Integer numeroVolta, LocalTime tempoVolta,
			Double velocidadeMedia) {
		this.horaVolta = horaVolta;
		this.piloto = piloto;
		this.numeroVolta = numeroVolta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMedia = velocidadeMedia;
	}

	public LocalTime getHoraVolta() {
		return horaVolta;
	}

	public void setHoraVolta(LocalTime horaVolta) {
		this.horaVolta = horaVolta;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Integer getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(Integer numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(LocalTime tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

}
