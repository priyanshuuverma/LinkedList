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
    public static Node reverse(Node head){
      if(head == null || head.next == null){
        return head;
      }
      Node newHead = reverse(head.next);
      Node first = head.next ;
      first.next = head;
      head.next = null;
      
      return newHead;
    }
    public static boolean isPalindrome(Node head) {
       Node slow = head;
       Node fast = head;
      
      while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
        
      }
      Node newHead = reverse(slow.next);
      Node first = head;
      Node second = newHead;
      while(second != null ){
        if(first.data != second.data){
          reverse(newHead);
          return false;
        }
        first = first.next;
        second = second.next;
      }
      reverse(newHead);
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
