package InterviewTraining2;

public class Minimumoverwrite{

   // 最小覆盖子串
  public List<Integer> findAnagrams(String s, String p) {
         int left = 0;
       int right = 0;
       Map<Character, Integer> needs = new HashMap<>();  //保存T字符串
       Map<Character, Integer> windows = new HashMap<>(); //去滑动S字符串,找到T字符串所有的停止.
       List<Integer> res = new ArrayList<>();

     //遍历t字符串,存到needs里
      for(int i = 0; i < p.length(); i++){
          char c = p.charAt(i);
          int count = needs.getOrDefault(c, 0) + 1;
          needs.put(c, count);
      }

      int match = 0; // 看s到哪找到了所有T字符串的数量

      while(right < s.length()){

          char c = s.charAt(right);
          if(needs.containsKey(c)){
              //加到window窗口里
              int count = windows.getOrDefault(c, 0) + 1;
              windows.put(c, count);
              if(count == needs.get(c)){
                  match++;
              }
          }
            right++;  //窗口继续往后
          

          //说明窗口已经包含了所有t的字符,先统计长度,再输出.
          while(match == needs.size()){
               if(right - left == p.length()){
                   res.add(left);
               }
               char mm = s.charAt(left);
               //看删掉的字符是否为needs里包含的
               if(needs.containsKey(mm)){
               int count = windows.get(mm) - 1;
                windows.put(mm, count);
         //看删掉包含的字符之后是否这个窗口不满足了
                  if(needs.get(mm) > count){
                      match--;
                  }
               }
               left++;
          }
      }

        return res;
    }
}