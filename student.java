package w1685308;

/**
 *
 * @author ahmed
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student extends Thread {

    private CurrentAccount currentAccount;

    public Student(CurrentAccount currentAccount, String studentName, ThreadGroup group) {
        super(group, studentName);
        this.currentAccount = currentAccount;
    }

    public void randomTransactions(Transaction[] transactions) {
        int transCount = 0;
        Random random = new Random();
        Set index = new HashSet();

        while (transCount < 6) {
            int randIndex = random.nextInt(6);
            if (index.add(randIndex)) {
                if (randIndex < 4) {
                    currentAccount.withdrawal(transactions[randIndex]);
                    System.out.println("- STUDENT: Transaction withdrawal successful " + transactions[randIndex]);
                } else {
                    currentAccount.deposit(transactions[randIndex]);
                    System.out.println("+ STUDENT: Transaction deposit successful " + transactions[randIndex]);
                }
                try {
                    sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                transCount++;
            }
        }
    }

    @Override
    public void run() {
        System.out.println("STUDENT Transactions :");

        Transaction transportaion = new Transaction(getName(), 700);
        Transaction purchaseSamsungPhone = new Transaction(getName(), 2500);
        Transaction allowance = new Transaction(getName(), 5000);
        Transaction winLottery = new Transaction(getName(), 1000000);
        Transaction shoppingPayments = new Transaction(getName(), 350);
        Transaction educationFee = new Transaction(getName(), 800);

        // transaction array
        Transaction[] transactions = new Transaction[6];
        transactions[0] = transportaion;
        transactions[1] = purchaseSamsungPhone;
        transactions[2] = educationFee;
        transactions[3] = shoppingPayments;
        transactions[4] = allowance;
        transactions[5] = winLottery;

        randomTransactions(transactions);
        System.out.println("STUDENT Transactions Transactions Complete");
        currentAccount.printStatement();

    }
}
