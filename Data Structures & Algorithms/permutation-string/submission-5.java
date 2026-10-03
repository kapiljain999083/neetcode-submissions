class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int freq[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int windowIndex = 0, idx = i;
            int windowFreq[] = new int[26];
            while (windowIndex < s1.length() && idx < s2.length()) {
                windowFreq[s2.charAt(idx) - 'a']++;
                idx++;
                windowIndex++;
            }
            if (isFreqSame(freq, windowFreq)) {
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
