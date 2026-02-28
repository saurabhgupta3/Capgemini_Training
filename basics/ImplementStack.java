import java.util.Queue;
import java.util.LinkedList;

public class ImplementStack {

    static class StackCostlyPush {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            if (q1.isEmpty()) return -1;
            return q1.remove();
        }

        int top() {
            if (q1.isEmpty()) return -1;
            return q1.peek();
        }
    }

    static class StackCostlyPop {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q1.add(x);
        }

        int pop() {
            if (q1.isEmpty()) return -1;

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int popped = q1.remove();

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return popped;
        }

        int top() {
            if (q1.isEmpty()) return -1;

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int top = q1.peek();
            q2.add(q1.remove());

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }
    }

    public static void main(String[] args) {
        StackCostlyPush s1 = new StackCostlyPush();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(s1.top());
        System.out.println(s1.pop());

        StackCostlyPop s2 = new StackCostlyPop();
        s2.push(10);
        s2.push(20);
        s2.push(30);
        System.out.println(s2.top());
        System.out.println(s2.pop());
    }
}
