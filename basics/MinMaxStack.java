import java.util.*;

public class MinMaxStack {
    private Stack<Long> stack = new Stack<>();
    private long min;
    private long max;

    void push(long x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
            max = x;
        }
        else if (x < min) {
            stack.push(2 * x - min);
            min = x;
        }
        else if (x > max) {
            stack.push(2 * x - max);
            max = x;
        }
        else {
            stack.push(x);
        }
    }

    void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();

        if (top < min) {
            min = 2 * min - top;
        }
        else if (top > max) {
            max = 2 * max - top;
        }
    }

    long getMin() {
        return min;
    }

    long getMax() {
        return max;
    }
    public static void main(String[] args) {
        MinMaxStack st = new MinMaxStack();

        st.push(5);
        st.push(2);
        st.push(8);
        st.push(1);

        System.out.println(st.getMin()); 
        System.out.println(st.getMax()); 

        st.pop();
        System.out.println(st.getMin());
        System.out.println(st.getMax()); 
    }
}
