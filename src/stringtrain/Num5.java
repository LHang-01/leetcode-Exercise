package stringtrain;

public class Num5 {
    //1.暴力匹配
    //执行用时 :1369 ms, 在所有 java 提交中击败了5.00%的用户
    //内存消耗 :46.5 MB, 在所有 java 提交中击败了38.74%的用户
    public String longestPalindrome1(String s) {
        if (s.length()<2) return s;
        String ans = s.substring(0,1);
        int maxLength = 1;
        for (int i=0;i<s.length();i++){
            for (int j = i+1;j<s.length();j++){
                //当[i,j]子串是回文串，并且长度大于maxLength时，才修改最大回文子串
                if (valid1(s,i,j)==true&&maxLength<j-i+1){
                    ans = s.substring(i,j+1);
                    maxLength = j-i+1;
                }
            }
        }
        return ans;
    }

    //验证[i,j]子串是否是回文串
    private boolean valid1(String s, int i, int j) {
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //2.中心扩散法
    // 思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
    //执行用时 :27 ms, 在所有 java 提交中击败了59.44%的用户
    //内存消耗 :36.9 MB, 在所有 java 提交中击败了88.83%的用户
    public String longestPalindrome2(String s) {
        if (s.length()<2) return s;
        String ans = s.substring(0,1);
        int maxLength = 1;
        for (int i=0;i<s.length()-1;i++){
            String str1 = valid2(s,i,i);
            String str2 = valid2(s,i,i+1);
            if (Math.max(str1.length(),str2.length())>maxLength){
                maxLength = Math.max(str1.length(),str2.length());
                ans = str1.length()>str2.length()?str1:str2;
            }
        }
        return ans;
    }

    private String valid2(String s, int i, int j) {
        while (i>=0&&j<s.length()){
            if (s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else {
                break;
            }
        }
        return s.substring(i+1,j);
    }

    //3.动态规划
    //使用记号 s[l, r] 表示原始字符串的一个子串，l、r 分别是区间的左右边界的索引值，使用左闭、右闭区间表示左右边界可以取到。
    //1、定义 “状态”，这里 “状态”数组是二维数组。
    //dp[l][r] 表示子串 s[l, r]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。即如果子串 s[l, r] 是回文串，那么 dp[l][r] = true。
    //2、找到 “状态转移方程”。
    //给出一个子串 s[l, r] ，如果 s[l] != s[r]，那么这个子串就一定不是回文串。如果 s[l] == s[r] 成立，就接着判断 s[l + 1] 与 s[r - 1]，这很像中心扩散法的逆方法。事实上，当 s[l] == s[r] 成立的时候，dp[l][r] 的值由 dp[l + 1][r - l] 决定。
    // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要.因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串. 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
    //执行用时 :52 ms, 在所有 java 提交中击败了47.21%的用户
    //内存消耗 :39.4 MB, 在所有 java 提交中击败了59.99%的用户
    public String longestPalindrome3(String s) {
        if (s.length()<2) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = s.substring(0,1);
        int maxLength = 1;
        for (int i=1;i<s.length();i++){
            for (int j = 0;j<i;j++){
                if (s.charAt(i)==s.charAt(j)&&(i-j<=2||dp[j+1][i-1])){
                    dp[j][i]=true;
                    if (i-j+1>maxLength){
                        maxLength = i-j+1;
                        ans = s.substring(j,i+1);
                    }
                }
            }
        }
        return ans;
    }
}
