package w1685308;

/**
 *
 * @author ahmed
 */

public class BankingSystem {

    Student student;
    StudentGrandMother studentgrandMother;
    StudentsLoanCompany studentsloanCompany;
    University university;
    CurrentAccount currentAccount;
    ThreadGroup human;
    ThreadGroup nonHuman;

    public BankingSystem() {
        this.currentAccount = new CurrentAccount("Student", 439865, 0);
        this.student = new Student(currentAccount, currentAccount.getAccountHolder(), human);
        this.studentgrandMother = new StudentGrandMother(currentAccount, "GrandMother", human);
        this.studentsloanCompany = new StudentsLoanCompany(currentAccount, "Loan Company", nonHuman);
        this.university = new University(currentAccount, "University", nonHuman);

        this.human = new ThreadGroup("Human");
        this.nonHuman = new ThreadGroup("Non Human");
    }

    public static void main(String[] args) {

        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.student.start();
        bankingSystem.studentgrandMother.start();
        bankingSystem.studentsloanCompany.start();
        bankingSystem.university.start();

        try {
            bankingSystem.student.join();
            bankingSystem.studentgrandMother.join();
            bankingSystem.studentsloanCompany.join();
            bankingSystem.university.join();
        } catch (InterruptedException e) {
        }

    }

}
