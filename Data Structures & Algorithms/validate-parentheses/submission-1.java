class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(isOpen(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()) return false;
                if(!isSame(stack.pop(), s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    boolean isOpen(char ch){
        return ch =='(' || ch =='{' || ch =='[';
    }

    boolean isSame(char ch, char ch2){
        return ch=='(' && ch2 == ')' ||
                ch=='{' && ch2 == '}' ||
                ch=='[' && ch2 == ']';
    }
}
