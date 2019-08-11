import java.io.*;
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        long ans = 0;
        ans = roll(d, f, target, 0, 0);
        return (int)ans;
    }
    long roll(int diceCount, int face, int target, long diceSum, long ans) {
        System.out.print("diceCount:");
        System.out.print(diceCount);
        System.out.print(", ans:");
        System.out.println(ans);
        if (diceCount == 1) {
            if (diceSum + face >= target) return ans + 1;
            else return ans;
        }

        for(int i = 1; i <= face; i++) {
            ans = roll(diceCount - 1, face, target, diceSum + i, ans);
            if (ans > 1000000007) ans = ans % 1000000007;
        }
        return ans;
    }
}


public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = in.readLine();
        int d = Integer.parseInt(line);
        line = in.readLine();
        int f = Integer.parseInt(line);
        line = in.readLine();
        int target = Integer.parseInt(line);
        int ret = new Solution().numRollsToTarget(d, f, target);
        System.out.println(ret);

    }
}
