package br.com.otavio.teste;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import br.com.otavio.util.CarregaInformacaoArquivo;

public class ProblemaCorridaTeste {
	
	private CarregaInformacaoArquivo infosArquivo = new CarregaInformacaoArquivo();
	
	@Test
	public void deviaLerArquivoLog() throws IOException {
	
		assertNotNull(infosArquivo);
	}
	

	
	

}
