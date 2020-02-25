import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class NSortLinked{
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public static Node creat(int m, String[] arr){
        Node head = new Node(Integer.parseInt(arr[0]));
        Node cur = head;
        for(int i = 1; i < m; i++){
            cur.next = new Node(Integer.parseInt(arr[i]));
            cur = cur.next;
        }
        return head;
    }
    public static Node sort(Node head1, Node head2){
        Node head = new Node(0);
        Node cur = head;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        cur.next = (head1 == null)? head2 : head1;
        return head.next;
    }
    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] num1 = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        String[] num2 = br.readLine().split(" ");
        Node head1 = creat(m, num1);
        Node head2 = creat(n, num2);
        Node head = sort(head1, head2);
        print(head);
    }
}