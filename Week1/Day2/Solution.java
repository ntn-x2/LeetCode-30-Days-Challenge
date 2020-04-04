class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenValues = new HashSet<>();
        
        int value = n;
        while (value != 1 && seenValues.add(value)) {
            int loopSum = 0;
            
            while (value > 0) {
                loopSum += Math.pow(value % 10, 2);
                value /= 10;
            }
            value = loopSum;
        }
        return value == 1;
    }
}