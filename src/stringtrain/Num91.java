package stringtrain;

public class Num91 {
    public static void main(String [] arrs){
        numDecodings("00");
    }
    //动态规划：
    // 从后往前遍历:
    //1)如果当前的数为0，结果为0。
    //2)如果当前的数加上前一个数小于等于26。结果为 pre1+ pre2
    //3)如果当前的数加上前一个数大于26。结果为 pre1
    //执行用时 :1 ms, 在所有 java 提交中击败了99.97%的用户
    //内存消耗 :34.7 MB, 在所有 java 提交中击败了44.96%的用户
    public static int numDecodings(String s) {
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
