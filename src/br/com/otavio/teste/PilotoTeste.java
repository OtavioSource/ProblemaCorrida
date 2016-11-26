package br.com.otavio.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.otavio.model.Piloto;
import br.com.otavio.util.InfoCorrida;

public class PilotoTeste {
	private InfoCorrida infoCorrida = new InfoCorrida();

	@Test
	public void deviaRetornarPrimeiroColocado() {
				
		List<Piloto> pilotos = infoCorrida.retornaListaDePiloto();
		
		assertEquals("Primeiro Colocado", "F.MASSA", pilotos.get(0).getNome());
	}
	
	@Test
	public void deviaRetornarNumeroDePilotosDaCorrida() {
						
		List<Piloto> pilotos = infoCorrida.retornaListaDePiloto();		
		assertEquals("Número de Pilotos na corrida", 6, pilotos.size());
	}
	
	

}
