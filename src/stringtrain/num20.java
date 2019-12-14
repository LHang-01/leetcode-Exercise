package stringtrain;

import java.util.HashMap;
import java.util.Scanner;
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
    public static void main(String[] arrs){
        Scanner scanner = new Scanner(System.in);
        System.out.println(isValid(scanner.next()));

    }

    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 java 提交中击败了
     * 38.77%
     * 的用户
     * 内存消耗 :
     * 34.7 MB
     * , 在所有 java 提交中击败了
     * 82.67%
     * 的用户
     * @param s
     * @return
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

    /*执行用时：6 ms,内存消耗34 MB
    public boolean isValid(String s) {
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
                if(map.containsKey(s.charAt(i))){
                    //若是直接放入栈内
                    stack.push(s.charAt(i));
                }else {
                    //不是，则该元素为）} ]，当把这些放入栈底时
                    return false;
                }
            }else {
                //栈不为空时，截取一个字符长度，比较栈顶元素是否匹配
                if(map.containsKey(stack.peek())&&s.charAt(i) ==map.get(stack.peek())){
                    //若map含栈顶元素则弹出
                    stack.pop();
                } else {
                    //不匹配则放入栈内
                    stack.push(s.charAt(i));
                }
            }
        }
        //当把全部字符放入栈后，看栈是否为空
        return stack.empty();
    }
    */
}
