public class mergesort {
    public static void mergeSort(int[] array){  //归并排序
        mergeSortHelper(array, 0, array.length);
    }

    public static void mergeSortHelper(int[] array, int left, int right){
        if(left >= right || right - left == 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        mergr(array, left, mid, right);
    }

    public static void mergr(int[] array, int left, int mid, int right){
        int length = right - left;
        int[] output = new int[length];
        int outputIndex = 0;
        int i = left;
        int j = mid;
        while(i < mid && j < right){
            if (array[i] <= array[j]) {
                // i 对应的元素比 j 小
                // 就把 i 对应的元素插入到 output 末尾
                output[outputIndex++] = array[i++];
            } else {
                output[outputIndex++] = array[j++];
            }
        }

        while(i < mid){
            output[outputIndex++] = array[i++];
        }
        while(j < right){
            output[outputIndex++] = array[j++];
        }

        for(int k = 0; k < length; k++){
            array[left + k] = output[k];
        }
    }
}
