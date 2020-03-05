package doublePointer.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n中n个数的序列，找出0 .. n中没有出现在序列中的那个数。
 *
 * 示例 1: 输入: [3,0,1] 输出: 2
 * 示例 2: 输入: [9,6,4,2,3,5,7,0,1] 输出: 8
 */
public class Num268 {


    /**
     * 法:1：哈希表
     * 执行用时 : 12 ms, 在所有 java 提交中击败了12.11%的用户
     * 内存消耗 :39.1 MB , 在所有 java 提交中击败了97.34%的用户
     *
     * 时间复杂度：O(n)。集合的插入操作的时间复杂度都是 O(1)，一共插入了 n 个数，时间复杂度为 O(n)。集合的查询操作的时间复杂度同样是 O(1)，最多查询 n+1 次，时间复杂度为 O(n)。因此总的时间复杂度为 O(n)。
     * 空间复杂度：O(n)。集合中会存储 n 个数，因此空间复杂度为 O(n)。
     */
    public int missingNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int i =0;
        for (;i<=nums.length;i++){
            if (!set.remove(i)){
                break;
            }
        }
        return i;
    }

    /**
     * 法2：排序
     * 时间复杂度：O(nlogn)。由于排序的时间复杂度为 O(nlogn)，扫描数组的时间复杂度为O(n)，因此总的时间复杂度为O(nlogn)。
     * 空间复杂度：O(1) 或 O(n)。空间复杂度取决于使用的排序算法，根据排序算法是否进行原地排序（即不使用额外的数组进行临时存储），空间复杂度为 O(1)或 O(n)。
     */
    public int missingNumber2(int[] nums) {
        //1.排序
        Arrays.sort(nums);
        //2.判断第一位是否为0
        if (nums[0]!=0) return 0;
        //3.判断当前值是否等于前一个值加1
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[i-1]+1){
                return i;
            }
        }
        //4.没找到返回-1
        return -1;
    }
    /**
     * 法3：用高斯算法求解
     * 用高斯求和公式 求出 [0..n]的和，减去数组中所有数的和，就得到了缺失的数字。
     *
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 94.65% 的用户
     * 内存消耗 : 40.4 MB , 在所有 java 提交中击败了 93.60% 的用户
     *
     * 时间复杂度：O(n)O(n)。求出数组中所有数的和的时间复杂度为 O(n)O(n)，高斯求和公式的时间复杂度为 O(1)O(1)，因此总的时间复杂度为 O(n)O(n)。
     * 空间复杂度：O(1)O(1)。算法中只用到了 O(1)O(1) 的额外空间，用来存储答案。
     */
    public int missingNumber3(int[] nums) {
        int sum;
        if ((nums.length+1)%2==0){
            sum=(nums.length+1)/2*nums.length;
        }else {
            sum=(nums.length+1)/2*nums.length+(nums.length+1)/2;
        }
        for (int num:nums){
            sum=sum-num;
        }
        return sum;
    }

    /**
     * 4.位运算
     *
     */
    public int missingNumber4(int[] nums){
        //4.没看懂
        return -1;
    }
}
