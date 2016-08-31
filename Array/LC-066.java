public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for ( int i = digits.length - 1; carry > 0 && i > -1; i-- ) {
            int n = digits[i] + carry;
            carry = n / 10;
            digits[i] = n % 10;
        }
        if ( carry > 0 ) {
            int[] n = new int[digits.length + 1];
            n[0] = carry;
            System.arraycopy(digits, 0, n, 1, digits.length);
            digits = n;
        }
        return digits;
    }
}
