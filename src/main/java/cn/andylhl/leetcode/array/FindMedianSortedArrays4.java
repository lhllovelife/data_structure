package cn.andylhl.leetcode.array;

/***
 * @Title: FindMedianSortedArrays4
 * @Description: 寻找两个正序数组的中位数
 * @author: lhl
 * @date: 2021/3/21 22:35
 */
public class FindMedianSortedArrays4 {

    /**
     * 归并数组，然后根据奇偶进行判断
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // step0 如果某一数组长度为0，则不需要合并
        int m = nums1.length;
        int n = nums2.length;

        // nums1数组长度为0，则在nums2求中位数
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[(n / 2) - 1] + nums2[(n / 2 + 1) - 1]) / 2.0;
            } else {
                return nums2[((n + 1) / 2) - 1];
            }
        }

        // nums2数组长度为0，则在nums2求中位数
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[(m / 2) - 1] + nums1[(m / 2 + 1) - 1]) / 2.0;
            } else {
                return nums1[((m + 1) / 2) - 1];
            }
        }

        // step1 合并数组
        // a<=b a
        // a>b  b
        int[] array = new int[m + n];
        int i = 0;
        int j = 0;
        int p = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                array[p] = nums1[i];
                ++i;
                ++p;
            } else {
                array[p] = nums2[j];
                ++j;
                ++p;
            }
        }
        while (i < m) {
            array[p] = nums1[i];
            ++i;
            ++p;
        }

        while (j < n) {
            array[p] = nums2[j];
            ++j;
            ++p;
        }

        // step2 根据数组长度，求中位数
        int arrayLength = m + n;

        if (arrayLength % 2 == 0) {
            return (array[(arrayLength / 2) - 1] + array[(arrayLength / 2 + 1) - 1]) / 2.0;
        } else {
            return array[((arrayLength + 1) / 2) - 1];
        }
    }

    /**
     * 双指针，每次删除一个最小的, 保存最新舍去的值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        // step0: 定义两个指针，一个指向nums1的初始值，一个纸箱nums2的初始值
        int p = 0;
        int q = 0;
        int m = nums1.length;
        int n = nums2.length;
        int midPos = (m + n + 1) / 2;
        // 指针需要移动的次数
        int moveCountTarget = midPos;
        // 记录指针移动的次数
        int moveCount = 0;
        // 记录当前舍弃掉的最小的值
        int firstMinValue = 0;

        // step2: 一个一个的数最小值（移动到一半的位置）
        while (p < m && q < n && moveCount < moveCountTarget) {
            // 比较值的大小，将小的舍去，指针向后移动
            if (nums1[p] <= nums2[q]) {
                firstMinValue = nums1[p];
                moveCount++;
                p++;
            } else {
                firstMinValue = nums2[q];
                moveCount++;
                q++;
            }
        }
        while (p < m && moveCount < moveCountTarget) {
            firstMinValue = nums1[p];
            moveCount++;
            p++;
        }
        while (q < n && moveCount < moveCountTarget) {
            firstMinValue = nums2[q];
            moveCount++;
            q++;
        }

        boolean isOddNumber = true;
        if ((m + n) % 2 == 0) isOddNumber = false;

        // 根据奇偶, 以及p q是否越界进行判断

        if (isOddNumber) {
            // 如果为奇数，则firstValue即为所求结果
            return firstMinValue;
        } else {
            // 如果为偶数，需要获取当前状况的小未被删除的值里的最小值
            if (p >= m) {
                return (firstMinValue + nums2[q]) / 2.0;
            } else if (q >= n) {
                return (firstMinValue + nums1[p]) / 2.0;
            } else {
                return (firstMinValue + Math.min(nums1[p], nums2[q])) / 2.0;
            }
        }


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5};
        int[] nums2 = {-1, 6};
        FindMedianSortedArrays4 findMedianSortedArrays4 = new FindMedianSortedArrays4();
        double medianSortedArrays = findMedianSortedArrays4.findMedianSortedArrays2(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
