//TAG 
class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for(int num : nums) counter = num == val ? counter : counter + 1;
        return counter;
    }
}
