package stack;

import java.util.HashMap;
import java.util.Stack;
/**
 * 分类：栈、字符串
 * 难度：简单
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class num20 {
    /**
     *执行用时 :* 3 ms, 在所有 java 提交中击败了70.28%的用户
     * 内存消耗 :34.3 MB, 在所有 java 提交中击败了85.15%的用户
     *
     *用哈希表来查能增加运行速度
     */
    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i=0;i<length;i++) {
            //如果栈为空
            if (stack.empty()) {
                //判断该元素是否为 （ { [
                if (map.containsKey(s.charAt(i))) {
                    //若是直接放入栈内
                    stack.push(s.charAt(i));
                }else {
                    //不是，则该元素为）} ]，当把这些放入栈底时
                    return false;
                }
            }else {
                //栈不为空时，截取一个字符长度，比较栈顶元素是否匹配
                //判断该元素是否为 ) ] }
                if (map.containsValue(s.charAt(i))) {
                    //若是,与栈顶比较是否相等
                    if (s.charAt(i) == map.get(stack.peek())) {
                        //相等，弹出栈顶
                        stack.pop();
                    } else {
                        //不等
                        return false;
                    }
                } else {
                    //不是，则该元素为（ { [
                    stack.push(s.charAt(i));
                }
            }

        }
        //当把全部字符放入栈后，看栈是否为空
        return stack.empty();
    }

    public static void main(String[] arrs){
        System.out.println(isValid1("()"));
    }

    /**
     * 执行用时 : 4 ms , 在所有 java 提交中击败了 42.22% 的用户
     * 内存消耗 : 34.6 MB, 在所有 java 提交中击败了83.23%的用户
     */
    public static boolean isValid1(String s) {
        Stack<String> stack = new Stack<>();
        String temp ="";
        for (int i=0;i<s.length();i++){
            temp=s.substring(i,i+1);
            if (stack.isEmpty()){
                //栈为空，判断要加入的元素是否是("(")||("{")("[")
                if (temp.equals(")")||temp.equals("}")||temp.equals("]")){
                    return false;
                }
                stack.push(temp);
            }else {
                //栈不为空，则与栈顶元素比较匹配
                if ((stack.peek().equals("(")&&temp.equals(")"))||(stack.peek().equals("{")&&temp.equals("}"))||(stack.peek().equals("[")&&temp.equals("]"))){
                    //匹配则弹出栈顶元素
                    stack.pop();
                }else{
                    stack.push(temp);
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
