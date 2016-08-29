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
    
    /**
     * LC-042. Trapping Rain Water
     * 
     * Stack;
     * 
     */
    public int trap(int[] height) {
        int vol = 0;
        int maxIdx = 0;
        
        //  Find highest point;
        for(int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIdx])
                maxIdx = i;
        }
        
        //  Left side;
        Stack<Integer> stack = new Stack<>();
        int tmpMax = 0;
        stack.push(tmpMax);
        for(int i = 1; i < maxIdx; i++) {
            if (height[i] >= height[tmpMax]) {
                tmpMax = i;
                stack.push(i);
            }
        }
        
        int prev = maxIdx;
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            for (int i = curr + 1; i < prev; i++)
                vol += height[curr] - height[i];
            prev = curr;
        }
        
        //  Right side;
        tmpMax = height.length - 1;
        stack.push(tmpMax);
        for(int i = height.length - 1; i > maxIdx; i--) {
            if (height[i] >= height[tmpMax]) {
                tmpMax = i;
                stack.push(i);
            }
        }
        
        prev = maxIdx;
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            for (int i = prev + 1; i < curr; i++)
                vol += height[curr] - height[i];
            prev = curr;
        }
        
        return vol;
    }
}
