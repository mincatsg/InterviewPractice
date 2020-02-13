package Sort;

import javax.naming.PartialResultException;

public class SortTwo {

    public static void insert(int[] array){
        for(int i = 1; i < array.length; i++){
            int tem = array[i];
            int bound = i - 1;
            for(;bound >= 0; bound--){
                if(tem < array[bound]) {
                    array[bound + 1] = array[bound];
                }else{
                    break;
                }
            }
            array[bound + 1] = tem;
        }
    }

    public static void shellsort(int[] array){
        int gap = array.length;
        while(gap > 1){
            insertSortGap(array, gap);
            gap /= 3;
        }
        insertSortGap(array, 1);
    }

    public static void insertSortGap(int[] array, int gap){
        for(int i = 0; i < array.length; i++){
            int tem = array[i];
            int bound = i - gap;
            for(;bound >= 0; bound = bound - gap){
                if(array[bound] > tem){
                    array[bound + gap] = array[bound];
                 } else{
                    break;
                }
            }
            array[bound + gap]  = tem;
        }
    }
    public static void selectsort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){  //小了就交换
                    swap(array, i, j);
                }
            }
        }
    }

    public  static void heapsort(int[] array){
        //先建堆, 大堆升序  小堆降序
        creatheap(array);
        for(int i = 0; i < array.length; i++){
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, array.length - 1 -i, 0);
        }
    }
    public static void creatheap(int[] array){
        for(int i = (array.length - 1 - 1) / 2; i >= 0; i--){
            shiftDown(array, array.length, i);
        }
    }

    public static void shiftDown(int[] array, int size, int index){
        int parent = index;
        int child = 2 * index + 1;
        while(child < size){
            if(child + 1 < size && array[child + 1] > array[child]){
                  child = child + 1;
            }
            if(array[child] > array[parent]){
                swap(array, child, parent);
            }

            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void swap(int[] array, int left, int right){
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }

    public static void bubbleSort(int[] array) {  //冒泡排序  升序
        for (int i = 0; i < array.length; i++){
            for(int j = array.length - 1; j > 0; j--){
                if(array[j] < array[j - 1]){
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(int[] array) {  //递归实现快速排序
        quickSortInternal(array, 0, array.length - 1);
    }

    public static  void quickSortInternal(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int pivotIndex = partition(array, left, right);
        // [left, pivotIndex - 1] 都是小于等于基准值的
        // [pivotIndex + 1, right] 都是大于等于基准值的
        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex + 1, right);
    }

    public static int partition(int[] array, int left, int right){
        int basevalue = right;
        int value = array[basevalue];
        while(left < basevalue){
            while(left < basevalue && array[left] <= value){
                left++;
            }
            while(left < basevalue && array[basevalue] >= value){
                basevalue--;
            }
            swap(array, left, basevalue);
        }
        swap(array, right, left);
        return left;
    }
}
