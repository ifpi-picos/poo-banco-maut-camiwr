import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.ifpi.poo.Cliente.Client;
import br.edu.ifpi.poo.Cliente.Adress;
import br.edu.ifpi.poo.Conta.Account;
import br.edu.ifpi.poo.Conta.CurrentAccount;
import br.edu.ifpi.poo.Conta.SavingsAccount;
import br.edu.ifpi.poo.Notificacoes.Notification;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

    //menu principal
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL - BANCO MAUT ===");
            System.out.println("==========================");
            System.out.println(" -> Cadastrar Cliente");
            System.out.println(" - Informações do usuario");
            
            System.out.println(" - Menu de Transações");
            System.out.println(" - Consultar extrato");
            System.out.println(" - Consultar saldo");
            System.out.println(" - Editar informações");
            System.out.println(" - Exibir Contas cadastradas");
            System.out.println(" - Sair\n");
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();



            System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
            LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));



            }
        }
    }
}
