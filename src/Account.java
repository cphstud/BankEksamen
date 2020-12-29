public class Account implements Comparable<Account>{
    private String name;
    private int id;
    private double saldo;
    private double limit;


    public Account(String name, int id, double limit) {
        this.name = name;
        this.id = id;
        this.saldo = 0;
        this.limit = limit;
    }

    public void insertAmount(double amount) {
        saldo = saldo + amount;
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
}
