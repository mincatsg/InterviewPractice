public class test12 {
//    你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
//    你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

    public boolean isLongPressedName(String name, String typed) {
        int m = 0; //name的位置
        for(int i = 0; i < typed.length(); i++){
            if(name.charAt(m) == typed.charAt(i)){
                m++;
            }
            if(m == name.length()){
                break;
            }
        }
        return ((m == name.length())? true:false);
    }
}
