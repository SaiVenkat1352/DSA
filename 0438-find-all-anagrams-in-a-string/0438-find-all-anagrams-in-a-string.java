class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length(), m = p.length();
        if (n < m) return result;

        // Frequency arrays for pattern and current window
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

       
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window across the string
        for (int i = m; i < n; i++) {
            // Add new character to the window
            sCount[s.charAt(i) - 'a']++;

            // Remove the character going out of the window
            sCount[s.charAt(i - m) - 'a']--;

            // Compare updated window with pattern
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }
}