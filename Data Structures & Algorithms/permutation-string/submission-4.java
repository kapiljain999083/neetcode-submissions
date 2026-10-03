class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int freq[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int wIndx = 0, idx = i;
            int wFreq[] = new int[26];
            while (wIndx < s1.length() && idx < s2.length()) {
                wFreq[s2.charAt(idx) - 'a']++;
                idx++;
                wIndx++;
            }
            if (isFreqSame(freq, wFreq)) {
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
