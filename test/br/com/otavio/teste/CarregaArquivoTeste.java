package br.com.otavio.teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.otavio.exception.CarregarArquivoException;
import br.com.otavio.util.InformacoesVoltas;

public class CarregaArquivoTeste {
	
	private InformacoesVoltas infosArquivo = new InformacoesVoltas("corrida.log");
	
	@Test
	public void deveCarregarInformacoesArquivo() throws IOException {
	
		assertNotNull(infosArquivo);
	}
	
	@Test(expected = CarregarArquivoException.class)
	public void deveLancarException(){
		
		infosArquivo = new InformacoesVoltas("teste.txt");
		
	}
	
	

	
	

}
