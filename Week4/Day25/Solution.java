class Solution {
    
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int index = 0; index <= maxDistance; index++) {
            maxDistance = Math.max(maxDistance, index+nums[index]);
            if (maxDistance >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}