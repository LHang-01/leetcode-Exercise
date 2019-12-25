package stringtrain;

import java.util.Stack;

public class Num227 {
    public static void main(String [] arrs){
        calculate("0-2147483647");
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
}
