package NKTest;

public class NFindKMax {

    //寻找第K大
    public void merge1(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int paraIndex = para(a, left, right);
        merge1(a, left, paraIndex - 1);
        merge1(a, paraIndex + 1, right);
    }
    public int para(int[] a, int left, int right){
        int index = right;
        int indexValue = a[right];
        while(left < index){
            while(left < index && a[left] <= indexValue){
                left++;
            }
            while(left < index && a[index] >= indexValue){
                index--;
            }
            swap(a, left, index);
        }
        swap(a, left, right);
        return left;
    }
    public void swap(int a[], int left, int right){
        int tem = a[left];
        a[left] = a[right];
        a[right] = tem;
    }
    public int findKth(int[] a, int n, int K) {
        merge1(a, 0, n - 1);
        return a[n - K];
    }
}
