package stringtrain;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 */
public class Num38 {
    public static void main(String [] arrs){
        System.out.println(countAndSay2(4));
    }

    /**
     * 执行用时 :21 ms , 在所有 java 提交中击败了8.69%的用户
     * 内存消耗 :36.2 MB , 在所有 java 提交中击败了 74.48%的用户
     * @param n
     * @return
     */
    public static String countAndSay1(int n) {
        String ans = "1";
        if (n==1) return ans;
        int j;
        while (n>1){
            j=0;
            while (j<ans.length()){
                String s = ans.substring(j,j+1);
                int i=j+1;
                while (i<ans.length()&&ans.substring(i,i+1).equals(s)){
                    ++i;
                }
                s = (i - j) + s;
                ans=ans.substring(0,j)+s+((j==ans.length()-(i - j))?"":ans.substring(i,ans.length()));
                j=j+2;
            }
            n--;
        }
        return ans;
    }

    /**
     * 执行用时 :2 ms , 在所有 java 提交中击败了88.20%的用户
     * 内存消耗 :34.2 MB , 在所有 java 提交中击败了90.55%的用户
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {
        String ans = "1";
        if (n==1) return ans;
        for (int i=2;i<=n;i++){
            StringBuilder builder = new StringBuilder();
            char pre = ans.charAt(0);
            int count = 1;
            for (int j=1;j<ans.length();j++){
                if (ans.charAt(j)==pre){
                    count++;
                }else {
                    builder.append(count).append(pre);
                    pre = ans.charAt(j);
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            ans=builder.toString();
        }
        return ans;
    }
}
