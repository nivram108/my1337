class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int minRot = A.length;
        for(int v = 1; v <= 6; v++) {
            // for each die value
            int tmpMinA = 0;
            int tmpMinB = 0;
            for(int i = 0; i < A.length; i++) {
                tmpMinA = ((A[i] != v) && B[i] == v) ? tmpMinA + 1 : tmpMinA;
                tmpMinB = ((B[i] != v) && A[i] == v) ? tmpMinB + 1 : tmpMinB;
                if(((tmpMinA >= minRot) && (tmpMinB >= minRot)) || ((A[i] != v) && (B[i] != v))) {
                    tmpMinA = tmpMinB = A.length;
                    break;
                }
            }
            minRot = (tmpMinA < minRot) ? tmpMinA : minRot;
            minRot = (tmpMinB < minRot) ? tmpMinB : minRot;
        }
        return (minRot == A.length) ? -1 : minRot;
    }
}
