class Node{
  public int data;
  public Node next;
  public Node(data1, next1){
    this.data = data1;
    this.next = next1;
  }
  public Node(int data1){
    data = data1;
    next = null;
  }
}
class Main{
  public static Node insertele(Node head, int val){
     Node temp = new Node(val,head);
     return temp;
  }
  public static void printLL(Node head){
    while(head != null){
      System.out.print(head + " ");
      head = head.next;
    }
  }
  public static void main(String[] args){
    List<Integer> arr = Arrays.asList(12,3,4,5);
    int val = 44;
    Node head = new Node(arr.get(0));
    head.next = new Node(arr.get(1));
    head.next.next = new Node(arr.get(2));
    head.next.next.next = new Node(arr.get(3));
    
    head = insertele(head, val);
    printLL(head);
  }
}
