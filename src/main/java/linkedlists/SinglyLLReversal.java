package linkedlists;

public class SinglyLLReversal {
  public SinglyLLNode reverseLinkedList(SinglyLLNode head){
    SinglyLLNode prev = null;
    SinglyLLNode current = head;
    SinglyLLNode next ;

    while(current != null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public SinglyLLNode reverseLinkedListRecursive(SinglyLLNode head){
    if(head == null || head.next == null){
      return head;
    }
    SinglyLLNode reversedHead = reverseLinkedListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return reversedHead;
  }
}


