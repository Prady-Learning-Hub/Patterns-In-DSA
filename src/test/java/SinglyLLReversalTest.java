import linkedlists.SinglyLLNode;
import linkedlists.SinglyLLReversal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLLReversalTest {

  @Test
  void testReverseLinkedList_WithEmptyList() {
    SinglyLLReversal reversal = new SinglyLLReversal();
    // Test case 1: Empty list
    assertNull(reversal.reverseLinkedList(null));
  }
  @Test
  void testReverseLinkedList_WithSingleNode() {
    SinglyLLReversal reversal = new SinglyLLReversal();
    SinglyLLNode singleNode = new SinglyLLNode(1);
    SinglyLLNode result = reversal.reverseLinkedList(singleNode);
    assertEquals(1, result.data);
    assertNull(result.next);
  }

  @Test
  void testReverseLinkedList_WithTwoNodes() {
    SinglyLLReversal reversal = new SinglyLLReversal();

    SinglyLLNode head = new SinglyLLNode(1);
    head.next = new SinglyLLNode(2);

    SinglyLLNode result = reversal.reverseLinkedList(head);

    assertEquals(2, result.data);
    assertEquals(1, result.next.data);
    assertNull(result.next.next);
  }

  @Test
  void testReverseLinkedList_WithMultipleNodes() {
    SinglyLLReversal reversal = new SinglyLLReversal();
    // Test case 3: Multiple nodes
    SinglyLLNode head = new SinglyLLNode(1);
    head.next = new SinglyLLNode(2);
    head.next.next = new SinglyLLNode(3);
    head.next.next.next = new SinglyLLNode(4);

    SinglyLLNode result = reversal.reverseLinkedList(head);

    // Check the reversed list
    assertEquals(4, result.data);
    assertEquals(3, result.next.data);
    assertEquals(2, result.next.next.data);
    assertEquals(1, result.next.next.next.data);
    assertNull(result.next.next.next.next);
  }
}