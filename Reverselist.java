package Map;

public class Reverselist {
    //反转一个单链表。
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode newhead = null;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                newhead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return newhead;
    }
}
