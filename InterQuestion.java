package Map;

import java.util.*;

public class InterQuestion {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        public static int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int count = map.getOrDefault(nums[i], 0);
                map.put(nums[i], count + 1);
            }
            for (Integer key : map.keySet()) {
                Integer value = map.get(key);
                if (value == 1) {
                    return key;
                }
            }
            return 0;
        }

        //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
        //要求返回这个链表的深拷贝。
        public static Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            if (head == null) {
                return null;
            }
            for (Node cur = head; cur != null; cur = cur.next) {
                map.put(cur, new Node(cur.val, null, null));
            }
            for (Node cur = head; cur != null; cur = cur.next) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
            }

            return map.get(head);
        }

        //        给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
//        你想知道你拥有的石头中有多少是宝石。
//        J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
        public static int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < J.length(); i++) {
                set.add(J.charAt(i));
            }
            int count = 0;
            for (int j = 0; j < S.length(); j++) {
                if (set.contains(S.charAt(j))) {
                    count++;
                }
            }
            return count;
        }

        //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、
        // 以及实际被输入的文字，请你列出肯定坏掉的那些键。
        public static void BrokenKeyBoard() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                //接受输进来的字符
                String expected = scanner.next();  //预期打出来的
                String actual = scanner.next();   //实际打出来的

                //所以得把实际的存入一个set里，再用set去找预期的，那个找不到则就输出就是那个坏键。
                //因为最后要输出的是大写的，而且这题键坏了大小写都出不来，所以直接全改为大写，更加方便

                expected = expected.toUpperCase();
                actual = expected.toUpperCase();

                Set<Character> set = new HashSet<>();
                //将实际输出添加到哈希set里
                for (int i = 0; i < actual.length(); i++) {
                    char cur = actual.charAt(i);
                    if (!set.contains(cur)) {
                        set.add(cur);
                    }
                }
                //去对比实际值，看那个键为坏
                Set<Character> pint = new HashSet<>();  //去重复的
                for (int j = 0; j < expected.length(); j++) {
                    char cur = expected.charAt(j);
                    if (set.contains(cur)) {
                        continue;
                    }
                    if (pint.contains(cur)) {
                        continue;
                    }
                    System.out.print(cur);
                    pint.add(cur);
                }
            }
        }

        // 给一非空的单词列表，返回前 k 个出现次数最多的单词。
        //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
        public List<String> topKFrequent(String[] words, int k) {
            //1.将所以单词和他出现总次数存进hash表
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                int count = map.getOrDefault(words[i], 0);
                map.put(words[i], count + 1);
            }
            //2.将hash表所有的key值加到顺序表中，并自定制排序。
            List<String> result = new ArrayList<>(map.keySet());
            // 在 sort 方法的第二个参数中指定一个比较器对象
            // 来描述自定制比较规则(按出现次数来排序)
            Collections.sort(result, new MyComp(map));
            // subList 能够返回一个 List 中的一个子区间
            // [0, k) 前闭后开区间
            return result.subList(0, k);
        }

        class MyComp implements Comparator<String> {
            private Map<String, Integer> map = null;

            public MyComp(Map<String, Integer> map) {
                this.map = map;
            }

            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    // 就按字符串自身的大小来决定先后顺序
                    return o1.compareTo(o2);
                }
                // 降序排序写成 count2 - count1
                // 升序排序写成 count1 - count2
                return count2 - count1;
            }
        }
    }
}
