class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int tmpSum = 0;
        int oneSum = 0;
        int maxSumInTwo = 0;
        int bottom = 0;
        int head = 0;
        boolean interrupt = false;
        for(int i = 0; i < arr.length; i++) {
            oneSum += arr[i];
            tmpSum += arr[i];
            if(tmpSum < 0) {
                interrupt = true;
                tmpSum = 0;
            }
            maxSumInTwo = Math.max(tmpSum, maxSumInTwo);
            head = Math.max(oneSum, head);
        }
        for(int i = 0; i < arr.length; i++) {
            tmpSum += arr[i];
            if(tmpSum < 0) {
                interrupt = true;
                tmpSum = 0;
            }
            maxSumInTwo = Math.max(tmpSum, maxSumInTwo);
        }
        tmpSum = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            tmpSum += arr[i];
            bottom = Math.max(tmpSum, bottom);
        }

        System.out.println(oneSum);
        System.out.println(k);
        System.out.println(head);
        System.out.println(bottom);
        System.out.println(oneSum * (k - 2) + head + bottom);
        System.out.println(maxSumInTwo);
        int s = 0;
        for(int i = 0; i < k - 2; i++) {
            s += oneSum;
            s %= 1000000007;
        }
        return Math.max(s + head + bottom, maxSumInTwo);
    }
    int getDigit(int n) {
        int digit = 0;
        while(n > 0) {
            digit += 1;
            n /= 10;
        }
        return digit;
    }

}
