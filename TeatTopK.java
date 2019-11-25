package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TeatTopK {
     class Pair implements Comparable<Pair>{
        public int num1;
        public int num2;
        public int sum;

         public Pair(int num1, int num2){
             this.num1 = num1;
             this.num2 = num2;
             this.sum = num1 + num2;
         }
        @Override
        public int compareTo(Pair o) {
            // this, other
            // 如果希望 this 在前 other 在后, 返回 < 0
            // 如果希望 this 在后 other 在前, 返回 > 0
            // 如果希望相等, 返回 0
            if (this.sum < o.sum) {
                return 1;
            }
            if (this.sum > o.sum) {
                return -1;
            }
            return 0;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
           List<List<Integer>> result  = new ArrayList<>();
           if(k < 1){
               return result;
           }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
           for(int i = 0; i < nums1.length && i < k; i++){
               for(int j = 0; j < nums2.length && j < k; j++){
                   queue.offer(new Pair(nums1[i], nums2[j]));
                   if(queue.size() > k){
                       queue.poll();
                   }
               }
           }
        while(!queue.isEmpty()){
            Pair tem = queue.poll();
            List<Integer> ans = new ArrayList<>();
            ans.add(tem.num1);
            ans.add(tem.num2);
            result.add(0,ans);
        }
        return result;
    }


}
