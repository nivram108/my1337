class Solution {
    public boolean isMatch(String s, String p) {
        String currentChar = Character.toString(p.charAt(0));
        boolean star = false;
        String state = "init:";
        int indexInputString = 0, indexPattern = 0;
        //System.out.println(state + "s.length:" + Integer.toString(s.length()) + " , p.length:" + Integer.toString(p.length()));
        if(p.length() >= 2 && p.charAt(1) == '*') {
            star = true;
            indexPattern = 2;
        }
        boolean answer = true;
        while (indexInputString < s.length() && indexPattern < p.length()) {
            if(star) {
                while(currentChar == Character.toString(s.charAt(indexInputString))) {
                    indexInputString ++;
                     // start identifying end state
                     state = "star true:";
                     //System.out.println(state + "indexInputString:" + Integer.toString(indexInputString) + " , indexPattern:" + Integer.toString(indexPattern));
                    if(indexInputString == s.length()) { // input string matching end
                        if (indexPattern == p.length()) { // pattern matching end
                            return true;
                        } else { // left star
                            if (star) return true;
                            else return false;
                        }
                    } else {
                        if (indexPattern == p.length()) {
                            return false;
                        } else {
                        }
                    }
                    // end of identifying end state
                } // match repeated char if star

                // start moving index for next match
                indexInputString ++;
                indexPattern ++;
                currentChar = Character.toString(p.charAt(indexPattern));
                // end of moving index for next match
            } else {
                if (currentChar != Character.toString(s.charAt(indexInputString))) return false;
                else {
                    // start moving index for next match
                    state = "normal match:";
                    //System.out.println(state + "indexInputString:" + Integer.toString(indexInputString) + " , indexPattern:" + Integer.toString(indexPattern));
                    indexInputString ++;
                    indexPattern ++;

                    // start identifying end state
                    if(indexInputString == s.length()) { // input string matching end
                        if (indexPattern == p.length()) { // pattern matching end
                            return true;
                        } else { // left star
                            if (star) return true;
                            else return false;
                        }
                    } else {
                        if (indexPattern == p.length()) {
                            return false;
                        } else {
                        }
                    }
                    // end of identifying end state
                    currentChar = Character.toString(p.charAt(indexPattern));
                    // end of moving index for next match

                    if(currentChar == "*") {
                        state = "is star:";
                        star = true;
                        indexPattern ++;
                        // start identifying end state
                        //System.out.println(state + "indexInputString:" + Integer.toString(indexInputString) + " , indexPattern:" + Integer.toString(indexPattern));
                        if(indexInputString == s.length()) { // input string matching end
                            if (indexPattern == p.length()) { // pattern matching end
                                return true;
                            } else { // left star
                                if (star) return true;
                                else return false;
                            }
                        } else {
                            if (indexPattern == p.length()) {
                                return false;
                            } else {
                            }
                        }
                        // end of identifying end state
                        currentChar = Character.toString(p.charAt(indexPattern));
                    }

                    if(currentChar == ".") {
                        currentChar = Character.toString(s.charAt(indexInputString)); // anyChar into next input char
                        indexInputString ++;

                        // start identifying end state
                        state = "anyChar:";
                        //System.out.println(state + "indexInputString:" + Integer.toString(indexInputString) + " , indexPattern:" + Integer.toString(indexPattern));
                        if(indexInputString == s.length()) { // input string matching end
                            if (indexPattern == p.length()) { // pattern matching end
                                return true;
                            } else { // left star
                                if (star) return true;
                                else return false;
                            }
                        } else {
                            if (indexPattern == p.length()) {
                                return false;
                            } else {
                            }
                        }
                        // end of identifying end state
                    }
                }
            }
        }
        return true;
    }

}
