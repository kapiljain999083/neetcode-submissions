class Solution {
    public boolean isPalindrome(String s) {
        int left=0, right = s.length() -1;
        s = s.toLowerCase();
        while(left<right){
            int leftVal  = s.charAt(left);
            if(!(leftVal >= 97 && leftVal <= 122) && !(leftVal >= 48 && leftVal <= 57)){
                left++;
                continue;
            }
            int rightVal = s.charAt(right); // 48-57
            if(!(rightVal >= 97 && rightVal <= 122) && !(rightVal >= 48 && rightVal <= 57)){
                right--;
                continue;
            }
            if(leftVal != rightVal){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}