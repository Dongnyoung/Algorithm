class Solution {
    public int solution(int n) {
        int answer = 0;
        //자연수 1 부터 시작을 한다고 가정해보면..
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=i;j<=n;j++){
                sum +=j;
                //System.out.println(sum);
                if(sum==n){
                    //System.out.println(i+": " +sum);
                    answer++;
                    break;
                }
                if(sum>n){
                    break;
                }
                
            }
        }
        return answer;
    }
}