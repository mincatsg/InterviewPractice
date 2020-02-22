package InterTrain3;

public class CrossLinked {
//    相交链表
//    编写一个程序，找到两个单链表相交的起始节点。
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = size(headA);
        int lenB = size(headB);
        if(lenA >lenB){
            int len = lenA - lenB;
            while(len > 0){
                headA = headA.next;
                len--;
            }
        }
        if(lenB > lenA) {
            int len = lenB - lenA;
            while(len > 0){
                headB = headB.next;
                len--;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int size(ListNode head){
        int size = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
