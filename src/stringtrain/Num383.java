package stringtrain;

import java.util.Arrays;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Num383 {
    public static void main(String [] arrs){
        System.out.println(canConstruct1("a","b"));
    }

    /**
     * 大牛：空间换时间
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.6 MB  , 在所有 Java 提交中击败了 5.16% 的用户
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        //1.判定magazine的长度是否小于ransom，如果小于那么一定是false
        if (magazine.length() < ransomNote.length()) return false;
        //2.在caps中保存的并非是magazine中每类字母的个数,而是在对应当前字符c的magazine中每类字母应该遍历的起始位置，
        // 如果index == -1则表示在magazine中从caps指定的遍历位置开始没有找到一样的字符，则输出false；
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }

    /**
     * 执行用时 :8 ms, 在所有 java 提交中击败了51.50%的用户
     * 内存消耗 :37.9 MB, 在所有 java 提交中击败了95.48%的用户
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        for (int i=0;i<ransomNote.length();i++){
            char r = ransomNote.charAt(i);
            int j ;
            for (j=0;j<magazine.length();j++){
                if (chars[j]==r){
                    chars[j]='0';
                    break;
                }
            }
            if (j==magazine.length()){
                return false;
            }
        }
        return true;
    }


    /**
     * 执行用时 : 10 ms, 在所有 java 提交中击败了45.59%的用户
     * 内存消耗 : 38 MB , 在所有 java 提交中击败了95.48%的用户
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int j=0;
        int i;
        for (i=0;i<chars1.length;i++){
            int count1 =0;
            int count2 =0;
            while ((i+1 < chars1.length) && (chars1[i + 1] == chars1[i])){
                i++;
                count1++;
            }
            while ((j < chars2.length) && (chars2[j]!= chars1[i])){
                j++;
            }
            if (j >= chars2.length){
                return false;
            }
            while ((j+1 < chars2.length) && (chars2[j + 1] == chars2[j])){
                j++;
                count2++;
            }
            if (count2<count1){
                return false;
            }
        }
        return true;
    }
}
