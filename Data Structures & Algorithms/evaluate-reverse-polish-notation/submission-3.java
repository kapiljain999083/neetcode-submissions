class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            if(!isOperations(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int n1= stack.pop();
                int n2 = stack.pop();
                if(tokens[i].equals("*")){
                    stack.push(n1 * n2);
                }else if(tokens[i].equals("/")){
                    stack.push(n2 / n1);
                }else if(tokens[i].equals("+")){
                    stack.push(n1 + n2);
                }else {
                    stack.push(n2 - n1);
                }
            }
        }
        return stack.pop();
    }

    boolean isOperations(String ch){
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    }
}
