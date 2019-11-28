public int[] zfunction(String s) {
    int[] z = new int[s.length];
    z[0] = s.length;
    int l = 0; // newest prefix left index
    int r = 0; // newest prefix right index

    for(int i = 1; i < s.length; i++) {
        // if i < r, implies s[i] is included in the prefix starts from s[l]
        // while s[l] == s[0] and s[i] == s[i - l]
        // it is possible to use previous result to calculate z[i]
        if(i < r) {
            int k = i - l;
            // if z[k] less than R - i + 1,
            if(z[k] < R - i + 1) {
                z[i] = z[k];
            } else {

                l = i;
                while(r < s.length && s.charAt(r - l) == s.charAt(r)) r++
                z[i] = r - l;
                r--;
            }
        } else {
            l = r = i;
            while(r < s.length && s.charAt(r - l) == s.charAt(r)) r++
            z[i] = r - l;
            r--;
        }
    }
    return z;
}
