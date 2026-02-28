import java.util.*;

public class ExpressionEvaluation {
    Stack<Integer> history = new Stack<>();

    boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(c);
            else if (c == ')') {
                if (st.isEmpty())
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }

    String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    res.append(s.charAt(i++));
                }
                res.append(' ');
                i--;
            } else if (c == '(')
                st.push(c);
            else if (c == ')') {
                while (st.peek() != '(')
                    res.append(st.pop()).append(' ');
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c))
                    res.append(st.pop()).append(' ');
                st.push(c);
            }
        }

        while (!st.isEmpty())
            res.append(st.pop()).append(' ');

        return res.toString();
    }

    int evaluatePostfix(String s) {
        Stack<Integer> st = new Stack<>();
        for (String token : s.split(" ")) {
            if (token.isEmpty())
                continue;

            if (Character.isDigit(token.charAt(0)))
                st.push(Integer.parseInt(token));
            else {
                int b = st.pop();
                int a = st.pop();
                if (token.equals("+"))
                    st.push(a + b);
                else if (token.equals("-"))
                    st.push(a - b);
                else if (token.equals("*"))
                    st.push(a * b);
                else
                    st.push(a / b);
            }
        }
        return st.pop();
    }

    int evaluate(String expr) {
        if (!isValid(expr))
            throw new RuntimeException("Invalid Expression");
        String postfix = infixToPostfix(expr);
        int result = evaluatePostfix(postfix);
        history.push(result);
        return result;
    }

    int undo() {
        if (!history.isEmpty())
            history.pop();
        return history.isEmpty() ? 0 : history.peek();
    }

    public static void main(String[] args) {
        ExpressionEvaluation engine = new ExpressionEvaluation();

        System.out.println(engine.evaluate("(10+5)*2")); 
        System.out.println(engine.undo()); 
    }
}
