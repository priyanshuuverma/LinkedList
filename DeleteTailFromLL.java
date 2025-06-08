class Node{
  public int data;
  public Node next;
  public Node(int data1, Node next1){
    this.data = data1;
    this.next = next1;
  }
  public Node(int data1){
    data = data1;
    next = null;
  }
}
class Main{
  private static Node removeTail(Node head){
   if(head.next == null || head == null) return null;
    Node temp = head;
    while(temp.next.next != null){
      temp = temp.next;
    }
    temp.next = null;
    return head;
  }
  private static void printLL(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
  public static void main(String[] args){
    List<Integer> arr = Arrays.asList(12,2,2,1);
    Node head = new Node(arr.get(0));
    head.next = new Node(arr.get(1));
    head.next.next = new Node(arr.get(2));
    head.next.next.next = new Node(arr.get(3));
    System.out.println(arr);
    head = removeTail(head);
    
    printLL(head);
  }
}
