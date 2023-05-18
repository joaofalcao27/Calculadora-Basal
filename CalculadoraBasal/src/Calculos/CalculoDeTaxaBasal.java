package Calculos;

import java.util.Scanner;

public class CalculoDeTaxaBasal {

	public static void calcularTaxaBasal(Scanner sc) {
		double peso, altura, gastoBasal, emagrecer = 0, engordar = 0;
		int idade, fatorAtividade, objetivo;
		String sexo, resposta;
		boolean continuar = true;

		while (continuar) {
			System.out.print("Insira o seu peso em kg: ");
			peso = sc.nextDouble();
			System.out.print("Insira a sua altura em cm: ");
			altura = sc.nextDouble();
			System.out.print("Insira a sua idade: ");
			idade = sc.nextInt();
			System.out.println("Informe o seu sexo: \nM - Masculino \nF - Feminino");
			sexo = sc.next();

			if (sexo.equalsIgnoreCase("F")) {
				if (idade > 10 && idade <= 18) {
					gastoBasal = (13.384 * peso) + 692.6;
				} else if (idade > 18 && idade <= 30) {
					gastoBasal = (14.818 * peso) + 486.6;
				} else if (idade > 30 && idade <= 60) {
					gastoBasal = (8.126 * peso) + 845.6;
				} else {
					gastoBasal = 0;
				}
			} else {
				if (idade > 10 && idade <= 18) {
					gastoBasal = (17.686 * peso) + 658.2;
				} else if (idade > 18 && idade <= 30) {
					gastoBasal = (15.057 * peso) + 692.2;
				} else if (idade > 30 && idade <= 60) {
					gastoBasal = (11.472 * peso) + 873.1;
				} else {
					gastoBasal = 0;
				}
			}
			System.out.println("Informe o nível de atividade física:");
			System.out.println("1- Leve");
			System.out.println("2- Moderada");
			System.out.println("3- Intensa");
			fatorAtividade = sc.nextInt();
			double gastoCalorico;

			switch (fatorAtividade) {
			case 1:
				gastoCalorico = gastoBasal * 1.55;
				break;
			case 2:
				gastoCalorico = gastoBasal * 1.84;
				break;
			case 3:
				gastoCalorico = gastoBasal * 2.2;
				break;
			default:
				gastoCalorico = 0;
				break;
			}
			System.out.println("Informe o seu objetivo:");
			System.out.println("1- Emagrecer");
			System.out.println("2- Engordar");
			System.out.println("3- Manter o peso atual");
			objetivo = sc.nextInt();

			switch (objetivo) {
			case 1:
				emagrecer = gastoCalorico - 500;
				break;
			case 2:
				engordar = gastoCalorico + 500;
				break;
			case 3:
				break;
			default:
				gastoCalorico = 0;
				break;
			}

			System.out.printf("Taxa metabólica basal (sem atividade física): %.2f Kcal\n", gastoBasal);
			System.out.printf("Taxa metabólica basal (com atividade física): %.2f Kcal\n", gastoCalorico);
			System.out.printf("Calorias para emagrecer: %.2f Kcal\n", emagrecer);
			System.out.printf("Calorias para engordar: %.2f Kcal\n", engordar);

			System.out.print("Deseja fazer outro cálculo? (S/N): ");
			resposta = sc.next();
			continuar = resposta.equalsIgnoreCase("S");
		}
		System.out.println();

		System.out.println("Obrigado por usar a Calculadora Basal!");
	}
}
