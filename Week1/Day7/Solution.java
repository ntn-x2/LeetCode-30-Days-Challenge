class Solution {
    
    public int countElements(int[] arr) {
        Set<Integer> values = new HashSet<>(arr.length);
        
        for (int element: arr) {
            values.add(element);
        }
        
        int count = 0;
        
        for (int element: arr) {
            count += values.contains(element+1) ? 1 : 0;
        }
        
        return count;
    }
}