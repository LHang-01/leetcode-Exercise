package stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 示例 1: 输入: "3+2*2" 输出: 7
 * 示例 2: 输入: " 3/2 " 输出: 1
 * 示例 3: 输入: " 3+5 / 2 " 输出: 5
 * 说明： 你可以假设所给定的表达式都是有效的。
 *        请不要使用内置的库函数 eval。
 */
public class Num227 {
    public static void main(String [] arrs){
        calculate2("3+2*2");
    }
    //方法：1）遇到数字,用start记录数字开始的位置，遍历直到非数字位i时，截取s.substring(start,i)部分并转换为int，压入数字栈中；
    //      2）遇到“*”“/”先运算（取出与数字栈的栈顶元素与符号“*”/“/”的下一个数字计算），将计算结果压入数字栈中；
    //      3）遇到“+”“-”就直接入符号栈。
    //入栈完成后，调整计算顺序：即数字栈和符号栈分别逆序。
    //最后弹栈计算“+”“-”
    //执行用时 :64 ms, 在所有 java 提交中击败了37.55%的用户
    //内存消耗 :43 MB, 在所有 java 提交中击败了43.38%的用户
    public static int calculate(String s) {
        int i = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int num = 0;
        while (i<s.length()){
            if (s.charAt(i)==' '){
                i++;
                continue;
            }
            if('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                int start = i;
                i++;
                while (i<s.length()&&'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                    i++;
                }
                stack1.push(Integer.parseInt(s.substring(start,i)));
            }else if (s.charAt(i)=='*'||s.charAt(i)=='/'){
                num = stack1.pop();
                int type = s.charAt(i);
                i++;
                while (s.charAt(i)==' '){
                    i++;
                }
                int start = i;
                while (i<s.length()&&'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                    i++;
                }
                int num2 = Integer.parseInt(s.substring(start,i));
                if (type == '*'){
                    stack1.push(num*num2);
                }else {
                    stack1.push(num/num2);
                }
            }else{
                stack2.push(s.charAt(i));
                i++;
            }
        }
        //反转栈后，变成正确的计算顺序
        Stack<Integer> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        while (!stack1.isEmpty()){
            stack3.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            stack4.push(stack2.pop());
        }
        Integer ans = stack3.pop();
        while (!stack4.isEmpty()){
            if (stack4.pop()=='+'){
                ans = ans+stack3.pop();
            }else {
                ans = ans-stack3.pop();
            }
        }
        return ans;
    }


    /**
     * 用两个站解决：1）遇到数字,用start记录数字开始的位置，遍历直到非数字位i时，截取s.substring(start,i)部分并转换为int，压入栈中；
     *              2）遇到“*”“/”先运算（取出与数字栈的栈顶元素与符号“*”/“/”的下一个数字计算），将计算结果压入栈中；
     *              3）遇到“+”“-”就直接入栈中。
     *              4) 遇到“ ”什么都不做
     *              然后反转栈，最后计算“+”、“-”
     *
     * 执行用时 : 49 ms , 在所有 Java 提交中击败了 44.16% 的用户
     * 内存消耗 : 47 MB , 在所有 Java 提交中击败了  33.83% 的用户
     */
    public static int calculate1(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int i =0;
        while (i<s.length()){
            //1.遇到数字,提取完整数字到数字栈stack1中
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int start = i;
                while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    i++;
                }
                stack1.push(Integer.parseInt(s.substring(start,i)));
            }else if (s.charAt(i)=='+'||s.charAt(i)=='-'){
                //2.遇到“+”“-”就直接入符号栈中
                stack2.push(s.charAt(i++));
            }else if (s.charAt(i)=='*'||s.charAt(i)=='/'){
                //3.遇到“*”“/”先运算
                int num1 = stack1.pop();
                int start = ++i;
                if (s.charAt(start)==' '){
                    //遇到空格后移一位
                    start = ++i;
                }
                while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    i++;
                }
                int num2 = Integer.parseInt(s.substring(start,i));
                if (s.charAt(start-1)=='*'){
                    stack1.push(num1*num2);
                }else {
                    stack1.push(num1/num2);
                }
            }else {
                //4.遇到空格
                i++;
            }
        }
        //反转栈后，变成正确的计算顺序
        Stack<Integer> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        while (!stack1.isEmpty()){
            stack3.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            stack4.push(stack2.pop());
        }
        Integer ans = stack3.pop();
        while (!stack4.isEmpty()){
            if (stack4.pop()=='+'){
                ans = ans+stack3.pop();
            }else {
                ans = ans-stack3.pop();
            }
        }
        return ans;
    }


    /**
     * 用双端队列实现
     *
     * 执行用时 : 20 ms , 在所有 Java 提交中击败了 83.62% 的用户
     * 内存消耗 : 46.1 MB , 在所有 Java 提交中击败了 34.47% 的用户
     */
    public static int calculate2(String s) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        int i =0;
        while (i<s.length()){
            //1.遇到数字,提取完整数字到数字栈stack1中
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int start = i;
                while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    i++;
                }
                list1.add(Integer.parseInt(s.substring(start,i)));
            }else if (s.charAt(i)=='+'||s.charAt(i)=='-'){
                //2.遇到“+”“-”就直接入符号栈中
                list2.add(s.charAt(i++));
            }else if (s.charAt(i)=='*'||s.charAt(i)=='/'){
                //3.遇到“*”“/”先运算
                int num1 = list1.removeLast();
                int start1 = ++i;
                int start2 = i;
                if (s.charAt(i)==' '){
                    //遇到空格后移一位
                    start2 = ++i;
                }
                while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    i++;
                }
                int num2 = Integer.parseInt(s.substring(start2,i));
                if (s.charAt(start1-1)=='*'){
                    list1.add(num1*num2);
                }else {
                    list1.add(num1/num2);
                }
            }else {
                //4.遇到空格
                i++;
            }
        }
        Integer ans = list1.poll();
        while (!list2.isEmpty()){
            if (list2.poll()=='+'){
                ans = ans+list1.poll();
            }else {
                ans = ans-list1.poll();
            }
        }
        return ans;
    }
}
