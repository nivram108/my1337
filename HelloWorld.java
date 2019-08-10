package marvin.git.my1337;

public class HelloWorld {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = args[0];
        String answer = solution.longestPalindrome(s);
        System.out.println(answer);
    }
}
