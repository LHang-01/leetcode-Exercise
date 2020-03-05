package stringtrain;

/**
 * 8.请你来实现一个atoi函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1: 输入: "42" 输出: 42
 * 示例 2:  输入: "   -42" 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:  输入: "4193 with words" 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */

public class Num8 {
    public static void main(String [] arrs){
        myAtoi("20000000000000000000");
    }
    //执行用时 :2 ms, 在所有 java 提交中击败了99.53%的用户
    //内存消耗 :35.7 MB, 在所有 java 提交中击败了89.50%的用户
    public static int myAtoi(String str) {
        if (str==null||str.length()==0) return 0;
        //1.删除两端无用的空格字符
        str = str.trim();
        if (str==null||str.length()==0) return 0;
        //2.判断数字的符号
        int flag = 0;
        int start = 0;
        if (str.charAt(0)>='0'&&str.charAt(0)<='9'){
            //数字开头为正号
            flag = 1;
        }else if (str.charAt(0)=='+'||str.charAt(0)=='-'){
            flag = (str.charAt(0)=='+')?1:-1;
            //当符号后面不是数字时 返回0
            if (start+1>str.length()||!(str.charAt(start+1)>='0'&&str.charAt(start+1)<='9')){
                return 0;
            }
            start++;
        }else {
            return 0;
        }
        //3.找出数字部分
        int i = start;
        long ans =0;
        while (i<str.length()&&(str.charAt(i)>='0'&&str.charAt(i)<='9')){
            ans = str.charAt(i)-'0'+ans*10;
            //溢出判断
            if (ans!=(int)ans){
                if (flag==1){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return (int)ans*flag;
    }
}
