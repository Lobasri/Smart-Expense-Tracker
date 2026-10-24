import java.util.Scanner;

public class ExpenseTracker {

    static String appName = "SMART EXPENSE TRACKER";

    int id;
    String category;
    double amount;

    static void welcome() {
        System.out.println(appName);
    }

    void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Expense ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Category: ");
        category = sc.nextLine();

        System.out.print("Amount: ");
        amount = sc.nextDouble();
    }

    void display() {
        double gst = amount * 0.18;
        System.out.println("\nID: " + id);
        System.out.println("Category: " + category);
        System.out.println("Amount: Rs." + amount);
        System.out.println("GST: Rs." + gst);
        System.out.println("Total: Rs." + (amount + gst));
    }

    public static void main(String[] args) {
        welcome();

        ExpenseTracker e = new ExpenseTracker();
        e.input();
        e.display();
    }
}