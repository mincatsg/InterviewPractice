package InterTrain3;

public class MiddleLinked {
//    链表的中间结点
//    给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//
//    如果有两个中间结点，则返回第二个中间结点。

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int middle = size(head) / 2;
        for(int i = 0; i < middle; i++){
            cur = cur.next;
        }
        return cur;
    }
    public int size(ListNode head){
        int size = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
