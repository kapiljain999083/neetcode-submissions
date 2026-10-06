class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temp[j] > temp[i]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
