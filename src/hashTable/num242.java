package hashTable;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class num242 {
    public static void main(String[] arrs){
        String s="anagram";
        String t= "nagaram";
        System.out.println(isAnagram(s,t));
    }

    /**
     * 执行用时 : 103 ms  , 在所有 java 提交中击败了 5.09%  的用户
     * 内存消耗 : 41.8 MB, 在所有 java 提交中击败了27.41% 的用户
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey("t"+s.charAt(i))){
                map.replace("t"+s.charAt(i),map.get("t"+s.charAt(i))-1);
            }else if (map.containsKey("s"+s.charAt(i))){
                map.replace("s"+s.charAt(i),map.get("s"+s.charAt(i))+1);
            }else {
                map.put("s"+s.charAt(i),1);
            }
            if (map.containsKey("s"+t.charAt(i))){
                map.replace("s"+t.charAt(i),map.get("s"+t.charAt(i))-1);
            }else if (map.containsKey("t"+t.charAt(i))){
                map.replace("t"+t.charAt(i),map.get("t"+t.charAt(i))+1);
            }else {
                map.put("t"+t.charAt(i),1);
            }
        }
        for (Integer var:map.values()){
            if (var!=0)
                return false;
        }
        return true;
    }


    public static boolean isAnagram1(String s, String t) {
        if (s.length()!=t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
            if (map.containsKey(t.charAt(i))){
                map.replace(t.charAt(i),map.get(t.charAt(i))-1);
            }else{
                map.put(t.charAt(i),-1);
            }
        }
        for (Integer var:map.values()){
            if (var!=0)
                return false;
        }
        return true;
    }

    /**
     * 执行用时 :7 ms, 在所有 java 提交中击败了59.09%的用户
     * 内存消耗 :36.9 MB, 在所有 java 提交中击败了96.06%的用户
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
