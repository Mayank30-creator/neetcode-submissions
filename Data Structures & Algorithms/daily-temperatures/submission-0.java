class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--){

            while(!s.isEmpty() && temperatures[i]>=s.peek().first){
                s.pop();
            }
            if(s.isEmpty()){
                result[i]=0;
            }
            else{
                result[i]=s.peek().second - i;
            }

            s.push(new Pair(temperatures[i],i));
        }
        return result;
    }
}
