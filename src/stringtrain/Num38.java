package stringtrain;

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
