public class Solution {

    /**
     * LC-011 Container With Most Water
     * Two Pointer;
     * 
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        
        return max;
    }
    
    /**
     * LC-042. Trapping Rain Water
     * 
     * One pointer, scan from left to right;
     * 
     */
    public int trap(int[] height) {
        int vol = 0;
        int maxIdx = 0;
        
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[maxIdx]) {
                int j = i - 1;
                while(height[i] > height[j]) {
                    vol += height[i] - height[j];
                    height[j] = height[i];
                    j--;
                }
            } else {
                for (int j = maxIdx + 1; j < i; j++) {
                    vol += height[maxIdx] - height[j];
                    height[j] = height[maxIdx];
                }
                maxIdx = i;    
            }
        }
        
        return vol;
    }
}
