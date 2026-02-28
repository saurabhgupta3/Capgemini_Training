import java.util.Scanner;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.nextLine();
        int cnt = 0;
        Boolean check = true;
        for(int i=0; i<str.length(); i++) {
            if(cnt < 0) {
                check = false;
                break;
            }
            if(str.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
        }
        if(cnt != 0) {
            check = false;
        }
        if(!check) {
            System.out.println("Not Valid");
        } else {
            System.out.println("Valid");
        }
    }
}