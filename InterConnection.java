class ExpenseTracker {

    int amount = 0;
    String expenseStatus = "Not Entered";
    String paymentStatus = "Not Completed";

    synchronized void checkExpense() {

        System.out.println("System is checking expense details...");

        if (expenseStatus.equals("Not Entered")) {

            System.out.println("Expense details are not entered");
            System.out.println("Waiting for expense entry...");

            try {
                wait();
            }
            catch (Exception e) {
            }
        }

        System.out.println("Expense details are available");
        System.out.println("System can process the expense");

        notify();
    }

    synchronized void enterExpense() {

        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
        }

        expenseStatus = "Entered";

        System.out.println("User entered the expense details");

        notify();
    }

    synchronized void processExpense() {

        try {
            wait();
        }
        catch (Exception e) {
        }

        if (expenseStatus.equals("Entered")) {

            System.out.println("System is processing the expense...");
            System.out.println("Expense processed successfully");

            notify();
        }
    }

    synchronized void checkPayment() {

        try {
            wait();
        }
        catch (Exception e) {
        }

        System.out.println("Checking payment status...");

        paymentStatus = "Completed";

        if (paymentStatus.equals("Completed")) {

            System.out.println("Payment completed successfully");

            notify();
        }
        else {
            System.out.println("Payment is not completed");
        }
    }

    synchronized void generateReport() {

        try {
            wait();
        }
        catch (Exception e) {
        }

        if (paymentStatus.equals("Completed")) {

            System.out.println("Generating expense report...");

            amount = 500;

            System.out.println("Expense amount: " + amount);
            System.out.println("Expense report generated successfully");
        }
        else {

            System.out.println("Payment is not completed");
            System.out.println("Report cannot be generated");
        }
    }
}

public class InterConnection {

    public static void main(String[] args) {

        ExpenseTracker e = new ExpenseTracker();

        new Thread() {
            public void run() {
                e.checkExpense();
            }
        }.start();

        new Thread() {
            public void run() {
                e.enterExpense();
            }
        }.start();

        new Thread() {
            public void run() {
                e.processExpense();
            }
        }.start();

        new Thread() {
            public void run() {
                e.checkPayment();
            }
        }.start();

        new Thread() {
            public void run() {
                e.generateReport();
            }
        }.start();
    }
}
