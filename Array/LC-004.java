public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 && len2 == 0)
            return 0;
        
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        
        return (findKthFrom2Arrays(nums1, 0, nums2, 0, left) + findKthFrom2Arrays(nums1, 0, nums2, 0, right)) / 2.0;
    }
    
    private double findKthFrom2Arrays(int[] nums1, int n1start, int[] nums2, int n2start, int k) {
        if (n1start >= nums1.length)
            return nums2[n2start + k - 1];
        if (n2start >= nums2.length)
            return nums1[n1start + k - 1];
        
        if (k == 1)
            return Math.min(nums1[n1start], nums2[n2start]);
        
        int n1m = (n1start + k/2 - 1 < nums1.length) ? nums1[n1start + k/2 - 1]: Integer.MAX_VALUE;
        int n2m = (n2start + k/2 - 1 < nums2.length) ? nums2[n2start + k/2 - 1]: Integer.MAX_VALUE;
        
        if (n1m > n2m)
            return findKthFrom2Arrays(nums1, n1start, nums2, n2start + k/2, k - k/2);
        else
            return findKthFrom2Arrays(nums1, n1start + k/2, nums2, n2start, k - k/2);
    }
}
