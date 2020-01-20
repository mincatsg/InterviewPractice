public class test9 {
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // System.arraycopy(nums2, 0, nums1, m, n);
        //  Arrays.sort(nums1);
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = (nums1[p1] > nums2[p2])? nums1[p1--]:nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1); //nums2 从0 开始 赋值到 nums1 从0 开始到 p2 + 1位置
    }
}
