class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for(int i=0;i<s.length(); i++){
            if(isOpening(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty() && isSame(st.peek(), s.charAt(i))){
                    st.pop();
                }else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    boolean isSame(char ch, char ch2){
        return (ch =='(' && ch2 ==')') 
            || (ch =='[' && ch2 ==']') 
            || (ch =='{' && ch2 =='}') ;
    }

    boolean isOpening(char ch){
        return ch =='(' || ch =='[' || ch =='{';
    }
}
