package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠.
 *
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 */
public class Num71 {
    public static void main(String[] arrs){
        simplifyPath("/a///////0/");
    }
    public static String simplifyPath(String path) {
        //Deque双向队列，指该队列两端的元素既能入队也能出队。因此，压栈时，利用栈的性质，出栈时，利用队列的性质。
        //压栈过程：,str=".."时（上一级目录），弹出栈顶元素；当str="."时（当前目录），不出栈也不入栈；当str！=null&&str！="."&&str!=".."时，则压入栈顶；
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
