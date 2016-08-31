/**
 * 
 * AC Code;
 * 
 */
public class Solution {
	public int largestRectangleArea(int[] height) {
	    if (height==null) return 0;//Should throw exception
	    if (height.length==0) return 0;
	    
	    Stack<Integer> index= new Stack<Integer>();
	    index.push(-1);
	    int max=0;
	    
	    for  (int i=0;i<height.length;i++){
	            //Start calculate the max value
	        while (index.peek()>-1)
	            if (height[index.peek()]>height[i]){
	                int top=index.pop();                    
	                max=Math.max(max,height[top]*(i-1-index.peek()));  
	            }else break;
	            
	        index.push(i);
	    }
	    while(index.peek()!=-1){
	    	int top=index.pop();
	        max=Math.max(max,height[top]*(height.length-1-index.peek()));
	    }        
	    return max;
	}
}




import java.util.*;

public class Lc84 {
	
	public static int maxRec(int[] heights){
		
		int len = heights.length;
		if(len < 1)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;

		for(int i = 0; i < len; i++){
			if(stack.isEmpty() || heights[stack.peek()] < heights[i]){
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.isEmpty() ? i : (i - stack.peek() - 1) ;
				maxArea = Math.max(maxArea, heights[start] * width);
				i--;
			}	
		}
		
		while(!stack.isEmpty()){
			int start = stack.pop();
			int width = stack.isEmpty() ? len : (len - stack.peek() - 1);
			maxArea = Math.max(maxArea, heights[start] * width);
		}
			
		return maxArea;
		
	}

	public static void main(String[] args){
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(maxRec(heights));	
	}
}
