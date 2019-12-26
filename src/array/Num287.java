package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Num287 {
    /**
     * 暴力求解
     * 执行用时 :126 ms, 在所有 java 提交中击败了7.14%的用户
     * 内存消耗 :38 MB, 在所有 java 提交中击败了82.27%的用户
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int ans = 0;
        for (int i =0 ;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]==nums[i]){
                    ans= nums[j];
                    break;
                }
            }
        }
        return ans;
    }


    /**
     *快慢指针
     * 当快指针（走两步）和慢指针（走一步）第一次相遇时，慢指针不变，快指针归零从nums[0]重新出发，并且快指针也变为慢指针，当两指针再一次相遇时的值就是重复的值，这与链表中找循环链表的入口是一种道理
     * 执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.1 MB, 在所有 java 提交中击败了95.85%的用户
     */
    public int findDuplicate(int[] nums) {
        int slow =nums[0];
        int fast =nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        fast=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    /**
     * 以nums中元素为index，并为index%n指向的元素+n。
     * 再次循环，但nums[i]>2n时，说明i为重复出现的数字
     *
     * 执行用时 :
     * 1 ms, 在所有 java 提交中击败了85.21%的用户
     * 内存消耗 :
     * 37.6 MB, 在所有 java 提交中击败了92.52%的用户
     */
    public int findDuplicate2(int[] nums) {
        int n=nums.length;
        for (int i =0;i<n;i++){
            nums[nums[i]%n]+=n;
            if (nums[nums[i]%n]>=2*n){
                return nums[i]%n;
            }
        }
        return -1;
    }

    /**
     * 排序
     */
    public int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
    /**
     * 哈希表
     */
    public int findDuplicate4(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
    /**
     * 如果值i在正确的位置（满足numbers[i] ==i），则说什么都不做；
     * 如果值i没有在正确的位置（满足numbers[i] == i），通过交换两个元素，将值i放到正确的位置。这个过程可以看成是排序。
     * （交换过程：令j=numbers[i],判断j==numbers[j]是否相等，若相等，则说明在与i不同的位置j找到重复元素；不等则交换numbers[j]和numbers[i]，继续重复这一步。
     */
    public int findDuplicate5(int[] nums) {
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i){
                int j = nums[i];
                while (j!=nums[j]){
                    nums[i]=nums[j];
                    nums[j]=j;
                    j=nums[i];
                }
                if (j==nums[j]&&j!=i) return j;
            }
        }
        return -1;
    }

}
