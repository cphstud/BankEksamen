import java.time.LocalDate;

public class GoldMemberAccount implements IntrestRate{
    Account basicAccount;

    public GoldMemberAccount(Account account) {
        this.basicAccount = account;
    }


    public void insertAmount(double amount, LocalDate ld) {
        basicAccount.insertAmount(amount, ld);
    }

    public LocalDate getAmountInserted() {
        return basicAccount.getAmountInserted();
    }

    public double withDraw(double amount) throws NoMoneyLeftException {
        return basicAccount.withDraw(amount);
    }

    public double getSaldo() {
        return basicAccount.getSaldo();
    }

    public String getName() {
        return basicAccount.getName();
    }

    public int compareTo(Account o) {
        return basicAccount.compareTo(o);
    }

    @Override
    public double computeIR() {
        return 3.4*basicAccount.computeIR();
    }
}
