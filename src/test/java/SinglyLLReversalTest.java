import linkedlists.SinglyLLNode;
import linkedlists.SinglyLLReversal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLLReversalTest {
  private SinglyLLReversal reversal;
  @BeforeEach
  void setUp() {
    reversal = new SinglyLLReversal();
  }

  @Test
  void testReverseLinkedList_WithEmptyList() {
    // Test case 1: Empty list
    assertNull(reversal.reverseLinkedList(null));
  }
  @Test
  void testReverseLinkedList_WithSingleNode() {
    SinglyLLNode singleNode = new SinglyLLNode(1);
    SinglyLLNode result = reversal.reverseLinkedList(singleNode);
    assertEquals(1, result.data);
    assertNull(result.next);
  }

  @Test
  void testReverseLinkedList_WithTwoNodes() {

    SinglyLLNode head = new SinglyLLNode(1);
    head.next = new SinglyLLNode(2);

    SinglyLLNode result = reversal.reverseLinkedList(head);

    assertEquals(2, result.data);
    assertEquals(1, result.next.data);
    assertNull(result.next.next);
  }

  @Test
  void testReverseLinkedList_WithMultipleNodes() {
   reversal = new SinglyLLReversal();
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

  @Test
  void testReverseLinkedListRecursive_NullInput() {
    assertNull(reversal.reverseLinkedListRecursive(null));
  }

  @Test
  void testReverseLinkedListRecursive_SingleNode() {
    SinglyLLNode head = new SinglyLLNode(1);
    SinglyLLNode result = reversal.reverseLinkedListRecursive(head);
    assertEquals(1, result.data);
    assertNull(result.next);
  }

  @Test
  void testReverseLinkedListRecursive_TwoNodes() {
    SinglyLLNode head = createLinkedList(1, 2);
    SinglyLLNode result = reversal.reverseLinkedListRecursive(head);
    assertLinkedListEquals(createLinkedList(2, 1), result);
  }

  @Test
  void testReverseLinkedListRecursive_MultipleNodes() {
    SinglyLLNode head = createLinkedList(1, 2, 3, 4, 5);
    SinglyLLNode result = reversal.reverseLinkedListRecursive(head);
    assertLinkedListEquals(createLinkedList(5, 4, 3, 2, 1), result);
  }

  @Test
  void testReverseLinkedListRecursive_LargeList() {
    SinglyLLNode head = createLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    SinglyLLNode result = reversal.reverseLinkedListRecursive(head);
    assertLinkedListEquals(createLinkedList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), result);
  }

  private SinglyLLNode createLinkedList(int... values) {
    SinglyLLNode dummy = new SinglyLLNode(0);
    SinglyLLNode current = dummy;
    for (int value : values) {
      current.next = new SinglyLLNode(value);
      current = current.next;
    }
    return dummy.next;
  }

  private void assertLinkedListEquals(SinglyLLNode expected, SinglyLLNode actual) {
    while (expected != null && actual != null) {
      assertEquals(expected.data, actual.data);
      expected = expected.next;
      actual = actual.next;
    }
    assertNull(expected);
    assertNull(actual);
  }
}