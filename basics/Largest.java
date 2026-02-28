import java.util.*;


public class Largest {
    public static int largestRectangle(int[] h) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = h.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : h[i];

            while (!st.isEmpty() && curr < h[st.peek()]) {
                int height = h[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangle(arr));
    }
}


