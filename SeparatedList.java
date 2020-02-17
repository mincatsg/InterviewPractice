package InterviewTraining2;

public class SeparatedList {
//    分隔链表
//    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//    你应当保留两个分区中每个节点的初始相对位置。
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public ListNode partition(ListNode head, int x) {
    ListNode cur = head;
    ListNode small = new ListNode(0);
    ListNode smallTail = small;
    ListNode big = new ListNode(0);
    ListNode bigTail = big;
    while(cur != null){
        if(cur.val < x){
            small.next = new ListNode(cur.val);
            small = small.next;
        }
        else{
            big.next = new ListNode(cur.val);
            big = big.next;
        }
        cur = cur.next;
    }
    small.next = bigTail.next;
    return smallTail.next;
}
}
