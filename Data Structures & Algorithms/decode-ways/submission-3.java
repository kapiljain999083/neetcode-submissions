class Solution {
    public int numDecodings(String s) {
        if(s == null || s.charAt(0) == '0') return 0;
        int n = s.length();
        int dp[] = new int[n];
        dp[0]=1;
        for(int i =1; i<n;i++){
            if(s.charAt(i) !='0'){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-1) =='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){
               if(i==1){
                  dp[i] +=1;
                }else{
                   dp[i] += dp[i-2];
                }
            }
        }
        return dp[n-1];
    }
}