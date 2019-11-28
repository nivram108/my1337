class Solution {
    String TYPE_ODD = "ODD";
    String TYPE_EVEN = "EVEN";
    String TYPE_NONE = "NONE";
    public String longestPalindrome(String s) {
        int maxPalindromeCount = 0;
        int maxCountStartIndex = 0;
        int curPalindromeCount = 1;
        int startIndex = 0;
        String answer = "";
        String palindromeType = TYPE_NONE;
        for (int i  = 0; i < s.length(); i++ ) {
            if (palindromeType.equals(TYPE_NONE)) startIndex = i;
            // char prevChar = (startIndex - curPalindromeCount >= 0) ? s.charAt(startIndex - curPalindromeCount) : '#';
            char curChar = s.charAt(i);
            char nextChar = (i < s.length() - 1) ? s.charAt(i + 1) : '#';


            if (palindromeType.equals(TYPE_NONE)) {
                char prevChar = (startIndex - 1 >= 0) ? s.charAt(startIndex - 1) : '#';
                if (prevChar == nextChar) {
                    palindromeType = TYPE_ODD;
                    i++;
                    startIndex = i;
                    curPalindromeCount = 3;
                } else if (prevChar == curChar) {
                    palindromeType = TYPE_EVEN;
                    startIndex = i;
                    curPalindromeCount = 2;
                }
            } else if (palindromeType.equals(TYPE_ODD)) {
                char prevChar = (startIndex - (curPalindromeCount / 2) - 1 >= 0) ? s.charAt(startIndex - (curPalindromeCount / 2) - 1) : '#';
                if (curChar == prevChar) {
                    curPalindromeCount += 2;
                } else {
                    if (curPalindromeCount > maxPalindromeCount) {
                        maxCountStartIndex = curPalindromeCount;
                        maxCountStartIndex = startIndex;
                        curPalindromeCount = 1;
                        answer = s.substring(startIndex - (curPalindromeCount / 2) - 1, startIndex + (curPalindromeCount / 2));
                        // answer = Integer.toString(startIndex) + "," + Integer.toString(curPalindromeCount);
                    }
                    palindromeType = TYPE_NONE;
                    curPalindromeCount = 1;
                }
            } else if (palindromeType.equals(TYPE_EVEN)){
                char prevChar = (startIndex - (curPalindromeCount / 2) >= 0) ? s.charAt(startIndex - (curPalindromeCount / 2) ) : '#';
                if (curChar == prevChar) {
                    curPalindromeCount += 2;
                } else {
                    if (curPalindromeCount > maxPalindromeCount) {
                        maxCountStartIndex = curPalindromeCount;
                        maxCountStartIndex = startIndex;
                        curPalindromeCount = 1;
                        answer = s.substring(startIndex - (curPalindromeCount / 2), startIndex + (curPalindromeCount / 2));
                    }
                    palindromeType = TYPE_NONE;
                    curPalindromeCount = 1;
                }
            }
        }
        return answer;
    }
}
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello! World!");
    }
}
