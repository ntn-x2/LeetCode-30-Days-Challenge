class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] storage = new int[text1.length()][text2.length()];
        initialiseStorage(storage);
        return longestCommonSubsequence(text1, text2, 0, 0, storage);
    }

    private void initialiseStorage(int[][] storage) {
        for (int row = 0; row < storage.length; row++) {
            for (int col = 0; col < storage[0].length; col++) {
                storage[row][col] = -1;
            }
        }
    }

    private int longestCommonSubsequence(String s1, String s2, int i1, int i2, int[][] storage) {
        if (i1 >= s1.length() || i2 >= s2.length()) {
            return 0;
        }

        if (storage[i1][i2] != -1) {
            return storage[i1][i2];
        }

        int result = s1.charAt(i1) == s2.charAt(i2) ? longestCommonSubsequence(s1, s2, i1+1, i2+1, storage)+1 : Math.max(longestCommonSubsequence(s1, s2, i1+1, i2, storage), longestCommonSubsequence(s1, s2, i1, i2+1, storage));
        storage[i1][i2] = result;

        return result;
    }
}