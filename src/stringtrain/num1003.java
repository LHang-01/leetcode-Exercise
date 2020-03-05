package stringtrain;

import java.util.Scanner;
import java.util.Stack;

/**
 * 分类：栈、字符串
 * 难度：中等
 * 1003. 检查替换后的词是否有效
 * 给定有效字符串 "abc"。
 *
 * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）
 * 那么，X + "abc" + Y 也同样是有效的。
 *
 * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。
 * 无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 *
 * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
 *
 * 由于每次必然会出现完整的abc，可以用栈记录字符，遍历字符串，依次将字符入栈，
 * 如果遇到a、b、c连续则均弹出，最后判断栈是否为空即可。
 */
public class num1003 {

    public static void main(String[] arrs){
        Scanner scanner = new Scanner(System.in);
        System.out.println(isValid(scanner.next()));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length =s.length();
        for(int i = 0;i<length;i++){
            if(s.charAt(i)!='c'){
                //不等于c时，全部入栈
                stack.push(s.charAt(i));
            }else {
                if(!stack.empty()&&stack.pop()=='b'){
                    if(!stack.empty()&&stack.pop()=='a'){
                        //等于c，只有依次从栈顶弹出b,a才能通过；否则abc不连续，返回false
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.empty();

    }

}
