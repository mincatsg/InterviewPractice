import java.util.Stack;

public class quicksort {
    public static void quickSort(int[] array) {  //递归实现快速排序
        quickSortInternal(array, 0, array.length - 1);
    }

    public static  void quickSortInternal(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        // 最简单的选择基准值的方式，选择 array[right] 作为基准值
        // pivotIndex 代表基准值最终停留的下标
        int pivotIndex = partition(array, left, right);
        // [left, pivotIndex - 1] 都是小于等于基准值的
        // [pivotIndex + 1, right] 都是大于等于基准值的
        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex + 1, right);
    }
    public static int partition(int[] array, int left, int right){
        int baseIndex = right;
        int baseValue = array[baseIndex];
        while(left < baseIndex){
            while(left < baseIndex && array[left] <= baseValue){
                left++;
            }
            while(left < baseIndex && baseValue <= array[baseIndex]){
                baseIndex--;
            }
            swap(array, left, baseIndex);
        }
        swap(array, right, left);
        return left;
    }

    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                continue;
            }
            int pivotIndex = partition(array,left,right);

            //左半部分进栈
            stack.push(pivotIndex - 1);
            stack.push(left);

            //右半部分进栈
            stack.push(right);
            stack.push(pivotIndex + 1);
        }

    }
    public static void swap(int[] array, int left, int right){
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
}
