import java.util.*;

class Node {
    public int data;
    public Node next;
    public Node back;

    public Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

class Main {

    public static boolean isPalindrome(Node head) {
        Node temp = head;
        Stack<Integer> stk = new Stack<>();

        // Push all elements onto stack
        while (temp != null) {
            stk.push(temp.data);
            temp = temp.next;
        }

        // Compare from beginning again
        temp = head;
        while (temp != null) {
            int top = stk.pop();  // Safer than using peek + pop separately
            if (temp.data != top) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node changeLL(Node head, List<Integer> array) {
        Node prev = head;
        for (int i = 1; i < array.size(); i++) {
            Node newN = new Node(array.get(i), null, prev);
            prev.next = newN;
            prev = newN;
        }
        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 2, 1);  // Palindromic version
        Node head = new Node(arr.get(0));
        head = changeLL(head, arr);

        printLL(head);

        if (isPalindrome(head)) {
            System.out.println("Yes, it is a Palindromic LinkedList");
        } else {
            System.out.println("No, it is not a Palindromic LinkedList");
        }
    }
}
