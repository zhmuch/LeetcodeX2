public class Solution {
    /**
     * Create the maximum number of length k <= m + n from digits of the two. 
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] res = new int[k]; 
        
        for (int i = Math.max(0, k - l2); i <= Math.min(l1, k); i++) {
            int[] pos1 = generateK(nums1, i);
            int[] pos2 = generateK(nums2, k - i);
            
            
            int[] pos = merge(pos1, pos2);
            
            res = greaterNums(res, pos);
        }
        
        return res;   
    }
    
    /**
     * Create the maximum number of length k from digits of the one. 
     */
    private int[] generateK(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i > k - j && j > 0 && nums[i] > res[j - 1])
                j--;
            
            if (j < k)
                res[j++] = nums[i];
        }
        
        return res;
    }
    
    /**
     * Merge two nums to get greatest nums.
     */
    // private int[] merge(int[] nums1, int[] nums2) {
    //     int l1 = nums1.length, l2 = nums2.length;
    //     int[] res = new int[l1 + l2];
        
    //     int idx = 0, i = idx, j = i;
    //     while (i < l1 && j < l2) {
    //         res[idx++] = (nums1[i] > nums2[j]) ? nums1[i++] : nums2[j++];
    //     }
        
    //     if (i == l1) {
    //         while (j < l2)
    //             res[idx++] = nums2[j++];
    //     } else {
    //         while (i < l1)
    //             res[idx++] = nums1[i++];
    //     }
        
    //     return res;
    // }
    private int[] merge(int[] tmp1, int[] tmp2){
        int[] res = new int[tmp1.length + tmp2.length];
        int pos1 = 0, pos2 = 0, idx = 0;

        while(pos1 < tmp1.length && pos2 < tmp2.length){

            if(tmp1[pos1] > tmp2[pos2])
                res[idx++] = tmp1[pos1++];
            else if(tmp1[pos1] < tmp2[pos2])
                res[idx++] = tmp2[pos2++];
            else{
                int t1 = pos1, t2 = pos2;
                boolean flag = false;
                while(t1 < tmp1.length && t2 < tmp2.length){
                    if(tmp1[t1] == tmp2[t2]){
                        t1++;
                        t2++;
                    } else if(tmp1[t1] > tmp2[t2]){
                        res[idx++] = tmp1[pos1++];
                        flag = true;
                        break;
                    } else{
                        res[idx++] = tmp2[pos2++];
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    if(t1 == tmp1.length)
                        res[idx++] = tmp2[pos2++];
                    else
                        res[idx++] = tmp1[pos1++];
            }
            // System.out.println("res: " + res[idx - 1]);
        }

        if(pos1 == tmp1.length)
            while(pos2 < tmp2.length)
                res[idx++] = tmp2[pos2++];
        else
            while(pos1 < tmp1.length)
                res[idx++] = tmp1[pos1++];

        return res;
    }
    
    
    /**
     * Return the bigger one of two nums.
     */
    private int[] greaterNums(int[] nums1, int[] nums2) {
        // System.out.println(nums1.length + " " + nums2.length);
        
        int idx = 0;
        
        while(idx < nums1.length && nums1[idx] == nums2[idx]) {
            idx++;
        }
        
        if (idx == nums1.length)
            return nums1;
        
        return (nums1[idx] > nums2[idx]) ? nums1 : nums2;
    }
}
