package br.com.otavio.model;

import java.time.LocalTime;

public class Piloto {

	private String nome;
	private String codigo;
	private LocalTime tempoTotalProva;
	private LocalTime melhorTempoVolta;
	private Integer numeroUltimaVolta;
	private Integer numeroDaMelhorVolta;

	public Piloto(String nome, String codigo) {

		this.nome = nome;
		this.codigo = codigo;
	}

	public Piloto() {

	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public LocalTime getMelhorTempoVolta() {
		return melhorTempoVolta;
	}

	public LocalTime getTempoTotalProva() {
		return tempoTotalProva;
	}

	public Integer getNumeroUltimaVolta() {
		return numeroUltimaVolta;
	}

	public Integer getNumeroDaMelhorVolta() {
		return numeroDaMelhorVolta;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTempoTotalProva(LocalTime tempoTotalProva) {
		this.tempoTotalProva = tempoTotalProva;
	}

	public void setMelhorTempoVolta(LocalTime melhorTempoVolta) {
		this.melhorTempoVolta = melhorTempoVolta;
	}

	public void setNumeroUltimaVolta(Integer numeroUltimaVolta) {
		this.numeroUltimaVolta = numeroUltimaVolta;
	}

	public void setNumeroDaMelhorVolta(Integer numeroDaMelhorVolta) {
		this.numeroDaMelhorVolta = numeroDaMelhorVolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((melhorTempoVolta == null) ? 0 : melhorTempoVolta.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDaMelhorVolta == null) ? 0 : numeroDaMelhorVolta.hashCode());
		result = prime * result + ((numeroUltimaVolta == null) ? 0 : numeroUltimaVolta.hashCode());
		result = prime * result + ((tempoTotalProva == null) ? 0 : tempoTotalProva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (melhorTempoVolta == null) {
			if (other.melhorTempoVolta != null)
				return false;
		} else if (!melhorTempoVolta.equals(other.melhorTempoVolta))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDaMelhorVolta == null) {
			if (other.numeroDaMelhorVolta != null)
				return false;
		} else if (!numeroDaMelhorVolta.equals(other.numeroDaMelhorVolta))
			return false;
		if (numeroUltimaVolta == null) {
			if (other.numeroUltimaVolta != null)
				return false;
		} else if (!numeroUltimaVolta.equals(other.numeroUltimaVolta))
			return false;
		if (tempoTotalProva == null) {
			if (other.tempoTotalProva != null)
				return false;
		} else if (!tempoTotalProva.equals(other.tempoTotalProva))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "Código do Piloto = " + codigo + "\n" + "Piloto " + nome + "\n" + "Número de voltas completadas= "
				+ numeroUltimaVolta + "\n";
	}

}
