package jianZhiOffer.num46_TransLateNumToString;

/**
 * 剑指offer面试题46--把数字翻译成字符串
 * 给定一个数字，我们按照如下的规则把它翻译成字符串
 * 0 -> a
 * 1 -> b
 * 2 -> c
 * ...
 * 25 -> z
 * 一个数字可能有多种翻译，比如12258有五种，分别是"bccfi", "bwfi","bczi","mcfi", "mzi".请实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class TransLateNumToString {
    //动态规划，这里只用了两个变量来存储dp[n+1]、dp[n+2]，因为计算dp[n]时最多只需要这两个变量
    //当chars[chars.length-1]=='0'时，dp[n]=0
    //当(chars[i]-'0')*10+chars[i+1]-'0'>26时，dp[n]=dp[n+1]；
    //当(chars[i]-'0')*10+chars[i+1]-'0'>26时,dp[n]=dp[n+1]+dp[n+2]；
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int pre1=1;
        if (chars[chars.length-1]=='0'){
            pre1 = 0;
        }
        int pre2 = 1;
        for (int i = chars.length-2;i>=0;i--){
            if (chars[i]=='0'){
                pre2=pre1;
                pre1=0;
                continue;
            }
            if ((chars[i]-'0')*10+chars[i+1]-'0'>26){
                pre2=pre1;
            }else {
                pre1=pre1+pre2;
                pre2=pre1-pre2;
            }
        }
        return pre1;
    }
}
