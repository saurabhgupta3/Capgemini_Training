import java.util.Stack;

public class SortStackRecursion {

    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty())
            return;

        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
    }

    static void insertSorted(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int temp = st.pop();
        insertSorted(st, x);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        sortStack(st);

        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
    }
}
