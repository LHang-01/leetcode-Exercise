package stringtrain;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */

public class Num8 {
    public int myAtoi(String str) {
        if (str==null||str.length()==0) return 0;
        //丢弃无用的开头空格字符
        int index=0;
        while (index<str.length()&&str.charAt(index)==' '){
            index++;
        }
        if (index==str.length()){
            return 0;
        }
        //当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
        // 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
        int flag = 1;
        int start = index;
        while (start<str.length()&&(str.charAt(start)=='+'||str.charAt(start)=='-')){
            start++;
        }
        if (start==str.length()||start-index>0){
            return 0;
        }
        if (!(str.charAt(start)>='0'&&str.charAt(start)<='9')){
            return 0;
        }
        while (index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
            index++;
        }
        int end=index;
        String num = str.substring(start,end);
        long number = Long.parseLong(num);
        if (number>Integer.MAX_VALUE&&flag == 1){
            return Integer.MAX_VALUE;
        }else if (number>Integer.MAX_VALUE-1&&flag == -1){
            return Integer.MIN_VALUE;
        }else {
            return (int)number*flag;
        }
    }
}
