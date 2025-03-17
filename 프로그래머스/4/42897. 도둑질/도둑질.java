class Solution {
    public int solution(int[] money) {
        //점화식 dp[i] = Math.max(dp[i-1],dp[i-2]+money[i])
        int n= money.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],money[1]);
        //첫번째 항을 고르면 맨마지막항을 고르면 안됨
        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+money[i]);
        }
        
        dp2[1] =money[1];
        //첫번째 항 안고르면 
        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+money[i]);
        }
        return Math.max(dp2[n-1],dp1[n-2]);
    }
}