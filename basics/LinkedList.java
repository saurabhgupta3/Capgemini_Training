class Node {
    int data;
    Node next = null;
    Node(int data) {
        this.data = data;
    }
}



public class LinkedList {
    public static void insertLast(int newData, Node head) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(newData);
    }
    public static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
    public static void main(String[] args) {
        Node head = new Node(10);
        insertLast(20, head);
        insertLast(30, head);
        insertLast(40, head);
        display(head);
        head = reverse(head);
        System.out.println("after reversing : ");
        display(head);
    }
}