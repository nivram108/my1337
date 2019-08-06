class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        int frontIndex = 0;
        int backIndex = s.length() - 1;
        boolean b = false;
        while(frontIndex < backIndex) {
            while(Character.isLetter(s.charAt(frontIndex)) == false){
                if (frontIndex == s.length() - 1) return false;
                frontIndex ++;
            }
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
