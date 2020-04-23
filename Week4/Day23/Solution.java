class Solution {
    
    public int rangeBitwiseAnd(int m, int n) {
        int rightMostBits = 0;

        while (m < n) {             // Stop when the first 0 in m is met -> There will always be at least once a 0 in each position of binary m in [m, n]
            n >>= 1;
            m >>= 1;
            rightMostBits++;
        }

        return m << rightMostBits;
    }
}