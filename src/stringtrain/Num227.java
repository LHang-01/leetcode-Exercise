package stringtrain;

import java.util.Stack;

public class Num227 {
    public static void main(String [] arrs){
        calculate("0-2147483647");
    }
    //方法：遇到数字和“+”“-”就入栈，遇到“*”“/”先运算了再入栈；
    //入栈完成后，再弹栈计算“+”“-”
    public static int calculate(String s) {
        int i = s.length()-1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int num = 0;
        while (i>=0){
            if (s.charAt(i)==' '){
                i--;
                continue;
            }
            if('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                int end = i;
                i--;
                while (i>=0&&'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                    i--;
                }
                stack1.push(Integer.parseInt(s.substring(i+1,end+1)));
            }else if (s.charAt(i)=='*'||s.charAt(i)=='/'){
                num = stack1.pop();
                int type = s.charAt(i);
                i--;
                while (s.charAt(i)==' '){
                    i--;
                }
                int end = i;
                while (i>=0&&'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                    i--;
                }
                int num2 = Integer.parseInt(s.substring(i+1,end+1));
                if (type == '*'){
                    stack1.push(num2*num);
                }else {
                    stack1.push(num2/num);
                }
            }else{
                stack2.push(s.charAt(i));
                i--;
            }
        }
        Integer ans = stack1.pop();
        while (!stack2.isEmpty()){
            if (stack2.pop()=='+'){
                ans = ans+stack1.pop();
            }else {
                ans = ans-stack1.pop();
            }
        }
        return ans;
    }
}
