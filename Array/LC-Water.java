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
    
    
    /**
     * LC-407. Trapping Rain Water II
     *
     */
    import java.io.*;
    import java.util.*;

    public class Solution {
        private class Cell {
            int row;
            int col;
            int height;
            public Cell(int row, int col, int height) {
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
                return 0;

            PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2) {
                    return o1.height - o2.height;
                }
            });


            int row = heightMap.length;
            int col = heightMap[0].length;

            boolean[][] visited = new boolean[row][col];

            // Initial Boundary
            for (int i = 0; i < row; i++) {
                visited[i][0] = visited[i][col - 1] = true;
                queue.offer(new Cell(i, 0, heightMap[i][0]));
                queue.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            }
            for (int j = 0; j < col; j++) {
                visited[0][j] = visited[row - 1][j] = true;
                queue.offer(new Cell(0, j, heightMap[0][j]));
                queue.offer(new Cell(row - 1, j, heightMap[row - 1][j]));
            }

            int res = 0;
            int[][] dire = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            while (!queue.isEmpty()) {
                Cell curr = queue.poll();

                for (int[] d : dire) {
                    int tr = curr.row + d[0];
                    int tc = curr.col + d[1];

                    if (0 <= tr && tr < row && 0 <= tc && tc < col && !visited[tr][tc]) {
                        visited[tr][tc] = true;

                        if (heightMap[tr][tc] < curr.height) {
                            res += (curr.height - heightMap[tr][tc]);
                            queue.offer(new Cell(tr, tc, curr.height));
                        } else {
                            queue.offer(new Cell(tr, tc, heightMap[tr][tc]));
                        }
                    }
                }
            }

            return res;
        }
    }
}
