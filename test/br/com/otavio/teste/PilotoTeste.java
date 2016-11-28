package br.com.otavio.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.otavio.model.Piloto;
import br.com.otavio.model.Volta;
import br.com.otavio.util.InformacoesCorrida;

public class PilotoTeste {
	private InformacoesCorrida infoCorrida = new InformacoesCorrida();

	@Test
	public void deveRetornarPrimeiroColocado() {
				
		List<Piloto> pilotos = infoCorrida.pilotosOrdenadosPorPosicaoDeChegada();
		
		assertEquals("F.MASSA", pilotos.get(0).getNome());
	}
	
	@Test
	public void deveRetornarNumeroDePilotosDaCorrida() {
						
		List<Piloto> pilotos = infoCorrida.pilotosOrdenadosPorPosicaoDeChegada();		
		assertEquals(6, pilotos.size());
	}
	
	@Test
	public void deveRetornarPilotoComMelhorTempoNaCorrida() {
				
		List<Volta> voltas = infoCorrida.voltasOrdenadasPorMenorTempo();
		
		
		assertEquals("F.MASSA", voltas.get(0).getPiloto().getNome());
	}
	
	@Test
	public void deveRetornarNumeroDeVoltasDoPilotoQueNaoCompletouACorrida() {
				
		List<Piloto> pilotos = infoCorrida.pilotosOrdenadosPorPosicaoDeChegada();
		
		
		
		assertEquals("S.VETTEL", pilotos.get(0).getNome());
	}
	

}
