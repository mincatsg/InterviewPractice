public class shellsort {
    public static void shellSort(int[] array){   //希尔排序
        int gap = array.length;
        while(gap > 1){
            insertSortGap(array, gap);
            gap /= 3;
        }
        insertSortGap(array, 1);
    }
    public static void insertSortGap(int[] array, int gap){
        for(int bound = gap; bound < array.length; bound++){
            int tem = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur = cur - gap){
                if(tem < array[cur]){
                    array[cur + gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + gap] = tem;
        }
    }
}
