package br.com.otavio.util;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;

public class PrintRespostas {
	
	private InfoCorrida infos = new InfoCorrida();
	private CarregaInformacaoArquivo util = new CarregaInformacaoArquivo();
	
	
	public void imprimeVelocidadeMediaDeCadaPiloto(){
		
		DecimalFormat df = new DecimalFormat("#.####");
		
		Map<String, List<Volta>> agrupamentoPorCodigoDoPiloto = infos.retornaMapDeVoltas();
		
		agrupamentoPorCodigoDoPiloto.forEach((k,v) ->{
			
			 Double velocidadeMediaPorPiloto = v.stream().mapToDouble(Volta::getVelocidadeMedia).average().getAsDouble();
			    System.out.println(k + " : " + v.get(0).getPiloto().getNome() + " fez uma velocidade média de " + df.format(velocidadeMediaPorPiloto));
			    
		});
		
	}
	
	public void imprimirMelhorVoltaDeCadaPiloto() throws IOException{
		
		List<Piloto> listaPiloto = infos.retornaListaDePiloto();
		listaPiloto.forEach(p -> System.out.println("Piloto " + p.getNome() + " fez sua melhor volta em " + p.getMelhorTempoVolta() + "  na "+ p.getNumeroDaMelhorVolta()+"º volta"));
						
	
	}
	
	
	public void imprimeMelhorVoltaDaCorrida() throws IOException{
		
		List<Volta> voltas = util.infoVoltas();
		voltas.sort((v1,v2) -> v1.getTempoVolta().compareTo(v2.getTempoVolta()));
		System.out.println("Piloto "+voltas.get(0).getPiloto().getNome()+" fez a melhor volta da corrida, fazendo em "+ voltas.get(0).getTempoVolta()+" na "+ voltas.get(0).getNumeroVolta()+"º volta!!!" );
		
		
	}
	
	public void imprimeTempoDeChegadaDepoisDoVencedor() throws IOException {

		List<Piloto> listaPilotos = infos.retornaListaDePiloto();
		
		System.out.println("Tempo de chegada dos pilotos após a chegada do vencedor!!!");
		IntStream.range(0, listaPilotos.size())
		.forEach(index -> 
		{
		LocalTime tempoDeChegadaDepoisDoVencedor = listaPilotos.get(index).getTempoTotalProva().minus(listaPilotos.get(0).getTempoTotalProva().toNanoOfDay(), ChronoUnit.NANOS) ;	
		String chegadaDepoisDoVencedor = "";
		
		if(tempoDeChegadaDepoisDoVencedor.isAfter(listaPilotos.get(0).getTempoTotalProva()) && listaPilotos.get(index).getNumeroUltimaVolta() < 4){
			chegadaDepoisDoVencedor = "não completou a corrida.";
		}
		else if(tempoDeChegadaDepoisDoVencedor.equals(LocalTime.MIDNIGHT) && listaPilotos.get(index).getNumeroUltimaVolta() == 4){
			chegadaDepoisDoVencedor = "foi o campeão da prova!!!";
		}
		else{
			chegadaDepoisDoVencedor = "chegou "+tempoDeChegadaDepoisDoVencedor + " de diferença!!!";
		}
		
		System.out.println("Piloto " + listaPilotos.get(index).getNome()+ " " + chegadaDepoisDoVencedor);
		});
		
	}
	
	public void imprimeRankingFinalDaCorrida() throws IOException {
		
		List<Piloto> listaPilotos = infos.retornaListaDePiloto();

		IntStream.range(0, listaPilotos.size())
		.forEach(posicao -> System.out.println("Posição: " + (posicao+1)+"º lugar" + "\n" + listaPilotos.get(posicao)+"\n"));
		
	}

}
