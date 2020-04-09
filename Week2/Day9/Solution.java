class Solution {
    
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;

        int backSpacesS = 0;
        int backSpacesT = 0;

        while (i >= 0 || j >= 0) {
            boolean visitedS = false;
            boolean visitedT = false;

            if (i >= 0) {
                if (S.charAt(i) == '#') {
                    backSpacesS += 1;
                    i--;
                    visitedS = true;
                } else if (backSpacesS > 0) {
                    i--;
                    backSpacesS--;
                    visitedS = true;
                }
            }

            if (j >= 0) {
                if (T.charAt(j) == '#') {
                    backSpacesT += 1;
                    j--;
                    visitedT = true;
                } else if (backSpacesT > 0) {
                    j--;
                    backSpacesT--;
                    visitedT = true;
                }
            }

            if (!visitedS && !visitedT) {
                if (i >= 0 && j >= 0) {
                    if (S.charAt(i) != T.charAt(j)) {
                        return false;
                    } else {
                        i--;
                        j--;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}