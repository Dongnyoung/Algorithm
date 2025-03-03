class Solution {
    //직선
    private static boolean[] straight;
    //대각선
    private static boolean[] dialog1;
    private static boolean[] dialog2;
    
    private static int answer;
    private static int N;
    private static void backtrack(int y){
        
        if(y==N){
            answer++;
            return;
        }
        //직선,대각선 체크
        for(int x=0;x<N;x++){
            if(straight[x] || dialog1[x+y] || dialog2[x-y+N]){
                continue;
            }
            straight[x] = dialog1[x+y] = dialog2[x-y+N] = true;
            backtrack(y+1);
            straight[x] = dialog1[x+y] =dialog2[x-y+N] = false;
        }
    }
    public int solution(int n) {
        N=n;
        answer=0;
        straight = new boolean[N];
        dialog1 = new boolean[2*N];
        dialog2 = new boolean[2*N];
        backtrack(0);
        return answer;
    }
}