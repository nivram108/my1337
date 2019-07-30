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
            char prevChar = (startIndex - curPalindromeCount >= 0) ? s.charAt(startIndex - curPalindromeCount) : '#';
            char curChar = s.charAt(i);
            char nextChar = (i < s.length() - 1) ? s.charAt(i + 1) : '#';

            if (palindromeType.equals(TYPE_NONE)) {
                if (prevChar == nextChar) {
                    palindromeType = TYPE_ODD;
                    i++;
                    startIndex = i;
                    curPalindromeCount = 2;
                } else if (prevChar == curChar) {
                    palindromeType = TYPE_EVEN;
                    startIndex = i;
                    curPalindromeCount = 2;
                }
            } else if (palindromeType.equals(TYPE_ODD)) {
                if (curChar == prevChar) {
                    curPalindromeCount ++;
                } else {
                    if (curPalindromeCount > maxPalindromeCount) {
                        maxCountStartIndex = curPalindromeCount;
                        maxCountStartIndex = startIndex;
                    }
                    palindromeType = TYPE_NONE;
                    curPalindromeCount = 1;
                }
            } else if (palindromeType.equals(TYPE_EVEN)){
                if (curChar == prevChar) {
                    curPalindromeCount ++;
                } else {
                    if (curPalindromeCount > maxPalindromeCount) {
                        maxCountStartIndex = curPalindromeCount;
                        maxCountStartIndex = startIndex;
                    }
                    palindromeType = TYPE_NONE;
                    curPalindromeCount = 1;
                }
            }
        }
        return
    }
}
