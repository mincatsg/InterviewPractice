package InterviewTraining2;

public class TwoAdd {
//    两数相加
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
//    并且它们的每个节点只能存储 一位 数字。
//
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(1);
    ListNode l3 = node;
    int tem = 0;
    while(l1 != null || l2 != null){
        int x = (l1 == null)? 0:l1.val;
        int y = (l2 == null)? 0:l2.val;
        int sum = x + y + tem;
        tem = sum / 10;
        l3.next = new ListNode(sum % 10);
        l3 = l3.next;
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }
    if(tem > 0){
        l3.next = new ListNode(tem);
    }
    return node.next;
}
}
