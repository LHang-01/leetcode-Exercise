package dynamicPlanning;

public class num279 {

    public static void main(String[] arrs){
        int arr = 12;
        System.out.println(numSquares(arr));
    }

    /**
     * 先默认n的组成和的完全平方数的个数最大=n
     * 然后，计算拆分计算：
     * for j=1 to 根号n
     * ints[n-j*j]+ints[j*j]  //注意ints[j*j]=1，该式子可简化为ints[i-j*j]+1。
     * 比较得到最小的值，存入n中
     *
     * 执行用时 : 49 ms , 在所有 java 提交中击败了 42.73% 的用户
     * 内存消耗 :35.6 MB , 在所有 java 提交中击败了41.13%的用户
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] ints = new int[n+1];
        ints[1]=1;
        for (int i=2;i<n+1;i++){
            ints[i]=i;
            for (int j=1;j*j<=i;j++){
                ints[i]=Math.min(ints[i],ints[i-j*j]+1);
            }
        }
        return ints[n];
    }
}
