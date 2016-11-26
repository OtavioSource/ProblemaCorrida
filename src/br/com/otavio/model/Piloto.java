package br.com.otavio.model;

import java.time.LocalTime;

public class Piloto {
	
	private String nome;
	private String codigo;
	private LocalTime tempoTotalProva;
	private LocalTime melhorTempoVolta;
	private Integer posicaoFinalCorrida;
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalTime getMelhorTempoVolta() {
		return melhorTempoVolta;
	}

	public void setMelhorTempoVolta(LocalTime melhorTempoVolta) {
		this.melhorTempoVolta = melhorTempoVolta;
	}

	public Integer getPosicaoFinalCorrida() {
		return posicaoFinalCorrida;
	}

	public void setPosicaoFinalCorrida(Integer posicaoFinalCorrida) {
		this.posicaoFinalCorrida = posicaoFinalCorrida;
	}

	public LocalTime getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(LocalTime tempoTotalProvaMiliSegundos) {
		this.tempoTotalProva = tempoTotalProvaMiliSegundos;
	}

	public Integer getNumeroUltimaVolta() {
		return numeroUltimaVolta;
	}

	public void setNumeroUltimaVolta(Integer numeroUltimaVolta) {
		this.numeroUltimaVolta = numeroUltimaVolta;
	}
	

	public Integer getNumeroDaMelhorVolta() {
		return numeroDaMelhorVolta;
	}

	public void setNumeroDaMelhorVolta(Integer numeroDaMelhorVolta) {
		this.numeroDaMelhorVolta = numeroDaMelhorVolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());

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
		return true;
	}

	@Override
	public String toString() {
		
		return "Código do Piloto = " + codigo + "\n" + 
			   "Piloto " + nome + "\n" + 
			   "Número de voltas completadas= " + numeroUltimaVolta + "\n";			   
	}



	

	

}
