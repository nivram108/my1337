class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = INTEGER.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                curSum = 0;
                while(curSum >= 0) {
                    if (i < nums.length) curSum += nums[i++];
                    maxSum = Math.max(curSum, nums[i]);

                }
            } else {
                maxSum = Math.max(maxSum, nums[i]);
            }
        }
        return maxSum;
    }
}
