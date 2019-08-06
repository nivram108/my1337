//TAG while
class Solution {
    public int reverse(int x) {
        boolean isPositive = x >= 0 ? true : false;
        x = isPositive ? x : -1 * x;
        if (x > 1000000000 && x % 10 > 2) return 0;
        //check overflow
        int reverse = 0;
        while (x != 0) {
            reverse += x % 10;
            if (x >= 10) {
                // if (reverse > reverse * 10) return 0;
                reverse *= 10;
            }
            x /= 10;
        }
        return isPositive ? reverse : reverse == Integer.MAX_VALUE ? 0 : -1 * reverse;

    }
}
