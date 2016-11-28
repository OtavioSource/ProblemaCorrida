package br.com.otavio.util;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;

public class InformacoesVoltas {

	private String nomeDoArquivo = "corrida.log";
	private CarregaArquivo arquivo = new CarregaArquivo();

	public InformacoesVoltas(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public InformacoesVoltas() {

	}

	public List<Volta> infoVoltas() {
		
		Stream<String> linhas = arquivo.carregaArquivoLog(nomeDoArquivo);
		
		  return linhas.map(linha -> {
		   String[] infoVoltas = linha.split("\\s+");
		   
		   Volta volta = new Volta(LocalTime.parse(infoVoltas[0]), new Piloto(infoVoltas[3], infoVoltas[1]),
					Integer.valueOf(infoVoltas[4]), LocalTime.parse("00:0" + infoVoltas[5]),
					Double.parseDouble(infoVoltas[6].replace(",", ".")));
		   
		 		      
		   return volta;
		  }).collect(Collectors.toList());

	}
	
	

}
