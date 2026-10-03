class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int max=0;
        int n = s.length();
        int left=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int right =i;
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
