package w1685308;

/**
 *
 * @author ahmed
 */
public class StudentGrandMother extends Thread {

    private CurrentAccount currentAccount;

    public StudentGrandMother(CurrentAccount currentAccount, String grandMother, ThreadGroup group) {
        super(group, grandMother);
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("GRAND_MOTHER Transactions: ");

        Transaction birthdayDeposit = new Transaction(getName(), 1500);
        currentAccount.deposit(birthdayDeposit);
        System.out.println("+ GRAND_MOTHER: Transaction deposit successful " + birthdayDeposit);

        try {
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
        }

        //Transaction birthdayDeposit = new Transaction(getName(),800);
        currentAccount.deposit(birthdayDeposit);
        System.out.println("+ GRAND_MOTHER: Transaction deposit successful" + birthdayDeposit);
        System.out.println("GRAND_MOTHER Transactions Complete");
    }

}
