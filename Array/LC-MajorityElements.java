public class Solution {
    /**
     * 169. Majority Element
     * 
     */
    public int majorityElement(int[] nums) {
        int curr = -1, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                curr = nums[i];
                count++;
            } else {
                if (nums[i] == curr)
                    count++;
                else
                    count--;
            }
        }
        
        return curr;
    }
    
    
    /**
     * 229. Majority Element II
     * 
     * Modified from 169.
     * 
     */
        public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

        int l = nums.length;
        if(l==0) return result;
        if(l==1) {
            result.add(nums[0]);
            return result;
        }

        int[] candi = new int[2];
        int t0 = 0;
        int t1 = 0;

        for(int i=0; i<l; i++){
            if(t0 == 0 && t1 == 0) {
                candi[0] = nums[i];
                t0++;
                continue;
            }
            if(t0 == 0 && t1!=0){
                if(candi[1]==nums[i]){
                    t1++;
                }
                else{
                    candi[0] = nums[i];
                    t0++;
                }
                continue;
            }
            if(t1 == 0 && t0!=0){
                if(candi[0]==nums[i]){
                    t0++;
                }
                else{
                    candi[1] = nums[i];
                    t1++;
                }
                continue;
            }
            if(candi[0]==nums[i]) t0++;
            else if(candi[1]==nums[i]) t1++;
            else {
                t0--;
                t1--;
            }
        }

        int count0 = 0;
        int count1 = 0;
        if(t0>0){
            for(int i=0; i<l; i++){
                if(nums[i] == candi[0]) count0++;
            }
        }
        if(t1>0) {
            for(int i=0; i<l; i++) {
                if(nums[i] == candi[1]) count1++;
            }
        }
        if (count0>l/3) result.add(candi[0]);
        if (count1>l/3) result.add(candi[1]);
        return result;
    }
}
