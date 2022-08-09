package w1685308;

/**
 *
 * @author ahmed
 */

public class CurrentAccount implements StudentsBankAccount {

    private String accountHolderID;
    private int accountNumber;
    private int balance;
    private Statement statement;

    public CurrentAccount(String custID, int accNum, int balance) {
        this.accountHolderID = custID;
        this.accountNumber = accNum;
        this.balance = balance;
        this.statement = new Statement(custID, accountNumber);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getAccountHolder() {
        return this.accountHolderID;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        int depositAmount = t.getAmount();
        this.balance = balance + depositAmount;
        this.statement.addTransaction(t.getCID(), depositAmount, this.balance);
        notifyAll();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        int withdrawalAmount = t.getAmount();

        while (withdrawalAmount > this.balance) {
            try {
                System.out.println("* You do not have enough to withdrawal £" + withdrawalAmount + " for " + t.getCID());
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.balance = balance - withdrawalAmount;
        this.statement.addTransaction(t.getCID(), withdrawalAmount, this.balance);
        notifyAll();
    }

    @Override
    public boolean isOverdrawn() {
        return this.balance < 0;
    }

    @Override
    public void printStatement() {
        this.statement.print();
    }
}
