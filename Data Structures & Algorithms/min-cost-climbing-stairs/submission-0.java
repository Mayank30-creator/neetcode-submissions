class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(
            solve(0,cost,n,dp), solve(1,cost,n,dp));
    }

    int solve(int i,int cost[],int n,int[] dp){    
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        return dp[i] = cost[i] + Math.min(solve(i+1,cost,n,dp),solve(i+2,cost,n,dp));
    }
}