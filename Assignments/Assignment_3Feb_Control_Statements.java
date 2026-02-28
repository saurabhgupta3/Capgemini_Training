package capgemeini_training;

import java.util.Scanner;

public class Assignment_3Feb_Control_Statements {
    public static void main(String[] args) {
        //WAP to ATM m/c -deposit, withdrawal, check balance, change pin, quick withdrawal using loops and control statements
        try(Scanner sc=new Scanner(System.in)) {
            int balance=10000;
            int pin=1111;
            System.out.println("Enter your pin:");
            int enterPin=sc.nextInt();
            if(enterPin==pin)
                while(true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Change Pin");
                    System.out.println("5. Quick Withdrawal");
                    int choice=sc.nextInt();
           switch(choice){
            case 1: 
            System.out.println("Enter amount to deposit:");
            int depositAmount=sc.nextInt();
            balance+=depositAmount;
            System.out.println(" New balance: "+balance);
break;
case 2: System.out.println("Enter amount to withdraw:");
            int withdrawAmount=sc.nextInt();
            if(withdrawAmount<=balance) {
                balance-=withdrawAmount;
                System.out.println(" New balance: "+balance);
            } else {
                System.out.println("not sufficient balance.");
            }
            break;
case 3: System.out.println("current balance: "+balance);
            break;
case 4:
            System.out.println("enter your old pin");
            int oldPin=sc.nextInt();
            if(oldPin==pin){
                System.out.println("enter your new pin:");
                int newPin=sc.nextInt();
                pin=newPin;
                System.out.println("pin changed");
            } else {
                System.out.println("incorrect old pin.");
            }
            break;
case 5: 
            System.out.println("Enter amount less than 5000 for qucik withdrawal: ");
            int quickWithdraw=sc.nextInt();
            if(quickWithdraw<5000&&quickWithdraw<=balance){
                balance-=quickWithdraw;
                System.out.println(" new balance: "+balance);
            } else {
                System.out.println("Enter amt less than 5000: ");
            }
            break;
           default:
            System.out.println("Enter 1 to 5 only");
            break;
            

        }    
       
                }
                else{
                    System.out.println("incorrect pin");
                }
        }
    }
}
    