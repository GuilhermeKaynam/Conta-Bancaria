package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class menu {

	public static void main(String[] args) {

		Conta c1 = new Conta(1, 123, 1, "Guilherme", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		Scanner conta = new Scanner(System.in);

		int opcao;

		System.out.println(Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
		while (true) {
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println(" BANCO JABUTI - O Banco que Faz Seu Futuro Crescer!  ");
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
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = conta.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Banco Jabuti – O Banco que Faz Seu Futuro Crescer!");
				sobre();
				conta.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_WHITE_UNDERLINED + "\nOpção Inválida!\n");
				break;
			}
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
