public class bubblesort {
    public static void bubbleSort(int[] array){  //冒泡排序  升序
        for(int bound = 0; bound < array.length; bound++){
            //（bound,arr.length) 未排序
            // [0,bound) 已排序组合
            for(int cur = array.length - 1; cur > bound; cur--){
                if(array[cur] < array[cur - 1]){
                    swap(array, cur, cur - 1);
                }
            }
        }
    }
    public static void swap(int[] array, int left, int right){
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
}
