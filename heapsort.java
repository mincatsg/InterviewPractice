public class heapsort {
    public static void heapSort(int[] array){  //堆排序
        creatHeap(array);
        for(int i = 0; i < array.length; i++){
            swap(array, 0, array.length - 1 - i);
            shiftDown(array,array.length - i - 1, 0);
        }
    }
    public static void creatHeap(int[] array){  //建堆
        for(int cur = (array.length - 1 - 1) / 2; cur >= 0; cur-- ){
            shiftDown(array,array.length,cur);
        }
    }
    public static void shiftDown(int[] array,int size, int index){ //向下调整
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 < size && child + 1 > child){
                child = child + 1;
            }
            if(array[parent] < array[child]){
                swap(array, parent, child);
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

}
