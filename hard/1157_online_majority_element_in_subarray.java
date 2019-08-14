class MajorityChecker {

    int mElements[];
    public MajorityChecker(int[] arr) {
        mElements = arr;
    }

    public int query(int left, int right, int threshold) {
        int count = 0;
        // System.out.print("elements:");
        int[] mCounts = new int[20001];
        for(int i = left; i <= right; i++) {
            int element = mElements[i];
            mCounts[element] ++;
            if(mCounts[element] >= threshold) {

                return element;
            }
        }
        return -1;
    }
}
