package br.com.otavio.main;

import java.io.IOException;
import java.util.Scanner;

import br.com.otavio.util.Resultados;

public class StartCorrida {

	public static void menu() {

		System.out.println("\tInformações da Corrida");
		System.out.println("\n");
		System.out.println("0. Fim");
		System.out.println("1. Ranking Final da Corrida");
		System.out.println("2. Melhor volta da Corrida");
		System.out.println("3. Melhor volta de cada Piloto");
		System.out.println("4. Velocidade Média de cada Piloto");
		System.out.println("5. Tempo de Chegada depois do Vencedor");
		System.out.println("Selecione qual informação deseja visualizar:");
	}

	public static void main(String[] args) throws IOException {

		Resultados resultados = new Resultados();

		int opcao;
		Scanner entrada = new Scanner(System.in);

		do {
			menu();
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:

				/*
				 * Montar o resultado da corrida com as seguintes informações:
				 * Posição Chegada, Código Piloto, Nome Piloto, Qtde Voltas
				 * Completadas e Tempo Total de Prova.
				 */

				resultados.imprimeRankingFinalDaCorrida();
				break;

			case 2:
				/* Descobrir a melhor volta da corrida */
				resultados.imprimeMelhorVoltaDaCorrida();
				break;

			case 3:
				/* Descobrir a melhor volta de cada piloto */
				resultados.imprimeMelhorVoltaDeCadaPiloto();
				break;

			case 4:
				/*
				 * Calcular a velocidade média de cada piloto durante toda
				 * corrida
				 */
				resultados.imprimeVelocidadeMediaDeCadaPiloto();
				break;

			case 5:
				/* Descobrir quanto tempo cada piloto chegou após o vencedor */
				resultados.imprimeTempoDeChegadaDepoisDoVencedor();
				break;

			default:
				System.out.println("Opção inválida. Por favro digite uma opção válida");
			}
		} while (opcao != 0);
	}

}
