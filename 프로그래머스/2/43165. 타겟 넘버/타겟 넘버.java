class Solution {
    static int answer;
    static int T;
    static int n;
    static boolean visited[];
    static int[] nums;
    public int solution(int[] numbers, int target) {
        answer = 0;
        T = target;
        n = numbers.length;
        nums = numbers;
        dfs(0,0,0);
        return answer;
    }
    static private void dfs(int start, int depth,int sum){
        if(depth == n){
            if(sum==T){
                answer++;
                
            }
            return;
        }
        
        
            
            dfs(start+1,depth+1,sum+nums[start]);
            dfs(start+1,depth+1,sum-nums[start]);
        }
}