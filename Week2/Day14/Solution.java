class Solution {
    
    public String stringShift(String s, int[][] shift) {
        if (s.length() == 1) {
            return s;
        }
        int numberOfTotalShifts = computeTotalLeftShifts(shift, s.length());
        return s.substring(numberOfTotalShifts) + s.subSequence(0, numberOfTotalShifts);
    }

    // If total is left, returns left. If total is right, returns length - right (= left).
    private int computeTotalLeftShifts(int[][] shifts, int stringLength) {
        int count = 0;
        for (int i = 0; i < shifts.length; i++) {
            count += shifts[i][0] == 0 ? shifts[i][1] : -shifts[i][1];
        }
        return Math.floorMod(count, stringLength);
    }
}