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
//import br.edu.ifpi.poo.notificacoes.EmailNotification;
//import br.edu.ifpi.poo.notificacoes.SmsNoticication;


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
            System.out.println("======= 1 -> Criar conta =======");
            System.out.println("===== 2 -> Logar na conta ======");
            System.out.println("== 3 -> Informações do usuario==");
            System.out.println("========== 0 -> sair ===========");
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
                break;

                case 2:
                //longAccount;
                    break;

                case 3:
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
        LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //Atributos do endereço
        //! clean
        System.out.println("\n================================");
        System.out.println("===== Endereço do Cliente: =====");
        System.out.println("================================");
        System.out.println("\nRua: ");
        String street = scanner.nextLine();
        System.out.print("Número: ");
        int number = scanner.nextInt();
        System.out.print("Bairro: ");
        String district = scanner.nextLine();
        System.out.print("Cidade: ");
        String city = scanner.nextLine();
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        System.out.print("País: ");
        String country = scanner.nextLine();

        Adress adress = new Adress(street, number, district, city, state, country);
        Client client = new Client(name, cpf, null, adress);

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
            newAccount = new CurrentAccount(agencyNumber, accountNumber, contaOpcao, overdraft, client);
        } else if (contaOpcao == 2){
            newAccount = new SavingsAccount(contaOpcao, agencyNumber, accountNumber, contaOpcao, client);
        } else{
            System.out.println("Opção inválida. Tente cadastrar novamente.");
        }
        System.out.println("Conta cadastrada com sucesso.");
        return newAccount;
    }
}