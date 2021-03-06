public class NumArray {

    int[] st;
    int[] arr;

    public NumArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return;

        int len = nums.length;
        int x = (int) (Math.ceil(Math.log(len) / Math.log(2)));
        int size = 2 * (int) Math.pow(2, x) - 1;

        this.st = new int[size];
        arr = new int[len];
        System.arraycopy(nums, 0, arr, 0, len);

        constrST(0, len - 1, 0);
    }

    private int constrST(int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }

        int mid = getMid(ss, se);
        st[si] = constrST(ss, mid, 2 * si + 1) + constrST(mid + 1, se, 2 * si + 2);

        return st[si];
    }

    private int getMid(int a, int b) {
        if (b < a)
            return getMid(b, a);
        else
            return a + (b - a) / 2;
    }

    void updateST(int ss, int se, int si, int idx, int diff) {
        if (idx < ss || idx > se)
            return;

        st[si] += diff;

        if (ss >= se)
            return;

        int mid = getMid(ss, se);
        updateST(ss, mid, 2 * si + 1, idx, diff);
        updateST(mid + 1, se, 2 * si + 2, idx, diff);
    }

    void update(int i, int val) {
        if (i < 0 || i >= arr.length)
            return;

        int diff = val - arr[i];

        arr[i] = val;

        updateST(0, arr.length - 1, 0, i, diff);
    }

    private int sumST(int i, int j, int ss, int se, int si) {
        if (j < ss || i > se)
            return 0;

        if (i <= ss && j >= se)
            return st[si];

        int mid = getMid(ss, se);

        return sumST(i, j, ss, mid, 2 * si + 1) + sumST(i, j, mid + 1, se, 2 * si + 2);
    }

    public int sumRange(int i, int j) {
        if (i > j || i < 0 || j >= arr.length)
            return 0;

        if (i == j)
            return arr[i];

        return sumST(i, j, 0, arr.length - 1, 0);
    }
}
