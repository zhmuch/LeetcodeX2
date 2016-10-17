public class Solution {
    public boolean canCross(int[] stones) {
        int maxJump = Math.min((int) Math.sqrt(stones[stones.length - 1] * 2), stones.length);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (!map.containsKey(stones[i]))
                map.put(stones[i], i);
        }

        boolean[][] mat = new boolean[stones.length][maxJump + 1];
        mat[0][0] = true;

        for (int i = 1; i < stones.length; i++) {
            if (stones[i] == stones[i - 1]) {
                System.arraycopy(mat[i - 1], 0, mat[i], 0, maxJump + 1);
            } else {
                for (int j = 1; j <= maxJump; j++) {
                    if (!map.containsKey(stones[i] - j))
                        continue;

                    int prevIdx = map.get(stones[i] - j);

                    for (int k = j - 1; k <= j + 1; k++) {
                        if (k < 0 || k > maxJump)
                            continue;

                        if (mat[prevIdx][k])
                            mat[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i <= maxJump; i++)
            if (mat[stones.length - 1][i])
                return true;
        return false;
    }
}
