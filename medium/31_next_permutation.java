class Solution {
    public void nextPermutation(int[] nums) {
        int critIndex = -1;
        for(int i = nums.length - 1; i >= 1; i--) {
            if(nums[i] > nums[i - 1]) {
                critIndex = i - 1;
            }
        }
        if(critIndex == -1) {
        } else {
            for(int i = nums.length - 1; i >= 1; i--) {
                if(nums[critIndex] < nums[i]) {
                    swap(nums, critIndex, i);
                }
            }
            critIndex --;
        }
        reverse(nums, critIndex + 1, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
