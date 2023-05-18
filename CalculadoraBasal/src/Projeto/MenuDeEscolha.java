package Projeto;

import java.util.Locale;
import java.util.Scanner;

import Calculos.CalculoDeCaloriasAlimento;
import Calculos.CalculoDeTaxaBasal;

public class MenuDeEscolha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		boolean sair = false;

		// Menu de escolha com LOOP;
		while (!sair) {
			System.out.println("======== MENU ========");
			System.out.println("1 - Calcular Taxa Basal");
			System.out.println("2 - Calcular Calorias de Alimentos");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				CalculoDeTaxaBasal.calcularTaxaBasal(sc);
				break;
			case 2:
				CalculoDeCaloriasAlimento.escolherAlimentos(sc);
				break;
			case 3:
				sair = true;
				break;
			default:
				System.out.println("Opção inexistente, entre com uma opção válida");
				break;
			}
			System.out.println();
		}

		sc.close();
	}
}
