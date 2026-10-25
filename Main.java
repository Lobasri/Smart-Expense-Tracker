class ExpenseTracker {

    private String category;
    private double amount;

    public static String appName = "SMART EXPENSE TRACKER";

    public static void welcome() {
        System.out.println("=================================");
        System.out.println("        " + appName);
        System.out.println("=================================");
    }

    public void expense() {

        category = "Food";
        amount = 500.0;

        System.out.println("Category      : " + category);
        System.out.println("Amount        : Rs. " + amount);

        if (amount < 500)
            System.out.println("Expense Level : Low");
        else if (amount <= 1000)
            System.out.println("Expense Level : Medium");
        else
            System.out.println("Expense Level : High");
    }

    public void expense(double gst) {

        double total = amount + gst;

        System.out.println("\n-------- GST DETAILS --------");
        System.out.println("GST          : Rs. " + gst);
        System.out.println("Total Amount : Rs. " + total);
    }

    public void expense(String paymentMode) {

        System.out.println("\n------ PAYMENT DETAILS ------");
        System.out.println("Payment Mode : " + paymentMode);
    }

    public void receipt() {

        System.out.println("\n========== RECEIPT ==========");
        System.out.println("Category     : " + category);
        System.out.println("Amount       : Rs. " + amount);
        System.out.println("=============================");
    }
}

public class Main {

    public static void main(String[] args) {

        ExpenseTracker.welcome();

        ExpenseTracker e = new ExpenseTracker();

        e.expense();
        e.expense(50.0);
        e.expense("UPI");
        e.receipt();

        System.out.println("\nAccessing Static Variable : " + ExpenseTracker.appName);

        System.out.println("\nProgram Executed Successfully!");
    }
}