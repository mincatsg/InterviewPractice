package InterTrain3;

public class PalindromeList {
//    回文链表
//    请判断一个链表是否为回文链表。
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode cur = middle(head);
        ListNode prev = null;
        while(cur != null){   //反转链表
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode tem = head;
        while(prev != null){  //比较
            if(prev.val != tem.val){
                return false;
            }
            prev = prev.next;
            tem = tem.next;
        }
        return true;
    }
    public int size(ListNode head){
        ListNode cur;
        int len = 0;
        for(cur = head; cur != null; cur = cur.next){
            len++;
        }
        return len;
    }
    public ListNode middle(ListNode head){
        int i = 0;
        ListNode cur = head;
        int len = size(head)/2;
        while(i < len){   //找中间值
            cur = cur.next;
            i++;
        }
        return cur;
    }
}
