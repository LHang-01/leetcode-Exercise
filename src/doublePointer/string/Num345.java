package doublePointer.string;

import java.util.HashSet;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class Num345 {
    public static void main(String [] arrs){
        System.out.println(reverseVowels("aA"));
    }

    /**
     * 执行用时 : 7 ms, 在所有 java 提交中击败了61.78%的用户
     * 内存消耗 : 37.2 MB, 在所有 java 提交中击败了97.65%的用户
     *
     * 双指针
     */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        char temp;
        int i =0;
        int j= chars.length-1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while (i<j){
            if (set.contains(chars[i])&&set.contains(chars[j])){
                temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;
                i++;
                j--;
            } else if (set.contains(chars[i])){
                j--;
            }else if (set.contains(chars[j])){
                i++;
            }else {
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }
}
