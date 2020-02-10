package InterviewTraining;

public class DeleteDuplicateNodes {
//    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
    
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode slow = cur;
        ListNode fast = head;
        while(fast != null){
            if(fast.next == null  ||  fast.next.val != fast.val){
                if(slow.next == fast){
                    slow = slow.next;
                }else{
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return cur.next;
    }
}
