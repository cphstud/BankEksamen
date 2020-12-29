import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void addAccountToAccounts(Account account) {
        accounts.add(account);
    }
    public Iterator<Account> getAccounts() {
        Iterator<Account> iterator = accounts.iterator();
        return iterator;
    }

    public Account lowestAccount() {
        Collections.sort(accounts);
        return accounts.get(accounts.size()-1);
    }
    public Account highestAccount() {
        Collections.sort(accounts);
        return accounts.get(0);
    }

    public void addIRToAccounts() {
        LocalDate ld = LocalDate.now();
        for (Account a : accounts ) {
            if (Period.between(a.getAmountInserted(),ld).getDays() > ld.getMonthValue()) {
                a.insertAmount((a.computeIR()), ld);
                System.out.println(" accountdate ok " + a.getAmountInserted() + " so " + a.computeIR());

            } else {
                System.out.println(" accountdate too recent" + a.getAmountInserted());
            }
        }
    }
}
