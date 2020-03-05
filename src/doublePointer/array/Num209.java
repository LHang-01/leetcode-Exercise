package doublePointer.array;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 输入: s = 7, nums = [2,3,1,2,4,3]  输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Num209 {
    public static void main(String[] arrs){
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        //System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }

    /**
     * 双指针：保持子数组的左端点不动去找右端点。但若发现和大于s后，我们就可以移动左端点，
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 89.89% 的用户
     * 内存消耗 : 48.8 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * 时间复杂度：O(n) 。每个指针移动都需要 O(n) 的时间。
     * 每个元素至多被访问两次，一次被右端点访问，一次被左端点访问。
     * 空间复杂度： O(1) 。left，sum，ans 以及 i 这些变量只需要常数个空间
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    /**
     * 还差一个二分查找没写
     */
    /*public static int minSubArrayLen1(int s, int[] nums) {

    }*/
}
