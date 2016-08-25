public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        
        while(m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[idx--] = nums1[m - 1];
                m--;
            } else {
                nums1[idx--] = nums2[n - 1];
                n--;
            }
        }
        
        if (m == 0)
            for( ; n > 0; n--)
                nums1[idx--] = nums2[n - 1];
        
        return;
    }
}
