import java.util.Scanner; 
 class InvalidExpenseException extends Exception {  
        InvalidExpenseException() {  
                   super("Invalid expense amount!"); 
                    } } 
public class ExpenseMonitor {   
    public static void main(String[] args) {      
           Scanner sc = new Scanner(System.in);   
           System.out.println("SMART EXPENSE TRACKER");    
           System.out.print("Enter User Name: ");      
           String userName = sc.nextLine();         
           System.out.print("Enter Expense Amount: ");       
           double amount = sc.nextDouble(); 
        
        try {   
             if (amount < 0 || amount > 100000) {    
                throw new InvalidExpenseException(); 
             }
              System.out.println();  
              System.out.println("User Name : " + userName);
            
              if (amount == 0) { 
                System.out.println("Status : No Expense Recorded");     
                     }
                
             else {  
                    System.out.println("Amount : ₹" + amount);
                     System.out.println("Status : Expense Recorded");   
                     }      
                       }     
         catch (InvalidExpenseException e) {          
               System.out.println();   
               System.out.println("Exception : " + e.getMessage());   
               System.out.println("Status : Expense Recording Not Allowed");   
                  }
                
                  sc.close();   
                 }
                } 
