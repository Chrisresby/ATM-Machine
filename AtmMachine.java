import java.util.Scanner;

public class AtmMachine {

    private static Scanner in;
    private static float balance = 0;
    private static int anotherTransaction;

    public static void main(String args[]){
        in = new Scanner(System.in);

        //Transaction Method
        transaction();
    }

    private static void transaction(){
        int choice;
        //Choose which action to take at ATM
        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");

        choice = in.nextInt();

        switch(choice){
            //Withdraw
            case 1:
                float amount;
                System.out.println("Please enter the amount you want to withdraw: ");
                amount = in.nextFloat();
                //When withdraw exceeds balance
                if(amount > balance || amount == 0){
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction();
                }
                else{
                    //Update Balance
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + "and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
            break;

            case 2:
                //Deposit
                float deposit;
                System.out.println("Please enter amount you wish to deposit: ");
                deposit = in.nextFloat();
                //Update the Balance
                balance = deposit + balance;
                System.out.println("You havae deposited " + deposit + " new balance is " + balance +"\n");
                anotherTransaction();
            break;

            case 3:
                //Check Balance
                System.out.println("Your balance is " + balance + "\n");
                anotherTransaction();
            break;

            default:
                System.out.println("Invalid option: \n\n");
                anotherTransaction();
            break;
        }
    }
    //Additional transactions
    private static void anotherTransaction(){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 to exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction();
        }
        else if (anotherTransaction == 2)
        {
            System.out.println("Thanks for choosing to bank with us.");
        }
        else
        {
            System.out.println("Invalid Choice\n\n");
            anotherTransaction();
        }
    }
}
