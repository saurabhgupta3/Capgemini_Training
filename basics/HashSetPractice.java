import java.util.*;

public class HashSetPractice {
    public static void main(String[] args) {
        Set<String> email = new HashSet<>();
        email.add("sggupta548@gmail.com");
        email.add("vpggupta92@gmail.com");
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("----SIGN UP----");
            System.out.println();
            System.out.print("Enter email: ");
            String newEmail = sc.nextLine();
            if(newEmail.equals("exit")) break;
            email.add(newEmail);
            for(String it : email) {
                System.out.println(it);
            }
        }
    }
}