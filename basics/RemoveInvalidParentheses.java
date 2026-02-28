public class RemoveInvalidParentheses {

    public static String removeInvalid(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            }
            else if (c == ')') {
                if (open > 0) {
                    open--;
                    sb.append(c);
                }
            }
            else {
                sb.append(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && open-- > 0)
                continue;
            res.append(c);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeInvalid("a)b(c)d"));
        System.out.println(removeInvalid("))(("));
        System.out.println(removeInvalid("(a(b(c)d)"));
    }
}
