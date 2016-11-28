package br.com.otavio.util;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;

public class Resultados {

	private InformacoesCorrida informacoesCorrida = new InformacoesCorrida(
			new Voltas("corrida.log", new LeitorArquivo()));

	public void imprimeVelocidadeMediaDeCadaPiloto() {

		DecimalFormat df = new DecimalFormat("#.####");

		informacoesCorrida.informacoesVoltaPorPiloto().forEach((k, v) -> {

			Double velocidadeMediaPorPiloto = v.stream().mapToDouble(Volta::getVelocidadeMedia).average().getAsDouble();
			System.out.println(k + " : " + v.get(0).getPiloto().getNome() + " fez uma velocidade média de "
					+ df.format(velocidadeMediaPorPiloto));

		});
		System.out.println("\n");

	}

	public void imprimeMelhorVoltaDeCadaPiloto() {

		List<Piloto> listaPiloto = informacoesCorrida.pilotosOrdenadosPorPosicaoDeChegada();
		listaPiloto.forEach(p -> System.out.println("Piloto " + p.getNome() + " fez sua melhor volta em "
				+ p.getMelhorTempoVolta() + "  na " + p.getNumeroDaMelhorVolta() + "º volta"));
		System.out.println("\n");

	}

	public void imprimeMelhorVoltaDaCorrida() {

		List<Volta> voltas = informacoesCorrida.voltasOrdenadasPorMenorTempo();
		System.out
				.println("Piloto " + voltas.get(0).getPiloto().getNome() + " fez a melhor volta da corrida, fazendo em "
						+ voltas.get(0).getTempoVolta() + " na " + voltas.get(0).getNumeroVolta() + "º volta!!!");
		System.out.println("\n");

	}

	public void imprimeTempoDeChegadaDepoisDoVencedor() {

		List<Piloto> listaPilotos = informacoesCorrida.pilotosOrdenadosPorPosicaoDeChegada();

		System.out.println("Tempo de chegada dos pilotos após a chegada do vencedor!!!");
		IntStream.range(0, listaPilotos.size()).forEach(index -> {
			LocalTime tempoDeChegadaDepoisDoVencedor = listaPilotos.get(index).getTempoTotalProva()
					.minus(listaPilotos.get(0).getTempoTotalProva().toNanoOfDay(), ChronoUnit.NANOS);
			String chegadaDepoisDoVencedor = "";

			if (tempoDeChegadaDepoisDoVencedor.isAfter(listaPilotos.get(0).getTempoTotalProva())
					&& listaPilotos.get(index).getNumeroUltimaVolta() < 4) {
				chegadaDepoisDoVencedor = "não completou a corrida.";
			} else if (tempoDeChegadaDepoisDoVencedor.equals(LocalTime.MIDNIGHT)
					&& listaPilotos.get(index).getNumeroUltimaVolta() == 4) {
				chegadaDepoisDoVencedor = "foi o campeão da prova!!!";
			} else {
				chegadaDepoisDoVencedor = "chegou " + tempoDeChegadaDepoisDoVencedor + " de diferença!!!";
			}

			System.out.println("Piloto " + listaPilotos.get(index).getNome() + " " + chegadaDepoisDoVencedor);
		});
		System.out.println("\n");

	}

	public void imprimeRankingFinalDaCorrida() {

		List<Piloto> listaPilotos = informacoesCorrida.pilotosOrdenadosPorPosicaoDeChegada();

		IntStream.range(0, listaPilotos.size()).forEach(posicao -> System.out
				.println("Posição: " + (posicao + 1) + "º lugar" + "\n" + listaPilotos.get(posicao) + "\n"));
		System.out.println("\n");
	}

}
