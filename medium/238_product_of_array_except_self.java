class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] output = new int[nums.length];
        output[0] = 1;
        int leftProduct = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct *= nums[i - 1];
            output[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }
}
