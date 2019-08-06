import java.util.HashMap;
class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> repeatNum = new HashMap<Integer, Boolean>();
        int x = n;
        while (repeatNum.containsKey(x) == false) {
            repeatNum.put(x, true);
            x = squareSum(x);
            if (x == 1) return true;
        }
        return false;
    }
    int squareSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
