package jianZhiOffer.num10_Fibonacci;

/**
 * 扩展2：矩形覆盖问题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *  * n=1，f(1) = 1；n=2，f(2) = 2
 *  *  —      ——      ——
 *  * | |    | | |     |——|
 *  * —     ——       ——
 *  * n=3,f(3) =3 ;n=4，f(4) = 5
 *  * 当最后一步是竖着放时候，说明前一步已经覆盖了2*(n-1)，记为f(n - 1)
 *  * 当最后一步是横着放的时候，倒数第二次也必然是横着放的。这个状态已经覆盖了2* (n-2)，记为f(n - 2)
 */
public class RectCover {
    public int RectCover(int target) {
        if (target<=2) return target;
        int pre = 1;
        int sum = 2;
        for (int i = 3 ; i<=target;i++){
            sum = pre+sum;
            pre = sum-pre;
        }
        return sum;
    }
}
