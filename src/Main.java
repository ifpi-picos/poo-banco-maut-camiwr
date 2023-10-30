import br.edu.ifpi.poo.entidades.Account;
import br.edu.ifpi.poo.entidades.Client;
import br.edu.ifpi.poo.entidades.CurrentAccount;
import br.edu.ifpi.poo.entidades.SavingsAccount;
import br.edu.ifpi.poo.notificacoes.EmailNotification;
import br.edu.ifpi.poo.notificacoes.Notification;

public class Main {
    public static void main(String[] args) throws Exception {
        Client client = new Client("Camila", null, null, null);
        Notification notification = new EmailNotification();
        Account cc = new CurrentAccount(1, 123, 100, 0.1, client, notification);

        Account cp = new SavingsAccount(10, 456, 100, 0, client, notification);

        cc.depositar(100, notification);
        cc.sacar(50, notification);
        cc.displayTransactions();
        // tranferencia não está funcionando
        cc.transferir(cp, 10, notification);
        cc.transferir(cp, 10, notification);
        cc.transferir(cp, 10, notification);
        cc.transferir(cp, 10, notification);
        cc.transferir(cp, 10, notification);
        cc.transferir(cp, 10, notification);
        cc.displayTransactions();

        // deposito não está funcionando
        cp.depositar(100, notification);
        cp.displayTransactions();
    }
}
