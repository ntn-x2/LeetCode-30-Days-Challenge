class Solution {
    
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        int maxSum = nums[0];
        
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i-1] > 0) {
    			nums[i] += nums[i-1];
    		}
    		maxSum = Math.max(maxSum, nums[i]);
    	}
    	return maxSum;
    }
}