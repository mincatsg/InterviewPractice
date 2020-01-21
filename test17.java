public class test17 {
    //加一
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            ++digits[i];
            if(digits[i] % 10 == 0){
                digits[i] = 0;
            }
            else{
                return digits;
            }
        }
        int[] num = new int[digits.length + 1];
        num[0] = 1;
        for(int i = 0; i < digits.length; i++){
            num[i + 1] = 0;
        }
        return num;
    }
}

