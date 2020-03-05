package stringtrain;

import java.util.HashSet;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例: s = "leetcode" 返回 0.
 * s = "loveleetcode", 返回 2
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Num387 {

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 91.23% 的用户
     * 内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 5.01% 的用户
     */
    public int firstUniqChar1(String s) {
        int[] ints = new int[26];
        for (char c : s.toCharArray()){
            ints[c-'a']+=1;
        }
        for (int i = 0 ;i<s.length();i++){
            if (ints[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行用时 : 51 ms, 在所有 java 提交中击败了44.35%的用户
     * 内存消耗 : 37.5 MB, 在所有 java 提交中击败了94.29%的用户
     */
    public int firstUniqChar(String s) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i= 0;i<s.length();i++){
            if (set1.contains(s.charAt(i))){
                //set2存重复元素
                set2.add(s.charAt(i));
            }else {
                set1.add(s.charAt(i));
            }
        }
        for (int i= 0;i<s.length();i++){
            if (!set2.contains(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

}
