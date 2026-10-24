class ExpenseTracker implements Runnable
{
    public void run()
    {
        System.out.println("Smart Expense Tracker started");
        System.out.println("User details are processed");
        System.out.println("Expense category is checked");
        System.out.println("Expense amount is recorded");
        System.out.println("Expense report is updated");
    }
}

class Expenses
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Smart Expense Tracker");

        ExpenseTracker e = new ExpenseTracker();

        Thread t = new Thread(e);
        t.start();

        System.out.println("Expense activities completed");
    }
}