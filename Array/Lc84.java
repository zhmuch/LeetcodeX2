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
