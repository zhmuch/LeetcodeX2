public class Solution {
    
    //Count Sort
    public void sortColors(int[] nums) {
        int n1 = 0, n2 = 0, n3 = 0;
        
        for(int i : nums)
            if (i == 0)
                n1++;
            else if (i == 1)
                n2++;
            else
                n3++;
        
        for(int i = 0; i < n1; i++)
            nums[i] = 0;
        for(int i = n1; i < n1 + n2; i++)
            nums[i] = 1;
        for(int i = n1 + n2; i < n1 + n2 + n3; i++)
            nums[i] = 2;
            
        return;
    }
}
