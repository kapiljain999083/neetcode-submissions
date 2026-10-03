class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int freq[] = new int[26];
        int freq2[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if(isFreqSame(freq, freq2)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
           freq2[s2.charAt(i) - 'a']++;
           freq2[s2.charAt(i - s1.length()) - 'a']--;
            if (isFreqSame(freq, freq2)) {
                return true;
            }
        }
        return false;
    }

     public boolean isFreqSame(int arr[], int arr2[]) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != arr2[i]) return false;
        }
        return true;
    }
}
