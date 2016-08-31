/**********
 * 
 * 84. Largest Rectangle in Histogram
 * 
 **********/


/**
 * Two Pointer
 * 
 * Super fast;
 * 
 */
   public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int left[] = new int[n+1];
        int right[] = new int[n+1];
        processLR(heights, left, right);
        for(int i=1; i<=n; i++){
            int tmp = (right[i]-left[i]+1) * heights[i-1];
            if( ans < tmp)
                ans = tmp;
        }
        return ans;
    }

    public static void processLR(int heights[], int left[], int right[]){
        int n = heights.length;
        //用临时数组，设置两个哨兵
        int tempArr[] = new int[n+2];
        tempArr[0] = -1;
        for(int i=1; i<=n; i++) tempArr[i] = heights[i-1];
        tempArr[tempArr.length-1] = -1;

        for(int i=1; i<=n; i++){
            int k = i;
            while( tempArr[i] <= tempArr[k-1])
                k = left[k-1];
            left[i] = k;
        }

        for(int i=n; i>0; i--){
            int k = i;
            while(  tempArr[i] <= tempArr[k+1])
                 k = right[k+1];
            right[i] = k;
        }
    }


/**
 * Stack
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


/**
 * Stack
 * 
 * Time Limit Exceed;
 * 
 */ 
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




/**********
 * 
 * 85. Maximal Rectangle
 * 
 **********/
