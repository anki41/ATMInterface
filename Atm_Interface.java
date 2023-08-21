import java.util.ArrayList;
import java.util.Scanner;
 
public class Atm_Interface {
    private static double balance = 100000.0; //initial account balance
    private static ArrayList<String> transactionHistory =new ArrayList<>();

     public static void main(String args[]) {
        Scanner scanner =new Scanner(System.in);

        while(true){
            showMenu();
            int choice = scanner .nextInt();
            scanner.nextLine(); //consume the newline character after reading thi integer choice

            switch(choice){
                case 1:
                withdraw(scanner);
                break;
                case 2:
                deposite(scanner);
                break;
                 case 3:
                transfer(scanner);
                break;
                case 4:
                showTransactionHistory();
                break;
                case 5:
                exit();
                break;
                default:
                System.out.println("Invalid choice.\nplease try again.");
            }
        }
    }

          private static void showMenu(){
            System.out.println("ATM MENU");
            System.out.println("1. Withdraw");
             System.out.println("2. Deposit");
            System.out.println("3. Transfer");
             System.out.println("4. transaction History");
            System.out.println("5. Exit");
            System.out.println("Enter your choice :");
          }

           private static void withdraw(Scanner scanner){
            System.out.println();// consume the newline character
            System.out.print("Enter the amount to withdraw :");
            double amount = scanner.nextDouble();
            scanner.nextLine();// consume the new line character after reading the double amount

               if (amount > 0 && amount <= balance){
                balance -=amount;
                System.out.println("Withdrawal Successfully. \n current balance:" + balance);
                addTransactionHistory("Withdrawal :"+amount);
           }else {
            System.out.println("Inufficient balance or invalid amount. \nplease try again.");
           }
           System.out.println();// consume the new line charcter
        }

            private static void deposite(Scanner scanner){
            System.out.println();// consume the newline character
            System.out.println("Enter the amount to deposite :");
            double amount = scanner.nextDouble();
            scanner.nextLine();// consume the new line character after reading the double amount

               if (amount > 0 ){
                balance +=amount;
                System.out.println("Deposite Successfully. \n current balance:" + balance);
                addTransactionHistory("Deposite:"+amount);
           }else {
            System.out.println(" invalid amount. \nplease try again.");
           }
           System.out.println();// consume the new line charcter
        }

            private static void transfer(Scanner scanner){
            System.out.println();// consume the newline character
            System.out.println("Enter the amount to Transfer :");
            double amount = scanner.nextDouble();
            scanner.nextLine();// consume the new line character after reading the double amount

               if (amount > 0 && amount <= balance){
                System.out.println("Enter the reciptent's account number ");
                String recipientAccount = scanner.nextLine();

                balance -= amount;
                System.out.println("Transfer Successful.\ncurrent balance: "+balance);
                addTransactionHistory("Transfer "+amount+" to account number."+recipientAccount);
           }else {
            System.out.println("Inufficient balance or invalid amount. \nplease try again.");
           }
           System.out.println();// consume the new line charcter
        }

           private static void showTransactionHistory(){
             System.out.println();// consume the new line charcter
             System.out.println("Transaction History :");
             for(String transaction : transactionHistory){
             System.out.println(transaction);
          } 
          System.out.println();// consume the new line character  
        }      

             private static void addTransactionHistory(String transaction){
                System.out.println();// consume the new line character
                transactionHistory.add(transaction);
             }

              private static void exit(){
                System.out.println("thank you for using out ATM .\nHave a nice day!!\nvisit again!!");
                System.exit(0);
              }

}          