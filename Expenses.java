class ExpenseTracker extends Thread
{
   \ public void run()
    {
        System.out.println("Smart Expense Tracker started");
        System.out.println("User expense details checked");
        System.out.println("Expense category processed");
        System.out.println("Expense amount recorded");
        System.out.println("Daily expense report updated");
    }
}

class Expenses
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Smart Expense Tracker");

        ExpenseTracker e = new ExpenseTracker();
        e.start();

        System.out.println("Expense activities completed");
    }
}