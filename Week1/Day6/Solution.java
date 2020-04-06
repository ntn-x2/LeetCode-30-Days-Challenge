class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagrams = new HashMap<>(strs.length);

        for (int i = 0; i < strs.length; i++) {
            char[] strToChar = strs[i].toCharArray();
            Arrays.sort(strToChar);
            int hashValue = String.valueOf(strToChar).hashCode();

            List<String> existingAnagrams = anagrams.getOrDefault(hashValue, new LinkedList<String>());
            existingAnagrams.add(strs[i]);
            anagrams.put(hashValue, existingAnagrams);
        }

        List<List<String>> result = new LinkedList<>();

        for (List<String> an: anagrams.values()) {
            result.add(an);
        }

        return result;
    }
}