package hashTable.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 */
public class num242 {
    public static void main(String[] arrs){
        String s="anagram";
        String t= "nagaram";
        System.out.println(isAnagram1(s,t));
    }

    /**
     * 1.哈希表
     * 最简单的方法，map统计s的字母和个数，然后用map和t比较
     */
    public static boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            if (map.containsKey(c)){
                map.replace(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for (Character c:t.toCharArray()){
            if (map.containsKey(c)){
                if (map.get(c)>1){
                    map.replace(c,map.get(c)-1);
                }else {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }

    /**
     * 执行用时 :7 ms, 在所有 java 提交中击败了59.09%的用户
     * 内存消耗 :36.9 MB, 在所有 java 提交中击败了96.06%的用户
     * 优化方法1：哈希表
     * 算法：
     * 为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
     * 我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
     *
     * 时间复杂度：O(n)。时间复杂度为O(n) 因为访问计数器表是一个固定的时间操作。
     * 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是O(1)，因为无论 N 有多大，表的大小都保持不变。
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

    /**
     * 方法2：排序
     * 算法：
     * 通过将 s 的字母重新排列成 t 来生成变位词。因此，如果 T 是 S 的变位词，对两个字符串进行排序将产生两个相同的字符串。
     *
     * 时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本O(nlogn) 和比较两个字符串的成本O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。
     * 空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要O(1) 辅助空间。注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)额外的空间.
     */

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

}
