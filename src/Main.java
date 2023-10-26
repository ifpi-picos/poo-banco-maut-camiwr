import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.poo.entidades.Account;
import br.edu.ifpi.poo.entidades.Adress;
import br.edu.ifpi.poo.entidades.Client;
import br.edu.ifpi.poo.entidades.CurrentAccount;
import br.edu.ifpi.poo.entidades.SavingsAccount;
import br.edu.ifpi.poo.notificacoes.EmailNotification;
import br.edu.ifpi.poo.notificacoes.Notification;
import br.edu.ifpi.poo.notificacoes.SmsNoticication;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();        

            System.out.println("--------------------------------");
            System.out.println(" Ola, Bem-vindo ao Banco Maut!");
            System.out.println("--------------------------------");

        //menu principal
        while(true){
            System.out.println("\n================================");
            System.out.println("========== BANCO MAUT ==========");
            System.out.println("======== MENU PRINCIPAL ========");
            System.out.println("================================");
            System.out.println("=== 1 -> Criar conta ===========");
            System.out.println("=== 2 -> Logar na conta ========");
            System.out.println("=== 0 -> sair ==================");
            System.out.println("================================");
            System.out.print("-> Digite a opcao desejada:");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    Account newAccount = createAccount(scanner);
                    if( newAccount != null){
                    accounts.add(newAccount);
                    }
                    chooseNotification(scanner);
                break;

                case 2:
                    logAccount(scanner, accounts);
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }
    }

    public static Client createClient (Scanner scanner){
        //Criando o usuario
        System.out.println("\n================================");
        System.out.println("===== Cadastro do cliente ======");
        System.out.println("================================");
        System.out.println("\nPor favor, informe os seus dados para a criação do seu cadastro:");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de nascimento, no formato (DD/MM/AAAA): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //Atributos de endereço
        //! clean
        System.out.println("\n================================");
        System.out.println("===== Endereço do client: =====");
        System.out.println("================================");
        System.out.print("\nRua: ");
        String street = scanner.nextLine();
        System.out.print("Número: ");
        int number = scanner.nextInt();
        System.out.print("Bairro: ");
        String district = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Cidade: ");
        String city = scanner.nextLine();
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        System.out.print("País: ");
        String country = scanner.nextLine();

        Adress adress = new Adress(street, number, district, city, state, country);
        Client client = new Client(name, cpf, birthDate, adress);

        return client;
    }

    private static Account createAccount(Scanner scanner){
        //metodo para criar contas
        System.out.println("\n================================");
        System.out.println("====== Criando nova conta ======");
        System.out.println("================================");
        System.out.println("\nPor favor, informe os dados para a criação da sua conta;");
        System.out.print("\nNúmero da agencia:");
        int agencyNumber = scanner.nextInt();
        System.out.print("Número da conta:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        
        Account newAccount = null;
        
        //! clean
        System.out.println("================================");
        System.out.println("=== Escolha o tipo da conta: ===");
        System.out.println("================================");
        System.out.println("===== 1 -> Conta Corrente ======");
        System.out.println("===== 2 -> Conta Poupança ======");
        System.out.println("================================");
        int contaOpcao = scanner.nextInt();
        scanner.nextLine();

        Client client = createClient(scanner);

        if(contaOpcao == 1){
            double overdraft = 1000;
            System.out.println("-------------------------------------------------");
            System.out.println("O valor do seu cheque especial é de: R$" + overdraft);
            System.out.println("-------------------------------------------------");
            newAccount = new CurrentAccount(agencyNumber, accountNumber, contaOpcao, overdraft, client, new EmailNotification());
            newAccount.setNotification(new EmailNotification());
            newAccount.setNotification(new SmsNoticication());

        } else if (contaOpcao == 2){
            newAccount = new SavingsAccount(contaOpcao, agencyNumber, accountNumber, contaOpcao, client, null);
            newAccount.setNotification(new EmailNotification());
            newAccount.setNotification(new SmsNoticication());
        } else{
            System.out.println("Opção inválida. Tente cadastrar novamente.");
        }
        System.out.println("Conta cadastrada com sucesso.");
        return newAccount;
    }

    public static Account findAccount(List<Account> accounts, int agencyNumber, int accountNumber) {
        for (Account account : accounts) {
            if (account.getAgencyNumber() == agencyNumber && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;  // Retorna null se a conta não for encontrada.
    }
    
    public static void logAccount(Scanner scanner, List<Account> accounts) {
        
        if (accounts.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("\n================================");
            System.out.println("============ Login ============");
            System.out.println("================================");
            System.out.print("\nDigite o Número da agência: ");
            int agencyNumber = scanner.nextInt();
            System.out.print("Digite o Número da conta: ");
            int accountNumber = scanner.nextInt();
    
            Account account = findAccount(accounts, agencyNumber, accountNumber);
            if (account != null) {
                System.out.println("\n----------------------------------------------");
                System.out.println(" Login bem-sucedido. Bem-vindo(a), " + account.getClient().getName() + "!");
                System.out.println("----------------------------------------------");
                if (account instanceof CurrentAccount) {
                    currentAccountTransactions(scanner, accounts, account); // Chama o menu da Conta Corrente.
                } else if (account instanceof SavingsAccount) {
                    savingsAccountTransactions(scanner, accounts, account);// Chama o menu da Conta Poupança.
                }
            } else {
                System.out.println("Conta não encontrada. Verifique os números de agência e conta.");
            }
        }
    }
    
    public static void currentAccountTransactions(Scanner scanner, List<Account> accounts, Account account) {
        while (true) {
            System.out.println("\n================================");
            System.out.println("==== Menu da Conta Corrente ====");
            System.out.println("================================");
            System.out.println("==== 1 -> Realizar Depósito ====");
            System.out.println("===== 2 -> Realizar Saque ======");
            System.out.println("= 3 -> Realizar Transferência ==");
            System.out.println("===== 4 -> Consultar Saldo =====");
            System.out.println("===== 5 -> Exibir Extrato ======");
            System.out.println("=========== 0 -> Voltar ========");
    
            System.out.print("Escolha a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcao) {
                case 1: // Depósito
                    System.out.print("Digite o valor do depósito: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.depositar(depositAmount, null);
                    break;

                case 2: // Saque
                    System.out.print("Digite o valor do saque: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.sacar(withdrawAmount, null);
                    break;

                case 3: // Transferência
                    System.out.print("Digite o número da agência de destino: ");
                    int destAgencyNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    int destAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    Account destAccount = findAccount(accounts, destAgencyNumber, destAccountNumber);
                    if (destAccount != null) {
                        System.out.print("Digite o valor da transferência: ");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.transferir(destAccount, transferAmount, null);
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;

                case 4: // Consultar Saldo
                    System.out.println("Saldo atual: R$" + account.getBalance());
                    break;

                case 5: // Exibir Extrato
                account.displayTransactions();
                    break;

                case 0: // Voltar
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void savingsAccountTransactions(Scanner scanner, List<Account> accounts, Account account) {
        while (true) {
            System.out.println("\n================================");
            System.out.println("==== Menu da Conta Poupança ====");
            System.out.println("================================");
            System.out.println("==== 1 -> Realizar Depósito ====");
            System.out.println("===== 2 -> Realizar Saque ======");
            System.out.println("= 3 -> Realizar Transferência ==");
            System.out.println("===== 4 -> Consultar Saldo =====");
            System.out.println("===== 5 -> Exibir Extrato ======");
            System.out.println("=========== 0 -> Voltar ========");
    
            System.out.print("Escolha a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcao) {
                case 1: // Depósito
                    System.out.print("Digite o valor do depósito: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.depositar(depositAmount, null);
                    break;
                case 2: // Saque
                    System.out.print("Digite o valor do saque: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.sacar(withdrawAmount, null);
                    break;
                case 3: // Transferência
                    System.out.print("Digite o número da agência de destino: ");
                    int destAgencyNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    int destAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    Account destAccount = findAccount(accounts, destAgencyNumber, destAccountNumber);
                    if (destAccount != null) {
                        System.out.print("Digite o valor da transferência: ");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.transferir(destAccount, transferAmount, null);
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;
                case 4: // Consultar Saldo
                    System.out.println("Saldo atual: R$" + account.getBalance());
                    break;
                case 5: // Exibir Extrato
                account.displayTransactions();
                    break;

                case 0: // Voltar
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static Notification chooseNotification(Scanner scanner){
        System.out.println("\nEscolha o meio de notificaçao:");
        System.out.println("1 -> Email");
        System.out.println("2 -> SMS");
        System.out.print("Opção:");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1) {
            return new EmailNotification();
        } else if (opcao == 2) {
            return new SmsNoticication();
        } else {
            System.out.println("Opção invalida. Notificaçao por email padrao.");
            return new EmailNotification();
        }
    }
}