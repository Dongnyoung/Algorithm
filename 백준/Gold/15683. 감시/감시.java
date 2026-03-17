import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class CCTV{
        int x,y;
        int type;
        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int[][][] dirs = {
            {},
            {{1},{0},{3},{2}},
            {{0,1},{2,3}},
            {{0,2},{0,3},{1,2},{1,3}},
            {{0,1,2},{0,1,3},{0,2,3},{1,2,3}},
            {{0,1,2,3}}
    };
    static List<CCTV> cctvs;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N][M];
        cctvs = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] != 0 && graph[i][j]!=6){
                    cctvs.add(new CCTV(i,j,graph[i][j]));
                }
            }
        }

        ans=Integer.MAX_VALUE;
        dfs(0,graph);
        System.out.println(ans);

    }
    private static void dfs(int depth, int[][] board){
        if(depth == cctvs.size()){
            int cnt = count(board);
            ans = Math.min(ans,cnt);
            return;
        }
        CCTV cctv = cctvs.get(depth);

        for(int[] dir : dirs[cctv.type]){
            //방향에따른  회전들 탐색
            int[][] copy = copyBoard(board);
            for(int d : dir){
                //해당 방향에대한 감시
                watch(copy,cctv.x,cctv.y,d);
            }
            dfs(depth+1,copy);
        }

    }
    private static int[][] copyBoard(int[][] board){
        int[][] copy = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
    private static void watch(int[][] copy, int  x, int y, int d){
        int nx = x+dx[d];
        int ny = y+dy[d];

        //감시
        while(nx>=0 && ny>=0 && nx<copy.length && ny<copy[0].length && copy[nx][ny]!=6){
              copy[nx][ny] =-1;
            

            nx +=dx[d];
            ny +=dy[d];
        }
    }
    private static int count(int[][] board){
        int cnt=0;
        //int w =0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] ==0){
                    cnt++;
                }

            }
        }
       // System.out.println(w);
        return cnt;
    }
}