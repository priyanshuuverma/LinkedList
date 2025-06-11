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
  public static Node add2num(Node head1, Node head2){
    Node dummy  = new Node(-1,null,null);
    Node temp = dummy;
    int carry  = 0;
    while(head1 != null || head2 != null){
      int sum = 0;
      if(head1 != null) {
        sum += head1.data;
        head1 = head1.next;
      }
      if(head2 != null){
        sum += head2.data;
        head2 = head2.next;
      }
      sum = sum + carry;

      carry = sum / 10;
      Node newh = new Node(sum%10);
      temp.next = newh;
      temp = temp.next;
      
    }
    return dummy.next;
  }
  public static void printLL(Node temp){
    Node pre = temp;
    while(pre != null){
      System.out.print(pre.data + " ");
      pre = pre.next;
    }
    System.out.println();
  }
  public static Node changeLL(Node temp , int[] array){
    Node prev = temp;
    for(int i = 1; i< array.length; i++){
      Node newN = new Node(array[i], null, prev);
      prev.next = newN;
      prev = newN;
    }
    
    return temp;
  }
  public static void main(String[] args){
   int arr[] = {7,8,9,3,2,4,3};
   int nums[] = {5,6,4};
   Node head1 = new Node(arr[0]);
    Node head2 = new Node(nums[0]);
    head1 = changeLL(head1, arr);
    head2 = changeLL(head2, nums);
    printLL(head1);
    printLL(head2);
    printLL(add2num(head1,head2));
  }
}
