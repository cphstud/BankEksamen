import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Hobro");

        Account account1 = new Account("Kurt",1,0);
        Account account2 = new Account("Lis",2,-20);
        Account account3 = new Account("Lone",3,-100);
        Account account4 = new Account("Ludvig",4,0);
        Account account5 = new Account("Karl",5,0);
        Account account6 = new Account("Marx",6,0);
        bank.addAccountToAccounts(account1);
        bank.addAccountToAccounts(account2);
        bank.addAccountToAccounts(account3);
        bank.addAccountToAccounts(account4);
        bank.addAccountToAccounts(account5);
        bank.addAccountToAccounts(account6);
        for (int i = 1;i<200; i++) {
            account1.insertAmount((i*50)%33);
            account2.insertAmount((i*50)%35);
            account3.insertAmount((i*150)%38);
            account4.insertAmount((i*20)%(i*13));
            account5.insertAmount((i*30)%(i*133));
            account6.insertAmount((i*50)%3);
        }

        Iterator<Account> it = bank.getAccounts();
        while(it.hasNext()) {
            System.out.println(it.next().getSaldo());
        }
        for (int i = 1;i<20; i++) {
            try {
            account1.withDraw((i*30));
            account2.withDraw((i*20));
            account3.withDraw((i*20));
            account4.withDraw((i*90));
            account5.withDraw((i*90));
            account6.withDraw((i*50)%3);
            } catch (NoMoneyLeftException e) {
                e.printStackTrace();
            }
        }
        System.out.println( " ...");
        Iterator<Account> its = bank.getAccounts();
        while(its.hasNext()) {
            Account a = its.next();
            System.out.println(a.getName() + " has " + a.getSaldo());
        }
    }
}
