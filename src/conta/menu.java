package conta;

import java.io.IOException;
import java.util.Scanner;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;


		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 27, 1, "Faruk Rafael", 4000f, 300.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Aimmee Generation", 7000f, 500.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Lorenna Generation", 9000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Geandro Generation", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		System.out.println();
		while (true) {
			System.out.println(Cores.TEXT_WHITE_BOLD +"*****************************************************");
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_CYAN_BOLD + " BANCO JABUTI - O Banco que Faz Seu Futuro Crescer!  " + Cores.TEXT_RESET);
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println(Cores.TEXT_RED + "            9 - Sair                 " + Cores.TEXT_RESET);
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println(Cores.TEXT_WHITE_BOLD + "Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Banco Jabuti – O Banco que Faz Seu Futuro Crescer!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Criar Conta\n\n");

				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta \n1 - Conta Corrente" + "\n2 - Conta poupança: ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$)");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

			case 2:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();
				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Depósito\n\n");

				System.out.println("Digite o Número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Transferência entre Contas\n\n");

				System.out.println("Digite o número da Conta Origem: ");
				numero = leia.nextInt();
				System.out.println("DIgite o número da Conta de Destino: ");
				numeroDestino = leia.nextInt();

				do {
					System.out.println("Digite o valor da tranferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Guilherme Kaynam ©");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/GuilhermeKaynam");
		System.out.println("*********************************************************");
	}

}
