class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int max=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            while(set.contains(ch) && left < right){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            max = Math.max(max, (right-left)+1);
        }
        return max;
    }
}