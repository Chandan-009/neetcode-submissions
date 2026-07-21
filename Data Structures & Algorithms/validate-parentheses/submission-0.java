class Solution {
    public boolean isValid(String st) {
        Stack<Character> s=new Stack<>();
        for(char c:st.toCharArray()) {
            if(c=='{' || c=='(' || c=='['){
                s.push(c);
            }
            else {
                if(s.isEmpty()) return false;
                if(c=='}'){
                    if(s.peek()!='{')
                      return false;
                    else
                     s.pop();
                }
                if(c==')'){
                    if(s.peek()!='(')
                      return false;
                    else
                     s.pop();
                }
                if(c==']'){
                    if(s.peek()!='[')
                      return false;
                    else
                     s.pop();
                }
            }
        }
        if(s.isEmpty())
           return true;
        else
          return false;
    }

}
