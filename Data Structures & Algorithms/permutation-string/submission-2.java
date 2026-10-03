class Solution {
    public boolean checkInclusion(String s2, String s1) {
        if(s2.length() > s1.length()) return false;
        char[] ch = s2.toCharArray();
        Arrays.sort(ch);
        int n = s1.length();
        String newString = new String(ch);
        Set<String> set = new HashSet<>();
        int left = 0, right = s2.length();
        while (right <= n) {
            String s = s1.substring(left,right);
            char c [] = s.toCharArray();
            Arrays.sort(c);
            set.add(new String(c));
            if(set.contains(newString)) return true;
            left++;
            right++;
        }
        return false;
    }
}
