package doublePointer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1: 输入: [1,3,4,2,2] 输出: 2
 * 示例 2: 输入: [3,1,3,4,2] 输出: 3
 * 说明：    不能更改原数组（假设数组是只读的）。
 *          只能使用额外的 O(1) 的空间。
 *          时间复杂度小于 O(n2) 。
 *          数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Num287 {
    /**
     * 1.暴力求解
     * 执行用时 :126 ms, 在所有 java 提交中击败了7.14%的用户
     * 内存消耗 :38 MB, 在所有 java 提交中击败了82.27%的用户
     *
     * 时间复杂度小于 O(n2)
     * 空间复杂度O(1)
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
     * 2.排序:如果对数字进行排序，则任何重复的数字都将与排序后的数组相邻。
     *
     * 时间复杂度：O(nlgn)。排序调用在 Python 和 Java 中花费O(nlgn) 时间，因此它支配后续的线性扫描。
     * 空间复杂度：O(1) (orO(n))，在这里，我们对 nums 进行排序，因此内存大小是恒定的。如果我们不能修改输入数组，那么我们必须为 nums 的副本分配线性空间，并对其进行排序。
     */
    public int findDuplicate2(int[] nums) {
        //1.排序
        Arrays.sort(nums);
        //2.遍历判断前一个数和后一个数是否相等
        for (int i = 1;i<nums.length;i++){
            if (nums[i]==nums[i-1]){
                return i;
            }
        }
        //3.没找到重复数字，返回-1.
        return -1;
    }
    /**
     * 3.快慢指针
     * 当快指针（走两步）和慢指针（走一步）第一次相遇时，慢指针不变，快指针归零从nums[0]重新出发，并且快指针也变为慢指针，当两指针再一次相遇时的值就是重复的值，这与链表中找循环链表的入口是一种道理
     *
     * 执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.1 MB, 在所有 java 提交中击败了95.85%的用户
     *
     * 时间复杂度：O(n)O(n)。
     * 空间复杂度：O(1)O(1)
     */
    public int findDuplicate3(int[] nums) {
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
     * 4.以nums中元素为index，并为index%n指向的元素+n。
     * 再次循环，但nums[i]>2n时，说明i为重复出现的数字
     * 注意：此方法修改了原数组
     *
     * 执行用时 : 1 ms, 在所有 java 提交中击败了85.21%的用户
     * 内存消耗 : 37.6 MB, 在所有 java 提交中击败了92.52%的用户
     */
    public int findDuplicate4(int[] nums) {
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
     * 5.哈希表
     *
     * 时间复杂度：O(n)。
     * 空间复杂度：O(n)。
     */
    public int findDuplicate5(int[] nums) {
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
     * 6.如果值i在正确的位置（满足numbers[i] ==i），则说什么都不做；
     *   如果值i没有在正确的位置（满足numbers[i] == i），通过交换两个元素，将值i放到正确的位置。这个过程可以看成是排序。
     * （交换过程：令j=numbers[i],判断j==numbers[j]是否相等，若相等，则说明在与i不同的位置j找到重复元素；不等则交换numbers[j]和numbers[i]，继续重复这一步。
     *
     * 这个方法有点复杂，不容易看懂。
     */
    public int findDuplicate6(int[] nums) {
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
