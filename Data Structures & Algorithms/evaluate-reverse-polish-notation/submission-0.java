class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int n = tokens.length;
        for(String token:tokens){

                if(token.equals("+")){
                    s.push(s.pop()+s.pop());
                }
                else if(token.equals("-")){
                    int a=s.pop();
                    int b=s.pop();
                    s.push(b-a);
                }
                else if(token.equals("/")){
                    int a=s.pop();
                    int b=s.pop();
                    s.push(b/a);
                }
                else if(token.equals("*")){
                    s.push(s.pop()*s.pop());
                }
                else{
                    s.push(Integer.valueOf(token));
                }
            
            
        }
        return s.pop();
        
    }
}
