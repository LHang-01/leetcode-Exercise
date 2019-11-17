package dynamicPlanning;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组nums，求出数组从索引i到j(i ≤ j) 范围内元素的总和，包含i,j两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 解题思路：
 * https://leetcode-cn.com/problems/range-sum-query-immutable/solution/303-qu-yu-he-jian-suo-shu-zu-bu-ke-bian-by-en-zhao/
 */
public class num303 {

    private int[] sum;
    public num303(int[] nums) {
        sum = new int[nums.length];
        int t=0;
        for(int i=0;i<nums.length;i++){
            t=t+nums[i];
            sum[i]=t;
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sum[j];

        }else {
            return sum[j] - sum[i - 1];
        }
    }

    public static void main(String[] arrs){
        num303 num = new num303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(num.sumRange(1,2));
    }
}
