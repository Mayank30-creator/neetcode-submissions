class Solution {
    public boolean isPalindrome(String s) {
       int left = 0;                  // Start from the beginning
        int right = s.length() - 1;    // Start from the end

        while (left < right) {

            while(left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))){
                    left++;
                   }

            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move towards the middle
            left++;
            right--;
        }

        // All letters matched
        return true;
    }
}
