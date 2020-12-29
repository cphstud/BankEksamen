import java.time.LocalDate;
public class Account implements Comparable<Account>, IntrestRate{
    private String name;
    private String accountType;
    private int id;
    private double saldo;
    private double ir;
    private double limit;
    private LocalDate amountInserted;
    private LocalDate irDate;

    public Account(String name, int id, double limit, LocalDate ld) {
        this.name = name;
        this.id = id;
        this.saldo = 0;
        this.limit = limit;
        this.accountType = "basic";
        this.ir = 0.013;
        this.irDate = ld;
    }

    public Account() {

    }

    public void insertAmount(double amount, LocalDate ld) {
        amountInserted = ld;
        saldo = saldo + amount;
    }

    public LocalDate getAmountInserted() {
        return amountInserted;
    }

    public double withDraw(double amount) throws NoMoneyLeftException {
        if ((saldo - amount ) > limit) {
            saldo = saldo - amount;
            return amount;
        } else {
            throw new NoMoneyLeftException(this.name + " is below limit " + limit + " for " + amount);
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Account o) {
        return (int)(this.getSaldo()-o.getSaldo());
    }

    @Override
    public double computeIR() {
        double retVal = 0.0;
        switch (accountType) {
            case "basic": retVal= saldo*ir;break;
            case "gold": retVal= saldo*ir;break;
        }
        return retVal;
    }
}
