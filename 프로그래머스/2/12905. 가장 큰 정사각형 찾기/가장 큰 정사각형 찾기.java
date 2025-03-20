class Solution
{
    public int solution(int [][]board)
    {
        //행
        int row = board.length;
        //열
        int column = board[0].length;
        
        //왼쪽 대각선 위 검사를 하려면 좌표 1,1부터 시작해야함
        for(int i=1; i<row;i++){
            for(int j=1; j<column;j++){
                //왼쪽 대각선 위
                int leftUp = board[i-1][j-1];
                //위
                int up = board[i-1][j];
                //왼쪽
                int left = board[i][j-1];
                
                //1로 이루어진 정사각형을 찾는것이기에 
                if(board[i][j]==1){
                    board[i][j] = Math.min(Math.min(up,left),leftUp)+1;
                }
                continue;
            }
        }
        int answer=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                answer = Math.max(answer,board[i][j]);
            }
        }
        return answer*answer;
    }
}