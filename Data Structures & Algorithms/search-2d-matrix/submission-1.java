class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int l =0, r = (n*m)-1;
        while(l <= r){
            int mid = (l+r)/2;
            int row=mid/m;
            int col=mid%m;
            if (arr[row][col] == target){
                return true;
            }
            if(arr[row][col] < target){
                l = mid+1;
            }else{
                r= mid-1;
            }
        }
        return false;
    }
}