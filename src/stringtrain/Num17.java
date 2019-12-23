package stringtrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Num17 {
    //第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)
    //第二层括弧实际上是一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行。
    HashMap<Character, String> map = new HashMap(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    List<String> output = new ArrayList<String>();

    //回溯算法：回溯是一种通过穷举所有可能情况来找到所有解的算法。
    //执行用时 :1 ms, 在所有 java 提交中击败了95.05%的用户
    //内存消耗 :36.1 MB, 在所有 java 提交中击败了73.14%的用户
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return output;
        return function(digits,"");
    }

    private List<String> function(String digits,String str) {
        //终止条件
        if (0==digits.length()){
            output.add(str);
        }else {
            String letters = map.get(digits.charAt(0));
            for (Character letter:letters.toCharArray()){
                function(digits.substring(1),str+letter);
            }
        }
        return output;
    }
}
