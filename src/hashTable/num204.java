package hashTable;

/**
 * 204 。计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 解题思路：https://leetcode-cn.com/problems/count-primes/solution/e-la-duo-sai-shai-fa-qiu-zhi-shu-java-by-zxy0917/
 * 如求10之内的质数，首先列出2〜N-1的所有数，如果当前数为质数，则其倍数就是质数，如
 *
 * 第一个质数为2，在2上画圈，其倍数4/6/8不是质数，划掉4/6/8，继续遍历
 * 下一个质数为3，在3上画圈，其倍数6/9不是质数，划掉6/9，继续遍历
 * 下一个质数为5，在5上画圈，没有倍数，继续遍历
 * 下一个质数为7，在7上画圈，没有倍数，继续遍历。
 * 最后再次遍历整个整数，画圈的数字就是质数，即2,3,5,7
 */
public class num204 {

    public static void main(String[] arrs){
        int n =19;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n){
        int[] nums = new int[n];
        for (int i=2;i<n;i++){
            for (int j=2;i*j<n;j++){
                //1表示不为质数
                nums[i*j]=1;
            }
        }
        int res = 0;
        //0表示质数，下面统计质数个数
        for (int i = 2; i < n; i++) {
            if (nums[i] == 0)
                res++;
        }
        return res;

    }

}
