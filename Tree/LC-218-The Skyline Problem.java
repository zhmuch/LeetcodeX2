public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();

        //  heights store lines;
        //  height[0]: x coordinates,   height[1]: height;
        List<int[]> heights = new LinkedList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], b[2]});
            heights.add(new int[]{b[1], -b[2]});
        }

        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int prev = 0;
        pq.offer(prev);
        

        for (int[] h : heights) {
            if (h[1] > 0) {
                pq.offer(h[1]);
            } else {
                pq.remove(-h[1]);
            }

            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[]{h[0], curr});
                prev = curr;
            }

        }

        return res;
    }
}
