class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int startIdx = 0;
        int currIdx = 0;
        int maxLength = 0;
        for (char ch : s.toCharArray()) {
            if (!chars.contains(ch)) {
                chars.add(ch);
            } else {
                maxLength = Math.max(maxLength, currIdx - startIdx);
                while (s.charAt(startIdx) != ch) {
                    chars.remove(s.charAt(startIdx));
                    startIdx++;
                }
                startIdx++;
            }
            currIdx++;
        }
        return Math.max(maxLength, currIdx - startIdx);
    }
}
