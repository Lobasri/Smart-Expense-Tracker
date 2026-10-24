import customer.Customer;
import expense.Expense;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer();
        Expense expense = new Expense();

        System.out.println("===== SMART EXPENSE TRACKER =====");
        System.out.println();

        System.out.println("--- USER DETAILS ---");
        customer.showUser();

        System.out.println();

        System.out.println("--- EXPENSE DETAILS ---");
        expense.showExpense();

        System.out.println();

        System.out.println("Expense recorded successfully.");
        System.out.println("Smart Expense Tracker completed successfully!");
    }
}



