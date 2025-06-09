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
  public static Node reverseDLL(Node head) {
    if (head == null) return null;

    Node temp = head;
    Node newHead = null;

    while (temp != null) {
      // Swap next and back
      Node forward = temp.next;
      temp.next = temp.back;
      temp.back = forward;

      // After swap, prev node becomes the next, so move "backward"
      newHead = temp;
      temp = forward;
    }

    return newHead; // new head of the reversed list
  }

  public static void printLL(Node head) {
    int cnt = 0;
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
      cnt++;
    }
    System.out.println();
    System.out.println("Length of the Linked List is: " + cnt);
  }

  public static Node changeToLL(int[] arr) {
    Node head = new Node(arr[0], null, null);
    Node prev = head;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i], null, prev);
      prev.next = temp;
      prev = temp;
    }
    return head;
  }

  public static void main(String[] args) {
    int[] arr = {3, 4, 5, 6, 7, 8, 9, 9, 0};
    System.out.println(Arrays.toString(arr));
    Node head = changeToLL(arr);
    head = reverseDLL(head);
    printLL(head);
  }
}
