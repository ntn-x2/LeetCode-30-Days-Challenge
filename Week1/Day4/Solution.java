class Solution {
    
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount += 1;
            } else {
                nums[i-zeroCount] = nums[i];
            }
        }
        
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}