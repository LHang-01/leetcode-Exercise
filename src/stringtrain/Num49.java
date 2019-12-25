package stringtrain;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Num49 {
    //执行用时 :11 ms, 在所有 java 提交中击败了97.18%的用户
    //内存消耗 :42.9 MB, 在所有 java 提交中击败了92.78%的用户
    //方法一：排序数组分类
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String  str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else {
                map.get(key).add(str);
            }
        }
        return new ArrayList(map.values());
     }


}
