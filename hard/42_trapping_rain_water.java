class Solution {
    public int trap(int[] height) {
        int[] left = ;
        int rightSum = 0;
        int solidSum = 0;

        int maxLeft = height[0];
        for(int i = 0; i < height.length; i ++) {
            maxLeft = (maxLeft > height[i]) ? maxLeft : height[i];
            leftSum += maxLeft;
            solidSum += height[i];
        }

        int maxRight = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i --) {
            maxRight = (maxRight > height[i]) ? maxRight : height[i];
            rightSum += maxRight;
        }

        return rightSum + leftSum - 2 * solidSum
    }
}
