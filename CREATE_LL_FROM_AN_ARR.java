class Node{
  public int data;
  public Node next;
  public Node(int data1, Node next1){
    this.data = data1;
    this.next = next1;
  }
  public Node(int data1){
    this.data = data1;
    this.next = null;
  }
}
public class Main {
    public static void printLL(Node head){
      while(head != null){
        System.out.print(head.data +" "+ head.next + " ");
        head = head.next;
      }
    }
    public static Node chnagetoLL(int[] arr){
      Node head = new Node(arr[0]);
      Node mover = head;
      for(int i=1; i<arr.length; i++){
        Node temp = new Node(arr[i]);
        mover.next = temp;
        mover = temp;
        
      }
      return head;
    }
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6};
      System.out.println(Arrays.toString(arr));
       printLL(chnagetoLL(arr));
    }
}
