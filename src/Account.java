import java.util.Scanner;

public class Account {
    String customerName;
    String customerID;
    int balance;
    int previousTransaction;

    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }

    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your  balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option){
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("==============================");
                    break;
                default:
                    System.out.println("Error, Invalid option. Please enter A,B,C,D or E");
                    break;
            }
        } while(option != 'E');
        System.out.println("Thank you for banking with us");
    }
}
