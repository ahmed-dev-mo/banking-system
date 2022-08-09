package w1685308;

/**
 *
 * @author ahmed
 */
public class StudentsLoanCompany extends Thread {

    private CurrentAccount currentAccount;

    public StudentsLoanCompany(CurrentAccount currentAccount, String loanCompany, ThreadGroup group) {
        super(group, loanCompany);
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("LOAN_COMPANY Transactions :");

        for (int i = 0; i < 3; i++) {
            Transaction loadDeposit = new Transaction(getName(), 45000);
            currentAccount.deposit(loadDeposit);
            System.out.println("+ LOAN_COMPANY: Transaction deposit successful " + loadDeposit);

            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("LOAN_COMPANY Transactions Complete");
    }
}
