package br.com.otavio.teste;

import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import org.junit.Test;

import br.com.otavio.exception.CarregarArquivoException;
import br.com.otavio.util.LeitorArquivo;

public class LeitorArquivoTeste {
	
	private LeitorArquivo leitorArquivo = new LeitorArquivo();
	
	@Test
	public void deveCarregarInformacoesArquivo() {
		
		Stream<String> linhas = leitorArquivo.carregaArquivoLog("corrida.log");
		assertNotNull(linhas);
	}
	
	@Test(expected = CarregarArquivoException.class)
	public void deveLancarException(){
		
		Stream<String> linhas = leitorArquivo.carregaArquivoLog("erro.log");
		
	}
	
	

	
	

}
