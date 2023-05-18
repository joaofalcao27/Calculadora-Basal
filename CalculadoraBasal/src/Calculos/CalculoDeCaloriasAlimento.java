package Calculos;

import java.util.Scanner;

public class CalculoDeCaloriasAlimento {

	public static void escolherAlimentos(Scanner sc) {
		// Arrays de alimentos e calorias dos mesmos
		String[] alimentos = { "Frango", "Arroz", "Batata doce", "Ovo", "Macarrão", "Feijão" };
		int[] calorias = new int[alimentos.length];

		boolean adicionar = true;

		while (adicionar) {
			System.out.print("Digite o nome do alimento: ");
			String alimento = sc.next();

			int contAlimento = -1;
			for (int i = 0; i < calorias.length; i++) {
				if (alimentos[i].equalsIgnoreCase(alimento)) {
					contAlimento = i;
					break;
				}
			}
			if (contAlimento == -1) {
				System.out.println("Alimento ainda não cadastrado!");
			} else {
				if (alimentos[contAlimento].equalsIgnoreCase("Ovo")) {
					System.out.print("Informe as unidades: ");
					int unidadeOvo = sc.nextInt();
					sc.nextLine();

					System.out.println("Informe o tamanho do ovo: \nP - Pequeno\nM - Médio\nG - Grande");
					String tamanhoOvo = sc.next();

					calorias[contAlimento] += calcularCaloriasOvo(tamanhoOvo, unidadeOvo);

				} else {
					System.out.print("Informe a quantidade em gramas: ");
					int quantidade = sc.nextInt();
					sc.nextLine(); // Limpar o buffer do scanner

					calorias[contAlimento] += calcularCalorias(alimentos[contAlimento], quantidade);
				}
			}
			System.out.print("Deseja adicionar mais alimentos? (S/N): ");
			String resposta = sc.next();
			adicionar = resposta.equalsIgnoreCase("S");

			sc.nextLine();
		}
		int caloriasTotais = 0;
		for (int i = 0; i < alimentos.length; i++) {
			System.out.printf("Calorias de %s: %d kcal\n", alimentos[i], calorias[i]);
			caloriasTotais += calorias[i];
		}

		System.out.printf("Calorias totais dos alimentos: %d kcal\n", caloriasTotais);
	}

	public static int calcularCalorias(String alimento, int quantidade) {
		int calorias = 0;

		switch (alimento) {
		case "Frango":
			calorias = quantidade * 165 / 100;
			break;
		case "Batata doce":
			calorias = quantidade * 77 / 100;
			break;
		case "Arroz":
			calorias = quantidade * 130 / 100;
			break;
		case "Macarrão":
			calorias = quantidade * 157 / 100;
			break;
		case "Feijão":
			calorias = quantidade * 76 / 100;
			break;
		}

		return calorias;
	}

	public static int calcularCaloriasOvo(String tamanhoOvo, int unidadeOvo) {
		int calorias = 0;

		switch (tamanhoOvo.toUpperCase()) {
		case "P":
			calorias = unidadeOvo * 54;
			break;
		case "M":
			calorias = unidadeOvo * 65;
			break;
		case "G":
			calorias = unidadeOvo * 74;
			break;
		}

		return calorias;
	}
}
