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
}
