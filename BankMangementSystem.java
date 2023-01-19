import java.util.*;

public class TestBank {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int[] accountNumbers = new int[11];
        double[] accountBalances = new double[11];

        //Declare Variables
        int userChoice;
        int accountNumber;
        double depositAmount;
        double withdrawAmount;
        String Line = "---------------------------------------";

        //Input screen
        while (true) {
        System.out.println("          ----- Welcome to our "+ "Bank Management System. -----"+ " ");
        System.out.println(Line);
        System.out.println("[1]. Create an account" + "                   |");
        System.out.println(Line);
        System.out.println("[2]. Deposit money" + "                       |");
        System.out.println(Line);
        System.out.println("[3]. Withdraw money" + "                      |");
        System.out.println(Line);
        System.out.println("[4.] Check balance" + "                       |");
        System.out.println(Line);
        System.out.println("[5.] Exit" + "                                |");
        System.out.println(Line);
        System.out.print("Please enter your choice: ");
        userChoice = input.nextInt();

        //Output screen
        switch (userChoice) {

            //Account Creation
            case 1:
                System.out.print("Please enter your 10-digit account number: ");
                accountNumber = input.nextInt();
                if (accountNumber < 100000000 || accountNumber > 999999999) {
                    System.out.println("Error: Invalid account number. Please enter a 10-digit number.");
                    break;
                }
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == 0) {
                        accountNumbers[i] = accountNumber;
                        System.out.println(Line+"|");
                        System.out.println("          ----- Your account has been created successfully! -----");
                        System.out.println(Line+"|");
                        break;
                    }
                }
                break;

            //Deposit Panel 
            case 2:
                System.out.print("Please enter your 10-digit account number: ");
                accountNumber = input.nextInt();
                int accountIndex = -1;
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == accountNumber) {
                        accountIndex = i;
                        break;
                    }
                }
                if (accountIndex == -1) {
                    System.out.println(Line+"|");
                    System.out.println("Error: Account not found.");
                    break;
                }
                System.out.print("Please enter the amount you wish to deposit: ");
                depositAmount = input.nextDouble();
                accountBalances[accountIndex] += depositAmount;
                System.out.println(Line+"|");
                System.out.println("          ----- Deposit successful! Your new balance is: " + accountBalances[accountIndex] + " Petot -----");
                System.out.println(Line+"|");
                break;

            //Withdrawal Panel
            case 3:
                System.out.print("Please enter your 10-digit account number: ");
                accountNumber = input.nextInt();
                accountIndex = -1;
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == accountNumber) {
                        accountIndex = i;
                        break;
                    }
                }
                if (accountIndex == -1) {
                    System.out.println(Line+"|");
                    System.out.println("Error: Account not found.");
                    break;
                }
                System.out.print("Please enter the amount you wish to withdraw: ");
                withdrawAmount = input.nextDouble();
                if (withdrawAmount > accountBalances[accountIndex]) {
                    System.out.println("Error: Insufficient funds.");
                    break;
                }
                accountBalances[accountIndex] -= withdrawAmount;
                System.out.println(Line+"|");
                System.out.println("          ----- Withdrawl successful! Your new Balance is: " + accountBalances[accountIndex] + " Petot -----");
                System.out.println(Line+"|");
                break;

            //Check Balance Panel
            case 4:
                System.out.print("Please enter your 10 - digit account number: ");
                accountNumber = input.nextInt();
                accountIndex = -1;
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == accountNumber) {
                        accountIndex = i;
                        break;
                    }
                }
                if (accountIndex == - 1) {
                    System.out.println(Line+"|");
                    System.out.println("Error: Account not found.");
                    break;
                }
                System.out.println(Line+"|");
                System.out.println("Your account balance is: " + accountBalances[accountIndex] + " Petot");
                System.out.println(Line+"|");
                break;

            //Exit panel
            case 5: 
                System.out.println("          ----- Thank you for using Banko Central ng STI. Have a beautiful day! ----- ");
                System.exit(0);
                break;
            default: System.out.println("Error: Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}