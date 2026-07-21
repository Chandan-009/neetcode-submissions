class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ) {
                int y= Integer.parseInt(stack.pop());
                int x= Integer.parseInt(stack.pop());
                int z=0;
                if(s.equals("+")){
                    z=x+y;
                }
                if(s.equals("-")){
                    z=x-y;
                }
                if(s.equals("*")){
                    z=x*y;
                }
                if(s.equals("/")){
                    z=x/y;
                }
                stack.push(z+"");
            }
            else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
