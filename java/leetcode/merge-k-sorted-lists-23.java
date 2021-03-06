/**
 * Use merge sort to combine the k sorted lists.
 * The dividing part is already completed, so just perform the merge.
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0 ) return null;
    int length = lists.length;
    int index = 0;

    while (length > 1) {
      if (index >= length - 1) index = 0;
      ListNode a = lists[index];
      ListNode b = lists[index + 1];

      lists[index] = mergeTwoLists(a, b);
      lists[index + 1] = lists[length - 1];
      index += 2;
      length --;
    }

    return lists[0];
  }

  public ListNode mergeTwoLists(ListNode a, ListNode b) {
    ListNode temp = new ListNode(-1);
    ListNode clone = temp;

    while (a != null || b != null) {
      if (a == null) {
        temp.next = b;
        return clone.next;
      } else if (b == null) {
        temp.next = a;
        return clone.next;
      }
      int aVal = a == null ? Integer.MAX_VALUE : a.val;
      int bVal = b == null ? Integer.MAX_VALUE : b.val;
      temp.next = aVal >= bVal ? b : a;
      temp = temp.next;

      if (aVal < bVal) a = a == null ? a : a.next;
      else b = b == null ? b : b.next;
    }

    return clone.next;
  }
}

