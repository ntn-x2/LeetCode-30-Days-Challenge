class Solution {
    public int findMaxLength(int nums[]) {
        int maxLength = 0;
        int sum = 0;

        Map<Integer, Integer> sumValues = new HashMap<Integer, Integer>(nums.length);
        sumValues.put(0, -1);       // Sum from index 0 has the longest sequence
  
        for (int i = 0; i < nums.length; i++) { 
            sum += (nums[i]*2 - 1);     // Transform 0 to -1
  
            Integer minIndexWithSameSum = sumValues.get(sum);
            if (minIndexWithSameSum != null) {
                int currentLength = i - minIndexWithSameSum;
                maxLength = Math.max(maxLength, currentLength); // Get the greter between the max length and the current length
            } else {
                sumValues.put(sum, i);
            }
        }
  
        return maxLength; 
    }
}