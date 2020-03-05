package hashTable.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 * 示例 2: 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
 * 说明： 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。
 * 进阶:
 *      如果给定的数组已经排好序呢？你将如何优化你的算法？
 *      如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *      如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Num350 {
    /**
     * 执行用时 :  4 ms , 在所有 java 提交中击败了 77.05% 的用户
     * 内存消耗 : 37 MB , 在所有 java 提交中击败了 38.73% 的用户
     * 法一：哈希表
     * 这里用map的key存元素，value存相同元素的个数
     * 先遍历一个数组，将所有数保存到map中，
     * 然后遍历另一个数组，当另一个数组的值与map的key相同时，并且判断key对应的value是否>1：当value>1,从map中的value减一，并且添加到list中；
     *                                                                                 当value<1,从map中移除该元素。
     * 最后list保存的就是交集
     *
     * 优化，每次都是new一个list存数据，使空间复杂度变为O(n)；但是可以把数据存在原数组中，这样空间复杂度就变为了O(1)。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num:nums1){
            if (map.containsKey(num)){
                map.replace(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        int k=0;
        for (int num:nums2){
            if (map.containsKey(num)){
                if (map.get(num)>1){
                    map.replace(num,map.get(num)-1);
                }else {
                    map.remove(num);
                }
                nums1[k++]=num;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

    /**
     * 执行用时 : 2 ms , 在所有 java 提交中击败了 99.78% 的用户
     * 内存消耗 : 36.6 MB , 在所有 java 提交中击败了 50.07% 的用户
     *
     * 法二：双指针
     * 首先对两个数组进行排序，然后双指针，p1指向nums1，p2指向nums2：
     * 如果nums1[p1] == nums2[p2]，说明俩数组中都有这个数，是其交集，所以将它丢入list中。
     * 如果不等，则移动小的那个指针。
     *
     * 时间复杂度：O(nlogn+mlogm)。其中 n，m分别代表了数组的大小。我们对数组进行了排序然后进行了线性扫描。
     * 空间复杂度：O(1)，我们忽略存储答案所使用的空间，因为它对算法本身并不重要。
     *
     * 优化，每次都是new一个list，使空间复杂度变为O(n)；但是可以把数据存在原数组中，这样空间复杂度就变为了O(1)。
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i =0;
        int j = 0;
        int k = 0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]>nums2[j]){
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                nums1[k++]=nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

}
