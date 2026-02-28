import java.util.Scanner;
public class Atm {
    public static void main(String[] args) {
        int totalBalance = 33000;
        int pin = 2344;
        while(true) {
            System.out.println("click 1 for deposit, 2 for withdrawl, 3 for check balance, 4 for change pin, 5 for quick withdrawl");
            System.out.println("enter 0 for exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice == 0) break;
            System.out.println("enter pin: ");
            int enteredPin = sc.nextInt();
            if(pin != enteredPin) {
                System.out.println("you entered wrong pin, you cannot proceed");
                break;
            }
            switch(choice) {
                case 1 : {
                    System.out.println("Enter the amount for deposit");
                    int amt = sc.nextInt();
                    totalBalance += amt;
                    System.out.println("your amount successfully deposited");
                    System.out.println("your current balance is : " + totalBalance);
                    break;
                }
                case 2: {
                    System.out.println("enter the amount for withdrawal: ");
                    int amt = sc.nextInt();
                    if(amt > totalBalance) {
                        System.out.println("you have not enough balance");
                        break;
                    }
                    totalBalance -= amt;
                    System.out.println("your amount successfully withdrawl");
                    System.out.println("your current balance is : " + totalBalance);
                    break;
                }
                case 3 : {
                    System.out.println("Your balance is : " + totalBalance);
                    break;
                }
                case 4 : {
                    System.out.println("enter new pin: ");
                    int newpin = sc.nextInt();
                    if(newpin < 1000 || newpin > 9999) {
                        System.out.println("please enter 4 digit new pin ");
                        break;
                    }
                    pin = newpin;
                    System.out.println("your pin successfully changed");
                    break;
                } 
                case 5: {
                    System.out.println("Enter the amoount for quick withdrawl (only 100, 200, 500, 2000): ");
                    
                    int amt = sc.nextInt();
                    if(amt > totalBalance) {
                        System.out.println("you have not enough balance");
                        break;
                    }
                    if(amt == 100 || amt == 200 || amt == 500 || amt == 2000) {
                        totalBalance -= amt;
                        System.out.println("your amount successfully withdrawl");
                        System.out.println("your current balance is : " + totalBalance);
                    } else {
                        System.out.println("Try again, incorrect input");
                    }
                    
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
        

    }
}
