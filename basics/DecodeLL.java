class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList<T> {
    Node<T> head;
    int size = 0;

    void insertAtBeg(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

    void insertAtEnd(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
        size++;
    }

    void insertAtIndex(int index, T data) {
        if (index == 0) {
            insertAtBeg(data);
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        Node<T> node = new Node<>(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    T removeFromBeg() {
        T val = head.data;
        head = head.next;
        size--;
        return val;
    }

    T peek() {
        return head.data;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

class MyStack<T> {
    MyLinkedList<T> list = new MyLinkedList<>();

    void push(T data) {
        list.insertAtBeg(data);
    }

    T pop() {
        return list.removeFromBeg();
    }

    T peek() {
        return list.peek();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}

public class DecodeLL {

    public static String decode(String s) {

        MyStack<Integer> countStack = new MyStack<>();
        MyStack<StringBuilder> strStack = new MyStack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');

            } else if (c == '[') {
                countStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num = 0;

            } else if (c == ']') {
                int times = countStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < times; i++)
                    prev.append(curr);
                curr = prev;

            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("3[a2[b]]"));
        System.out.println(decode("2[x3[y]]"));
        System.out.println(decode("10[a]"));
    }
}

































// import java.util.*;

// public class Decode {
//     public static String decode(String s) {
//         Stack<Integer> countStack = new Stack<>();
//         Stack<StringBuilder> strStack = new Stack<>();

//         StringBuilder curr = new StringBuilder();
//         int num = 0;

//         for (char c : s.toCharArray()) {

//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0');
//             } else if (c == '[') {
//                 countStack.push(num);
//                 strStack.push(curr);
//                 curr = new StringBuilder();
//                 num = 0;
//             } else if (c == ']') {
//                 int times = countStack.pop();
//                 StringBuilder prev = strStack.pop();

//                 for (int i = 0; i < times; i++) {
//                     prev.append(curr);
//                 }
//                 curr = prev;
//             } else {
//                 curr.append(c);
//             }
//         }
//         return curr.toString();
//     }

//     public static void main(String[] args) {
//         System.out.println(decode("3[a2[b]]"));
//         System.out.println(decode("2[x3[y]]"));
//         System.out.println(decode("10[a]"));
//     }
// }
