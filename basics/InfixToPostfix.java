import java.util.*;

public class InfixToPostfix {
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Enter number of tries: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            System.out.print("Enter infix expression: ");
            String exp = sc.nextLine();

            Stack<Character> st = new Stack<>();
            StringBuilder postfix = new StringBuilder();

            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);

                if (Character.isLetterOrDigit(ch)) {
                    postfix.append(ch);
                } else if (ch == '(') {
                    st.push(ch);
                } else if (ch == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        postfix.append(st.pop());
                    }
                    st.pop();
                } else {
                    while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                        postfix.append(st.pop());
                    }
                    st.push(ch);
                }
            }

            while (!st.isEmpty()) {
                postfix.append(st.pop());
            }

            System.out.println("Postfix expression: " + postfix);
        }
    }
}
