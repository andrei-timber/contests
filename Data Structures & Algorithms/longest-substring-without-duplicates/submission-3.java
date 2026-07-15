class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int l = 0, maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            while (chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
