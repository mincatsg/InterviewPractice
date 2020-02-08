package InterviewTraining;

public class SortList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
//    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
   public ListNode sortList(ListNode head) {
    if(head == null || head.next == null){
        return head;
    }
    //找中间结点
    ListNode slow = head;
    ListNode fast = head.next;

        while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }

    ListNode right = slow.next;
    slow.next = null;
    ListNode left = sortList(head);
    ListNode next = sortList(right);

        return memgr(left, next);

}

    public ListNode memgr(ListNode left, ListNode next){
        ListNode start = new ListNode(-1);
        ListNode cur = start;

        while(left != null && next != null){
            if(left.val <= next.val){
                cur.next = new ListNode(left.val);
                cur = cur.next;
                left = left.next;
            }else{
                cur.next = new ListNode(next.val);
                cur = cur.next;
                next = next.next;
            }
        }
        if(left != null){
            cur.next = left;
        }
        if(next != null){
            cur.next = next;
        }
        return start.next;
    }
}
