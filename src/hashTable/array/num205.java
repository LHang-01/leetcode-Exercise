package hashTable.array;

import java.util.HashMap;

/**
 * 205.给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 */
public class num205 {
    public static void main(String[] arrs){
        String s="egg";
        String t="add";
        System.out.println(isIsomorphic(s,t));
    }

    /**
     * 分三情况：
     * 1)哈希表中有相同的键就替换；
     * 2）哈希表中无情况下又有两种：
     * 判断值是不是有：
     * 2.1）键不同，值相同，说明会存在两个不同的键对应于一个值的情况，即a->c,b->c，则返回false
     * 2.2）键不同，值也不同，则先把该键值对存于表中
     */
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder builder = new StringBuilder(s.length());
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
            }else if (map.containsValue(t.charAt(i))){
                return false;
            }else {
                map.put(s.charAt(i),t.charAt(i));
            }
            builder.append(map.get(s.charAt(i)));
        }
        return builder.toString().equals(t);

    }
}
