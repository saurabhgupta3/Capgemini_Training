import java.util.Scanner;
import java.util.*;

public class DecimalToBinary {
    public static void convert(int n) {
        Stack<Integer> st = new Stack<>();
        while(n > 0) {
            int rem = n % 2;
            st.push(rem);
            n /= 2;
        }
        System.out.print("Binary is : ");
        while(!st.isEmpty()) {
            System.out.print(st.peek());
            st.pop();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of tries: ");
        int n = Integer.parseInt(sc.nextLine());
        while(n != 0) {
            System.out.print("Enter the number: ");
            int num = Integer.parseInt(sc.nextLine());
            convert(num);
            n--;
        }
    }
}