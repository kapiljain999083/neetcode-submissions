class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int max=0;
        int i=0;
        int j=0;
        int n = s.length();
        while(i<n) {
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(j < i && set.contains(ch)){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
            max = Math.max((i-j) +1, max);
            i++;
            set.add(ch);
        }
        return max;
    }
}
