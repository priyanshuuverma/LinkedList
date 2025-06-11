class Node{
  public int data;
  public Node next;
  public Node back;
  
  public Node(int data1, Node next1, Node back1){
    this.data = data1;
    this.next = next1;
    this.back = back1;
  }
  public Node(int data){
    this.data = data;
    this.next = null;
    this.back = null;
  }
}
class Main {
  public static Node oddeven(Node head1){
   List<Integer> arr = new ArrayList<>();
        Node temp = head1;
     while (temp != null && temp.next != null) {
            arr.add(temp.data); // Odd positions
            temp = temp.next.next;
        }
        if (temp != null) arr.add(temp.data); // Add last odd if exists
 temp = head1.next;
        while (temp != null && temp.next != null) {
            arr.add(temp.data); // Even positions
            temp = temp.next.next;
        }
        if (temp != null) arr.add(temp.data); // Add last node if odd length

       
       
  return changeLL(head1, arr);
    
  }
  public static void printLL(Node temp){
    Node pre = temp;
    while(pre != null){
      System.out.print(pre.data + " ");
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
   List<Integer> arr = Arrays.asList(4, 5, 3, 8);
   Node head1 = new Node(arr.get(0));
    head1 = changeLL(head1, arr);
    printLL(head1);
    printLL(oddeven(head1));
  }
}
