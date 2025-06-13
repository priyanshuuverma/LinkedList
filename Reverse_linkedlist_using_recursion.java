class Node{
  public int data;
  public Node next;
  public Node back;
  
  public Node(int data1, Node next1, Node back1){
    this.data = data1;
    this.next = next1;
    this.back = back1;
  }
  public Node(int data1){
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
    Node front = head.next;
    front.next = head;
    head.next = null;
    head.back = front;
    front.back = newHead;
    
    return  newHead;
    }
  public static void printLL(Node temp){
    Node pre = temp;
    while(pre != null){
      System.out.println( pre.back + " " + pre.next +  "  " + pre.data + " ");
      pre = pre.next;
    }
    System.out.println();
  }
  public static Node changeLL(Node temp , List<Integer> array){
    Node prev = temp;
    for(int i = 1; i< array.size(); i++){
      Node newN = new Node(array.get(i), null, prev);
      prev.next = newN;
      prev = newN;
    }
    
    return temp;
  }
  public static void main(String[] args){
   List<Integer> arr = Arrays.asList(1,2,3,4,5);
   Node head1 = new Node(arr.get(0));
    head1 = changeLL(head1, arr);
   
 printLL(reverse(head1));

  }
}
