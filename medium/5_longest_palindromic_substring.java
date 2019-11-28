class Solution {
    public String longestPalindrome(String s) {
        return bruteForce(s);
    }

    String bruteForce(String s) {
        int maxLength = 0;
        String ans = "";
        if(s.length() <= 1) return s;
        for(int i = 0; i < s.length(); i++) {
            int cur = 1; // length of palindrome which center at i
            int l = i, r = i;
            boolean dou = false;
            if(i < s.length() - 1) {
                if(s.charAt(i + 1) == s.charAt(i)) {
                    r++;
                    cur++;
                    dou = true;
                }
            } else break;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                if(l == 0 || r == s.length() - 1 || s.charAt(l - 1) != s.charAt(r + 1)) break;
                cur += 2;
                l--;
                r++;
            }
            if(maxLength < cur) {
                maxLength = cur;
                ans = s.substring(l, l + cur);
                // System.out.println(cur);
            }
            if(dou == true) {
                l = i;
                r = i;
                cur = 1;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                    if(l == 0 || r == s.length() - 1 || s.charAt(l - 1) != s.charAt(r + 1)) break;
                    cur += 2;
                    l--;
                    r++;
                }
                if(maxLength < cur) {
                    maxLength = cur;
                    ans = s.substring(l, l + cur);
                    // System.out.println(cur);
                }
            }
        }
        return ans;
    }
}
