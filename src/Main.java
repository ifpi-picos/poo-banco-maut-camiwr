

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import br.edu.ifpi.poo.entidades.Account;
import br.edu.ifpi.poo.entidades.CurrentAccount;
import br.edu.ifpi.poo.entidades.SavingsAccount;
import br.edu.ifpi.poo.notificacoes.EmailNotification;
import br.edu.ifpi.poo.notificacoes.SmsNoticication;


public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

    //menu principal
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL - BANCO MAUT ===");
            System.out.println("==========================");
            System.out.println("1 -> Cadastrar Cliente");
            System.out.println(" -> Informações do usuario");
            
            System.out.println(" -> Menu de Transações");
            System.out.println(" -> Consultar extrato");
            System.out.println(" -> Consultar saldo");
            System.out.println(" -> Editar informações");
            System.out.println(" -> Exibir Contas cadastradas");
            System.out.println(" -> Sair\n");
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                case 1:
                clearScreen(1);
                Account newAccount = createAccount(scanner);
            }


            private static Client creaClient(Scanner scanner){

            }

            private static Account createAccount(Scanner scanner) {
                System.out.println("\n=== Cadastro do cliente ===");
                System.out.print("\nNúmero da Agência: ");
                int agencyNumber = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Número da Conta: ");
                int accountNumber= scanner.nextInt();
                scanner.nextLine();
            
                Account newAccount = null;
            
                System.out.println("\nEscolha o tipo da conta:");
                System.out.println("1 -> Conta Corrente");
                System.out.println("2 -> Conta Poupança");
                System.out.print("Digite a opção desejada: ");
                int accountTypeOpcao= scanner.nextInt();
                scanner.nextLine();
        
                Client client = createClient(scanner);
            
                if (accountTypeOpcao == 1) {
                    System.out.print("Cheque Especial: R$");
                    double overdraft = scanner.nextDouble();
                    scanner.nextLine();
                    newAccount = new CurrentAccount(agencyNumber, accountNumber, 0, overdraft, client);
                } else if (accountTypeOpcao == 2) {
                    newAccount = new SavingsAccount(agencyNumber, accountNumber, 0, 0.10, client);
                } else {
                    System.out.println("Opção inválida. Tente cadastrar novamente.");
                }
                
                System.out.println("Conta cadastrada com sucesso.");
                return newAccount;
            }



            System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
            LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            public static void clearScreen(int cooldown) {
                try {
                    Thread.sleep(cooldown * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        

            }
        }
    }

    private static void clearScreen(int i) {
    }
}
