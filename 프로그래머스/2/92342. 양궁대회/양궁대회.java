class Solution {
    private static int appeach[];
    private static int max;
    private static int answer[];
    //계산
    private static int getScore(int[] ryan){
        int score=0;
        for(int i=0;i<=10;i++){
            if(ryan[i]+appeach[i]>0){
                score += ryan[i]> appeach[i] ? (10-i) :  -(10-i);
            }
        }
        return score;
    }
    
    //최대차이, 과녁 저장
    private static void calculateDiff(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        }
        else if(max >0 && max == score){
            for(int i=10;i>=0;i--){
                if(answer[i] != ryan[i]){
                    if(answer[i]<ryan[i]){
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    
    //백트래킹
    private static void backtrack(int n, int idx, int[] ryan){
        if(n==0){
            calculateDiff(ryan);
            return;
        }
        for(int i=idx; i<=10;i++){
            int cnt = Math.min(n,appeach[i]+1);
            ryan[i] = cnt;
            backtrack(n-cnt,i+1,ryan);
            ryan[i] = 0;
        }
    }
    public int[] solution(int n, int[] info) {
        appeach = info;
        max = 0;
        backtrack(n,0,new int[11]);
        return max ==0 ? new int[]{-1} : answer;
    }
}