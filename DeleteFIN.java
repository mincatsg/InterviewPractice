package InterviewTraining2;

public class DeleteFIN {
//    删除链表的倒数第N个节点
//    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode cur = head;
    int tem = size(head) - n;
    if(tem == 0){
        head = head.next;
        return head;
    }
    for(int i = 0; i < tem - 1; i++){
        cur = cur.next;
    }
    cur.next = cur.next.next;
    return head;
}
    public int size(ListNode head){
        int size = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
