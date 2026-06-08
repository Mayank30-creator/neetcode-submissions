class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class MinStack {

    Stack<Pair>st = new Stack<>();
    

    public MinStack() {
      
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }
        else{
            int x = st.peek().second;
            if(val<x){
                st.push(new Pair(val,val));
            }
            else{
                st.push(new Pair(val,x));
            }
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
        
    }
    
    public int top() {
        return st.peek().first;
        
    }
    
    public int getMin() {
        return st.peek().second;
        
    }
}
