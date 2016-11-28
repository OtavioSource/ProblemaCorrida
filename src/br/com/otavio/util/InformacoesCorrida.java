package br.com.otavio.util;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;

public class InformacoesCorrida {

	private Voltas informacoesVoltas;

	public InformacoesCorrida(Voltas informacaoVolta) {
		this.informacoesVoltas = informacaoVolta;
	}

	public Map<String, List<Volta>> informacoesVoltaPorPiloto() {

		List<Volta> voltas = informacoesVoltas.getVoltas();
		Map<String, List<Volta>> agrupamentoDeVoltasPorCodigoDoPiloto = voltas.stream()
				.collect(Collectors.groupingBy(v -> v.getPiloto().getCodigo()));

		return agrupamentoDeVoltasPorCodigoDoPiloto;

	}

	public List<Piloto> pilotosOrdenadosPorPosicaoDeChegada() {

		List<Piloto> listaPilotosComInfoDeCadaVolta = new ArrayList<>();

		Map<String, List<Volta>> agrupamentoPorCodigoDoPiloto = informacoesVoltaPorPiloto();

		agrupamentoPorCodigoDoPiloto.forEach((k, v) -> {

			Piloto piloto = new Piloto();
			piloto.setNome(v.get(0).getPiloto().getNome());
			piloto.setCodigo(k);
			piloto.setNumeroUltimaVolta(v.size());
			piloto.setTempoTotalProva(
					v.get(v.size() - 1).getHoraVolta().minus(v.get(0).getHoraVolta().toNanoOfDay(), ChronoUnit.NANOS));
			
			v.sort((v1, v2) -> v1.getTempoVolta().compareTo(v2.getTempoVolta()));
			
			piloto.setMelhorTempoVolta(v.get(0).getTempoVolta());
			piloto.setNumeroDaMelhorVolta(v.get(0).getNumeroVolta());
			listaPilotosComInfoDeCadaVolta.add(piloto);

		});

		return ordenaListaPilotos(listaPilotosComInfoDeCadaVolta);
	}

	private List<Piloto> ordenaListaPilotos(List<Piloto> listaPilotos) {
		
		

		Comparator<Piloto> comparatorNumeroVolta = (p1, p2) -> p1.getNumeroUltimaVolta()
				.compareTo(p2.getNumeroUltimaVolta());
		Comparator<Piloto> comparatorTempoProva = (p1, p2) -> p1.getTempoTotalProva()
				.compareTo(p2.getTempoTotalProva());

		listaPilotos.sort(comparatorTempoProva);
		listaPilotos.sort(comparatorNumeroVolta.reversed());

		return listaPilotos;
	}

	public List<Volta> voltasOrdenadasPorMenorTempo() {

		List<Volta> voltas = informacoesVoltas.getVoltas();
		voltas.sort((v1, v2) -> v1.getTempoVolta().compareTo(v2.getTempoVolta()));

		return voltas;
	}

}
