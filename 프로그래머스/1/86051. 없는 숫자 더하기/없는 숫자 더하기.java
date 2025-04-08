class Solution {
    public int solution(int[] numbers) {
        int sum[] = {0,1,2,3,4,5,6,7,8,9};
        int answer=0;
        
        for(int i=0;i<sum.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(sum[i]==numbers[j]){
                    sum[i]-=numbers[j];
                }
            }
            answer+=sum[i];
        }
        return answer;
    }
}