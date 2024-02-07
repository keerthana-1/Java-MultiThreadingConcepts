package edu.umb.cs681.hw12;

public class DepositRunnable implements Runnable {

    private ThreadSafeBankAccount2 bankAccount;
    private volatile boolean done=false;
    public DepositRunnable(ThreadSafeBankAccount2 bankAccount) {
        this.bankAccount=bankAccount;
    }

    public void setDone(){
        done=true;
    }

    @Override
    public void run(){
        while(true) {
            try {
                if (done) {
                    System.out.println("set done deposit");
                    break;
                }
                bankAccount.deposit(100);
                Thread.sleep(2000);
            }
            catch (InterruptedException ex) {
                System.out.println("interrupted");
                continue;

            }
        }

    }
}
