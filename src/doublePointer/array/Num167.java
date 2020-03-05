package doublePointer.array;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
 *
 * 说明: 返回的下标值（index1 和 index2）不是从零开始的。
 *       你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Num167 {
    public static void main(String[] arrs){
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        twoSum(nums,target);

    }

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 99.17% 的用户
     * 内存消耗 : 37.2 MB , 在所有 java 提交中击败了 91.97% 的用户
     *
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum变小一些；
     * 如果 sum < target，移动较小的元素，使 sum变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     *
     * 时间复杂度：O(N)O(N)，这里 NN 表示数组中的元素的大小。
     * 空间复杂度：O(1)O(1)，只使用了常数个变量。
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int pre = 0;
        int last = numbers.length-1;
        while (numbers[pre]+numbers[last]!=target){
            if (numbers[pre]+numbers[last]>target){
                last--;
            }else {
                pre++;
            }
        }
        int[] ints = new int[2];
        ints[0]=pre+1;
        ints[1]=last+1;
        return ints;
    }


    /**
     * 执行用时 : 3 ms , 在所有 java 提交中击败了 33.54% 的用户
     * 内存消耗 : 46.1 MB , 在所有 java 提交中击败了 5.01% 的用户
     *
     * 用二分查找算法
     *
     * 时间复杂度：O(N \log N)O(NlogN)，这里 NN 表示数组中的元素的大小，外层循环是线性时间复杂度，内层循环是对数级别的时间复杂度。
     * 空间复杂度：O(1)O(1)，只使用了常数个变量。
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        int start;
        int end = numbers.length-1;
        int pre;
        for (int i=0;i<numbers.length-1;i++){
            pre = search2(numbers,i+1,end,target-numbers[i]);
            if (pre==-1){
                continue;
            }else {
                ans[0] = i+1;
                ans[1] = pre+1;
                break;
            }
        }
        return  ans;
    }
    /**
     * 使用二分查找在numbers数组中的target位置
     * @param numbers 数组
     * @param start 查找的起始位置
     * @param end 查找的末位置
     * @param target 查找的目标元素
     * @return
     */
    public static int search2(int[] numbers,int start,int end,int target){
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if (numbers[mid]==target){
                return mid;
            }else if (numbers[mid]>target){
                end = mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1; //返回-1表示没找到
    }


    /**
     * 改进的二分查找
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 36.44% 的用户
     * 内存消耗 : 46.9 MB , 在所有 Java 提交中击败了 5.01% 的用户
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start;
        int end = numbers.length-1;
        int pre;
        for (int i=0;i<numbers.length;i++){
            start=i+1;
            pre = search(numbers,start,end,target-numbers[i]);
            if (numbers[i]+numbers[pre]==target){
                ans[0] = i+1;
                ans[1] = pre+1;
                break;
            }else {
                //改进的地方：将返回的插入位置的值作为end，以缩短下一次的查找范围。
                // 因为，下一次的numbers[i]变大了，那么target-numbers[i]久变小了，所以把上一次的查询结果作为本次的查询末位置，可以减少查询的长度
                end=(pre+1)<numbers.length?pre+1:numbers.length;
            }
        }
        return  ans;
    }
    /**
     * 使用二分查找在numbers数组中的target位置
     * @param numbers 数组
     * @param start 查找的起始位置
     * @param end 查找的末位置
     * @param target 查找的目标元素
     * @return
     */
    public static int search(int[] numbers,int start,int end,int target){
        int mid = start;
        while (start<=end){
            mid=(start+end)/2;
            if (numbers[mid]==target){
                return mid;//返回的是target在numbers 数组中的位置
            }else if (numbers[mid]>target){
                end = mid-1;
            }else {
                start=mid+1;
            }
        }
        return mid;//返回的是target在numbers 数组中的插入位置
    }
}
