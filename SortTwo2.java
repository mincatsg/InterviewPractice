package InterviewTraining2;

public class SortTwo2 {
//    合并两个有序链表
//    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null)? l2:l1;
        return l3.next;
    }
}
