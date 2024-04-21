class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        // Split the trimmed string by spaces
        String arr[] = s.split(" ");
        
        // Initialize the result string
        String ans = "";
        
        // Traverse the array of words in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            // Append non-empty words followed by a space (except for the last word)
            if (arr[i].length() > 0 && i != 0) {
                ans = ans + arr[i] + " ";
            }
        }
        
        // Append the first word without any trailing space
        return ans + arr[0];
    }
}
