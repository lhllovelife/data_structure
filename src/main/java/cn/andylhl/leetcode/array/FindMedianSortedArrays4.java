package cn.andylhl.leetcode.array;

/***
 * @Title: FindMedianSortedArrays4
 * @Description: 寻找两个正序数组的中位数
 * @author: lhl
 * @date: 2021/3/21 22:35
 */
public class FindMedianSortedArrays4 {

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

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        FindMedianSortedArrays4 findMedianSortedArrays4 = new FindMedianSortedArrays4();
        double medianSortedArrays = findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
