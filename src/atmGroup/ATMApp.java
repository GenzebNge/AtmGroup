package atmGroup;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMApp {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Account> myAccounts = new ArrayList<>();
    static  double initBalance;

public static boolean validate(String accout, String pin){
    boolean result=false;
    for(int i =0; i<myAccounts.size();i++){
        if(accout.equals(myAccounts.get(i).getAccountNumber())&& pin.equals(myAccounts.get(i).getPin())){
            initBalance = myAccounts.get(i).getBalance();
            return result = true;
        }

    }
    return result;
}
    public static void main(String[] args) {

        // create an account like a database

        String addAccount;
        System.out.println("Let us creating Accounts ");
        
        do{
            Account account = new Account();
            System.out.println("Enter the account number ");
            String accNum = input.nextLine();
            account.setAccountNumber(accNum);
            System.out.println("Enter the pin");
            String pin1 = input.nextLine();
            account.setPin(pin1);
            System.out.println("Please Enter the initial balance ");
            double balance = input.nextDouble();
            account.setBalance(balance);
            input.nextLine();

            System.out.println("Do you want to enter again ");
            addAccount=input.nextLine();
            myAccounts.add(account);


        }while(addAccount.equalsIgnoreCase("yes"));

        System.out.printf("the accounts we created are %d \n", myAccounts.size());
        int count=0;

      boolean result;
        do{
            Account account1 = new Account();
            System.out.println("Enter your account number !");
            String accountnum = input.nextLine();
            account1.setAccountNumber(accountnum);
            System.out.println("Enter the pin ");
            String pin = input.nextLine();
            account1.setPin(pin);

            // checking the its validation

          result = validate(account1.getAccountNumber(), account1.getPin());
           if (result ){
               System.out.println("the initial balance "+ initBalance);
               performAtm();
               System.out.println("Thank you for using our services, Good Bye!");
           }else {
               System.out.println("you put wrong pin and account number try again !");
           }

            count++;
        }while(count<3 && !result);

        // lock the user if there was more than 3 atemp

        if(count==3){
            System.out.println("Your Account is Locked! \nContact customer Service  ");
        }


    }

    private static void performAtm() {

        System.out.println("Please Select the type of service \n1. Deposit \n2. Withdraw \n3. Check Balance ");
        int choice = input.nextInt();
        if(choice ==1){
            System.out.println("Enter the amount you want to deposit");
            double amount = input.nextDouble();
            initBalance=initBalance+amount;
            System.out.println("your new balance is "+ initBalance);
        }
        else if(choice ==2){
            System.out.println("Enter the amount you want to withdraw");
            double withdraw = input.nextDouble();
            if(withdraw>initBalance){
                System.out.println("You have no enough balance please  try again !!");
            }
            else{
                initBalance=initBalance-withdraw;
                System.out.println("you have withdrawn "+ withdraw +" your new balance is "+initBalance);
            }

        }
        else if(choice ==3){
            System.out.println("your account balance is "+ initBalance);
        }
        else{
            System.out.println("you have selected wrong choice ! No more option ");
        }


    }
}
