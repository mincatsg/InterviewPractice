package NKTest;

public class NTwoAdd2 {

}
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        int tem = 0; //进位
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(a != null || b != null){
            int x = (a == null)? 0 : a.val;
            int y = (b == null)? 0 : b.val;
            int sum = x + y + tem;
            cur.next = new ListNode(sum % 10);
            tem = sum / 10;
            cur = cur.next;
            if(a != null) a = a.next;
            if(b != null)  b = b.next;
        }
        if(tem != 0){
            cur.next = new ListNode(tem);
        }
        return head.next;
    }
}
