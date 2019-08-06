import java.io.*;
import org.json.simple.jsonarray;
class Solution {
    public boolean isPalindrome(String s) {
        int frontIndex = 0;
        int backIndex = s.length() - 1;
        boolean b = false;
        while(frontIndex >= backIndex) {
            while(Character.isLetter(s.charAt(frontIndex)) == false) frontIndex ++;
            while(Character.isLetter(s.charAt(backIndex)) == false) backIndex --;
            if (s.charAt(frontIndex) == s.charAt(backIndex)) {
                frontIndex ++;
                backIndex --;
            } else {
                return false;
            }
        }
        return true;
    }
}


public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new Solution().isPalindrome(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
