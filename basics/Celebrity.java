import java.util.*;


public class Celebrity {
    static int findCelebrity(int[][] M, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (M[a][b] == 1)
                st.push(b);
            else
                st.push(a);
        }

        int c = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != c) {
                if (M[c][i] == 1 || M[i][c] == 0)
                    return -1;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        int[][] M = {
            {0, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };

        int res = findCelebrity(M, 3);
        System.out.println(res);
    }
}

