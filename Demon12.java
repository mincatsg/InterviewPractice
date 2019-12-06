public class Demon12 {
//    比特位计数

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for(int i = 0; i <= num; i++){
            int count = 0;
            int value = i;
            while (value != 0){
                count++;
                value = value & (value - 1);
            }
            // for(int j = 0; j < 32; j++){   (2)
            //     if(((i >> j) & 1) == 1){
            //         count++;
            //     }
            // }
            // while (value != 0){    (3)
            // 	if (value % 2 == 1){
            // 		count++;
            // 	}
            // 	value = value / 2;
            // }
            arr[i] = count;
        }
        return arr;
    }
}
