class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int curr=0;
        int max=0;
        int i=0;
        int j=0;
        int n = s.length();
        while(i<n){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(j < i && set.contains(ch)){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
            curr = (i-j) +1;
            i++;
            set.add(ch);
            max = Math.max(curr, max);
        }
        return max;
    }
}
