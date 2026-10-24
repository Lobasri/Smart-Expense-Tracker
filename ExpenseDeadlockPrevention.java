import java.util.Scanner;
class ExpenseSystem {
    boolean verificationDone = false;
    synchronized void processExpense(String user) {
        System.out.println("\n" + user + " is waiting for expense verification...");
        while (!verificationDone) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(user + " expense processing completed.");
    }
    synchronized void verification() {
        System.out.println("\nExpense verification is in progress...");
        verificationDone = true;
        System.out.println("Expense verification completed.");
        notify();
        System.out.println("Waiting expense thread is notified.");
    }
}
class ExpenseThread extends Thread {
    ExpenseSystem expense;
    String user;
    ExpenseThread(ExpenseSystem expense, String user) {
        this.expense = expense;
        this.user = user;
    }
    public void run() {
        expense.processExpense(user);
    }
}
class VerificationThread extends Thread {
    ExpenseSystem expense;
    VerificationThread(ExpenseSystem expense) {
        this.expense = expense;
    }
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        expense.verification();
    }
}
public class ExpenseDeadlockPrevention {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SMART EXPENSE TRACKER");
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        ExpenseSystem expense = new ExpenseSystem();
        ExpenseThread process = new ExpenseThread(expense, name);
        VerificationThread verification = new VerificationThread(expense);
        process.start();
        verification.start();
        sc.close();
    }
}

