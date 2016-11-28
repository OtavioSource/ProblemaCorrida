package br.com.otavio.teste;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.otavio.util.LeitorArquivo;
import br.com.otavio.util.Voltas;


public class VoltasTeste {
	
	private Voltas voltas;
	
	@Test
	public void deveTrazerVoltas() {
		
		voltas = new Voltas("corrida.log", new LeitorArquivo());		
		assertNotNull(voltas.getVoltas());
	
	}
	
}
