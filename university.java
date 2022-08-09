package w1685308;

/**
 *
 * @author ahmed
 */

public class University extends Thread {
    private CurrentAccount currentAccount;

    public University(CurrentAccount currentAccount,String university,ThreadGroup group){
        super(group,university);
        this.currentAccount=currentAccount;
    }

    @Override
    public void run() {
        System.out.println("UNIVERSITY Transactions : ");

        for(int i = 0; i < 3; i++){
            Transaction universityWithdrawal = new Transaction(getName(),35000);
            currentAccount.withdrawal(universityWithdrawal);
            System.out.println("- UNIVERSITY: Transaction withdrawal successful  " + universityWithdrawal);

            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){}
        }
        System.out.println("UNIVERSITY Transactions Complete");
    }
}

