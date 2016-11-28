package br.com.otavio.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import br.com.otavio.exception.CarregarArquivoException;

public class LeitorArquivo {

	public Stream<String> carregaArquivoLog(String nomeDoArquivo) {

		try {
			Path caminho = Paths.get(nomeDoArquivo);
			Stream<String> linhas = Files.lines(caminho).skip(1);
			return linhas;

		} catch (IOException e) {
			throw new CarregarArquivoException("Erro ao carregar o arquivo");
		}

	}

}
