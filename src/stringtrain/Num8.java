package stringtrain;

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
