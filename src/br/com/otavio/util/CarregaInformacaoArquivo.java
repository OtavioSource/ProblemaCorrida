package br.com.otavio.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;

public class CarregaInformacaoArquivo {
	
	public Stream<String> carregaArquivoLog() throws IOException{
		
		Path caminho = Paths.get("corrida.log");
		Stream<String> linhas = Files.lines(caminho).skip(1);
		
		return linhas;
	}
	
	public List<Volta> infoVoltas() throws IOException{
		
		List<Volta> voltas = new ArrayList<>(); 
		Stream<String> linhas = carregaArquivoLog();
		linhas.forEach(linha ->{
			
			String[] infoVoltas = linha.split("\\s+");
			
			Volta volta = new Volta();
			volta.setHoraVolta(LocalTime.parse(infoVoltas[0]));
			volta.setNumeroVolta(Integer.valueOf(infoVoltas[4]));
			volta.setPiloto(new Piloto(infoVoltas[3], infoVoltas[1]));
			volta.setTempoVolta(LocalTime.parse("00:0"+infoVoltas[5]));
			volta.setVelocidadeMedia(Double.parseDouble(infoVoltas[6].replace(",", ".")));
			
			voltas.add(volta);
			
		});
		
		
		return voltas;	
		
	}
	
}
