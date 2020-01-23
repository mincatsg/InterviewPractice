public class selectsort {
    public static void selectSort(int[] array) { //直接选择排序
        for (int bound = 0; bound < array.length; bound++) {
            int cur = bound + 1;
            for (; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tem = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tem;
                }
            }
        }
    }
}
