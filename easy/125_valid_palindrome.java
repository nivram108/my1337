class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int frontIndex = 0;
        int backIndex = s.length() - 1;
        boolean b = false;
        while(frontIndex < backIndex) {
            while(isAlphanumeric(s.charAt(frontIndex)) == false){
                if (frontIndex == s.length() - 1) return true;
                frontIndex ++;
            }
            while(isAlphanumeric(s.charAt(backIndex)) == false) backIndex --;
            if (Character.getNumericValue(s.charAt(frontIndex)) == Character.getNumericValue(s.charAt(backIndex))) {
                frontIndex ++;
                backIndex --;
            } else {
                return false;
            }
        }
        return true;
    }
    boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit();
    }
}
