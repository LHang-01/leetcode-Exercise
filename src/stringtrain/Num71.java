package stringtrain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num71 {
    public static void main(String[] arrs){
        simplifyPath("/a///////0/");
    }
    public static String simplifyPath(String path) {
        //Deque双向队列，指该队列两端的元素既能入队也能出队。因此，压栈时，利用栈的性质，出栈时，利用队列的性质。
        //压栈过程：,str=".."时（上一级目录），弹出栈顶元素；当str="."时（当前目录），不出栈也不入栈；当str！=null&&str！="."&&str=".."时，则压入栈顶；
        //完成入栈操作后，出栈过程：先进先出。
        //执行用时 :6 ms, 在所有 java 提交中击败了86.30%的用户
        //内存消耗 :38.5 MB, 在所有 java 提交中击败了81.48%的用户
        Deque<String> stack = new LinkedList<String>();
        //注意：用split时，不能分割连续符号；
        //例如：split("/")切割"/a///////0/",结果为""、"a"、""、""、""、""、""、""、"0"；split(" ")切割" a    0 ",结果为""、"a"、""、""、""、"0"
        String[] strings = path.split("/");
        for (String str:strings){
            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!str.isEmpty() && !str.equals(".")){
                stack.push(str);
            }
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }
}
