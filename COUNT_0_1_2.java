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
  public static Node count012(Node head){
    int cnt0 = 0;
    int cnt1 = 0;
    int cnt2 =0;
    Node temp = head;
    while(temp != null){
      if(temp.data == 0){
        cnt0++;
      }
      if(temp.data == 1){
        cnt1++;
      }  
      if(temp.data == 2){
        cnt2++;
      }
      temp = temp.next;
    }
    temp = head;
    while(temp != null){
      if(cnt0 != 0){
        temp.data = 0;
        temp = temp.next;
        cnt0--;
      } else if(cnt1 != 0){
        temp.data = 1;
        temp = temp.next;
        cnt1--;
      } else{
        temp.data = 2;
        temp = temp.next;
        cnt2--;
      }
    }
    return head;
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
   List<Integer> arr = Arrays.asList(1,0,2,1,0,2,1,0,1,2,0,1,1,2,2,2);
   Node head1 = new Node(arr.get(0));
    head1 = changeLL(head1, arr);
    printLL(head1);
    printLL(count012(head1));
  }
}
// method second with best time 2(n) and above one was having 2(2n)
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
  public static Node count012(Node head){
  
    Node head0 = new Node(-1,null,null);;
    Node head1 = new Node(-1,null,null);;
    Node head2 = new Node(-1,null,null);;
    Node l0 = head0;
    Node l1 = head1;
    Node l2 = head2;
    Node temp = head;
    while(temp != null){
      if(temp.data == 0){
        l0.next = temp;
        l0 = temp;        
      } else if(temp.data == 1){
        l1.next = temp;
        l1 = temp;
      } else{
        l2.next = temp;
        l2 = temp;
      }
      temp = temp.next;
    }
    l0.next = (head1.next != null) ? (head1.next) : head2.next;
    l1.next = head2.next;
    l2.next = null;
    
       return head0.next;
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
   List<Integer> arr = Arrays.asList(1,0,2,1,0,2,1,0,1,2,0,1,1,2,2,2);
   Node head1 = new Node(arr.get(0));
    head1 = changeLL(head1, arr);
 
    printLL(count012(head1));
  }
}
