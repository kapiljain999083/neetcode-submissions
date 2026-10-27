class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += extract(i, i, s);
            ans += extract(i, i+1, s);
        }
        return ans;
    }

    int extract(int left, int right, String s){
        int ans=0;
        while(left >=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}
