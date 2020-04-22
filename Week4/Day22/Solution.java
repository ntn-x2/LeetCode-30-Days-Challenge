class Solution {
    
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumOccurrences = new HashMap<>();
        int totalSum = 0;
        int totalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            totalCount += sumOccurrences.getOrDefault(totalSum-k, 0);
            sumOccurrences.put(totalSum, sumOccurrences.getOrDefault(totalSum, 0)+1);
        }

        return totalCount + sumOccurrences.getOrDefault(k, 0);
    }
}