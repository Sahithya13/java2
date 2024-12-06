//Here's a complete, well-commented Java solution for the LeetCode problem #2047 - Number of Valid Words in a Sentence:


class Solution {
    public int countValidWords(String sentence) {
        // Split the sentence into tokens using space as the delimiter
        String[] tokens = sentence.split("\\s+");
        
        int count = 0;
        
        // Iterate through each token
        for (String token : tokens) {
            if (isValidWord(token)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isValidWord(String token) {
        int length = token.length();
        boolean hasHyphen = false;
        
        // Iterate through each character in the token
        for (int i = 0; i < length; i++) {
            char c = token.charAt(i);
            
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                return false;
            }
            
            // Check if the character is a hyphen
            if (c == '-') {
                // If a hyphen is already encountered or it is at the start/end of the token
                if (hasHyphen || i == 0 || i == length - 1) {
                    return false;
                }
                hasHyphen = true;
            }
            
            // Check if the character is a punctuation mark
            if (c == '!' || c == '.' || c == ',') {
                // If the punctuation mark is not at the end of the token
                if (i != length - 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}


