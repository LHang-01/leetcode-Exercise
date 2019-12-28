package jianZhiOffer.num11_minNumberInRotateArray;

/**
 * 剑指offer面试题11--旋转数组中的最小数字（同33. 搜索旋转排序数组和81. 搜索旋转排序数组 II）
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个递增排序或者非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class minNumberInRotateArray {
    //本题中的array不包含重复元素。
    //二分查找到最小值，然后旋转数组
    //注意这里只能比较array[mid]和array[end]，因为若用array[mid]和array[start]比较会出问题

    /**
     * if (array[mid]>array[start]){          //这里，array[mid]>array[start]，时，可能最小值在右部分，但也可能最小值就是array[start]
     *                 start = mid + 1;
     *             }else if (array[mid]<array[start]){
     *                 end = mid;
     *             }else {
     *                  end--;
     *             }
     */
    public int minNumberInRotateArray1(int [] array) {
        if (array.length==0) return 0;
        int start = 0;
        int end = array.length-1;
        int mid ;
        while (start<end){
            mid=(start+end)/2;
            if (array[mid]>array[end]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return array[start];
    }
    //本题中的array包含重复元素。
    // 时间复杂度为O(lg n)，推荐。
    public int minNumberInRotateArray2(int [] array) {
        if (array==null||array.length==0) return 0;
        int start = 0;
        int end = array.length-1;
        int mid ;
        //1.二分查找到最小值
        while (start<end){
            mid=(start+end)/2;
            if (array[mid]>array[end]){                     //最小值一定在右部分，即使最小值是array[end]，如果判断后也满足条件
                start = mid + 1;
            }else if (array[mid]<array[end]){
                end = mid;
            }else {
                //array[mid]=array[start]时：既然mid处和start处值相同，那么让start++，让mid和start的后一个值继续比较。如果mid和start处都是最小值，就算放弃了start最后还是会在mid处找到最小值。
                end--;
            }
        }
        return array[end];
    }

    // 2.顺序遍历（不推荐）
    // 两个子数组都是递增的，只有在两个子数组的分界线处，才会有前一个字符大于后一个字符。时间复杂度为O(n)
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        for (int i = 0;i < array.length - 1;i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

}
