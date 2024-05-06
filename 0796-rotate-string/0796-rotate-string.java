class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            s = rotateByOne(s);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }
    
    private String rotateByOne(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
