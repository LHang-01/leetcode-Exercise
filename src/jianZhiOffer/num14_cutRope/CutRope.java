package jianZhiOffer.num14_cutRope;

/**
 * 剑指offer面试题14--剪绳子
 *
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    //动态规划
    public int cutRope(int target) {
        if (target < 2) return 0;
        // f(2)
        if (target == 2)return 1;
        // f(3)
        if (target == 3) return 2;
        int[] dp = new int[target+1];
        // 下面这三个存的不是f(1)、f(2)、f(3)，只是单纯的长度而已
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i= 4 ;i<=target;i++){
            int max = i-1;
            for (int j=2;j<=i/2;j++){
                if (dp[j]*dp[i-j]>max){
                    max=dp[j]*dp[i-j];
                }
            }
            dp[i]=max;
        }
        return dp[target];
    }

    //贪婪算法
    //如果绳子长度n >= 5，就不断分出长度为3的绳子，如果最后只剩下长度为1的绳子，退一步，将得到长度为4的绳子，
    //然后将这长度为4的绳子分成2*2(这样分是因为2*2大于原来的3*1)；因此n = 4时不能分出长度为3的绳子,而n = 2，n = 3的最优解可直接返回。
    public static int maxProductAfterCutting2(int target) {
        if (target < 2) return 0;
        // f(2)
        if (target == 2)return 1;
        // f(3)
        if (target == 3) return 2;
        // f(4)
        if (target == 4) return 4;
        int len = target/3;
        if (target%3==1){
            return (int)Math.pow(3,len-1)*4;
        }
        return (int)Math.pow(3,len)*(target%3);
    }
}
