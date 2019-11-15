package greedy;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class num122 {
    public static void main(String[] arrs){
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(fun1(arr));
    }
    //波谷时买入，波峰时卖出
    public static int fun1(int[] arr){
        int j=0;
        int sum = 0;
        for(int i=0;i<arr.length;i=j){
            j=i+1;
            while(j<arr.length&&arr[j]>arr[j-1]){
                j++;
            }
            sum=sum+arr[j-1]-arr[i];
        }
        return sum;
    }
}
