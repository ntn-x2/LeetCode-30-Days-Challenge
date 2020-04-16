class Solution {

    public boolean checkValidString(String s) {
        int minOpenBrackets = 0;
        int maxOpenBrackets = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);

            minOpenBrackets += currentSymbol == '(' ? 1 : -1;           // * can be a ) -> minOpenBrackets--
            maxOpenBrackets += currentSymbol != ')' ? 1 : -1;           // * can be a ( -> maxOpenBrackets++

            if (maxOpenBrackets < 0) {
                return false;
            }
            minOpenBrackets = Math.max(minOpenBrackets, 0);
        }

        return minOpenBrackets == 0;
    }
    
}