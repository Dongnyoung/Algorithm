class Solution {
    static int[] nums;
    static int answer=0;
    public int solution(int[] number) {
        backtrack(number,0,0,0);
        return answer;
    }
    static void backtrack(int[] number, int start, int depth, int sum){
        if(depth==3){
            if(sum==0){
                answer++;
            }
            return;
        }
        for(int i=start;i<number.length;i++){
            backtrack(number,i+1,depth+1,sum+number[i]);
        }
        
    }
}