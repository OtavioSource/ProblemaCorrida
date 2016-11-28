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

	public Piloto getPiloto() {
		return piloto;
	}

	public Integer getNumeroVolta() {
		return numeroVolta;
	}

	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

}
