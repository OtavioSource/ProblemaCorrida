package br.com.otavio.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;
import br.com.otavio.util.InformacoesCorrida;
import br.com.otavio.util.LeitorArquivo;
import br.com.otavio.util.Voltas;

public class ResultadoTeste {

	private InformacoesCorrida informacoesCorrida = new InformacoesCorrida(
			new Voltas("corrida.log", new LeitorArquivo()));
	private List<Volta> voltasOrdenadasPorMenorTempo = informacoesCorrida.voltasOrdenadasPorMenorTempo();
	private List<Piloto> pilotosOrdenadosPorColocacao = informacoesCorrida.pilotosOrdenadosPorPosicaoDeChegada();

	private String nomePiloto;

	@Test
	public void deveRetornarPrimeiroColocado() {

		assertEquals("F.MASSA", pilotosOrdenadosPorColocacao.get(0).getNome());
	}

	@Test
	public void deveRetornarNumeroDePilotosDaCorrida() {

		assertEquals(6, pilotosOrdenadosPorColocacao.size());
	}

	@Test
	public void deveRetornarPilotoComMelhorTempoNaCorrida() {

		assertEquals("F.MASSA", voltasOrdenadasPorMenorTempo.get(0).getPiloto().getNome());
	}

	@Test
	public void deveRetornarPilotoComPiorTempoNaCorrida() {

		assertEquals("S.VETTEL",
				voltasOrdenadasPorMenorTempo.get(voltasOrdenadasPorMenorTempo.size() - 1).getPiloto().getNome());
	}

	@Test
	public void deveRetornarPilotoQueNaoCompletouACorrida() {

		pilotosOrdenadosPorColocacao.forEach(p -> {
			if (p.getNumeroUltimaVolta() < 4)
				nomePiloto = p.getNome();
		});

		assertEquals("S.VETTEL", nomePiloto);
	}

	@Test
	public void deveRetornarMelhorVoltaDoBarrichello() {

		pilotosOrdenadosPorColocacao.forEach(p -> {
			if (p.getNome().equals("R.BARRICHELLO"))
				assertEquals(LocalTime.parse("00:01:03.716"), p.getMelhorTempoVolta());
		});

	}

	@Test
	public void naoDeveRetornarMelhorVoltaDoMassa() {

		pilotosOrdenadosPorColocacao.forEach(p -> {
			if (p.getNome().equals("F.MASSA"))
				assertNotEquals(LocalTime.parse("00:01:02.787"), p.getMelhorTempoVolta());
		});

	}

	@Test
	public void deveRetornarNumeroDaMelhorVoltaDoAlonso() {

		pilotosOrdenadosPorColocacao.forEach(p -> {
			if (p.getNome().equals("F.ALONSO"))
				assertEquals(2, p.getNumeroDaMelhorVolta(), 0);
		});

	}

	@Test
	public void naoDeveRetornarNumeroDaMelhorVoltaDoRaikkonen() {

		pilotosOrdenadosPorColocacao.forEach(p -> {
			if (p.getNome().equals("K.RAIKKONEN"))
				assertNotEquals(2, p.getNumeroDaMelhorVolta(), 0);
		});

	}

	@Test
	public void deveRetornarTempoChegadaDoBarrichelloDepoisDoMassa() {

		IntStream.range(0, pilotosOrdenadosPorColocacao.size()).forEach(index -> {
			if (pilotosOrdenadosPorColocacao.get(index).getNome().equals("R.BARRICHELLO")) {
				LocalTime tempoDeChegadaDepoisDoVencedor = pilotosOrdenadosPorColocacao.get(index).getTempoTotalProva()
						.minus(pilotosOrdenadosPorColocacao.get(0).getTempoTotalProva().toNanoOfDay(),
								ChronoUnit.NANOS);
				assertEquals(LocalTime.parse("00:00:03.002"), tempoDeChegadaDepoisDoVencedor);
			}

		});
	}

	@Test
	public void deveRetornarVelocidadeMediaVettel() {
		DecimalFormat df = new DecimalFormat("#.####");
		informacoesCorrida.informacoesVoltaPorPiloto().forEach((k, v) -> {

			if (v.get(0).getPiloto().getNome().equals("S.VETTEL")) {
				Double velocidadeMediaPorPiloto = v.stream().mapToDouble(Volta::getVelocidadeMedia).average()
						.getAsDouble();
				assertEquals("25,7457", df.format(velocidadeMediaPorPiloto));
			}

		});

	}

}
