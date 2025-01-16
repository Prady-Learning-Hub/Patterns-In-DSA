package linkedlists;

public class SinglyLLReversal {
  public SinglyLLNode reverseLinkedList(SinglyLLNode head){
    SinglyLLNode prev = null;
    SinglyLLNode current = head;
    SinglyLLNode next = null;

    while(current != null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
