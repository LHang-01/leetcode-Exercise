package doublePointer.string;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例 1: 输入: "abcabcbb" 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2: 输入: "bbbbb"  输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3: 输入: "pwwkew" 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *      请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。
 */
public class Num3 {
    public static void main(String[] arrs){
        System.out.println(lengthOfLongestSubstring("cdd"));
    }
    /**
     * 执行用时 :67 ms, 在所有 java 提交中击败了19.68%的用户
     * 内存消耗 :401 MB , 在所有 java 提交中击败了73.97%的用户
     * 法1：哈希表
     * 遍历数组，依次添加到map中，当哈希表中有重复的数字时，利用迭代器删除掉重复数字前面的数字，在计算map.size()得到非重复段的长度。
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int preMaxLength =0;
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else {
                preMaxLength=Math.max(preMaxLength,map.size());
                int temp = map.get(s.charAt(i));
                Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    if (iterator.next().getValue()<temp){
                        iterator.remove();
                    }
                }
                map.replace(s.charAt(i),i);
            }
        }
        return Math.max(preMaxLength,map.size());
    }
    /**
     * 法2：滑动窗口
     * 执行用时 :13ms, 在所有 java 提交中击败了58.96%的用户
     * 内存消耗 :34.2MB , 在所有 java 提交中击败了93.85%的用户
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        //i和j用于控制滑动窗口,当不重复,更新最长的不重复字符串长度，并且j往后移动;
        // 当重复时，i往前移动直到删除重复的字符后，再次判断的结果是不重复，此时j位置的字符加入到set中，就往后移动；
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans=Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
