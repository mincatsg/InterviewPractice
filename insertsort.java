
public class insertsort {

    public static void insertSort(int[] array) { //插入排序 升序为例
        //就是将待排序元素在已排好序的元素中找，比自己大的就将大的后移，小的就将自已放到小的后面。
        for (int bound = 1; bound < array.length; bound++) {
            // (bound, size)待排序数组
            // [0, bound)已排序数组
            int tem = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (tem < array[cur]) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tem;
        }
    }
}

