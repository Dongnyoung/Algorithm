import java.util.*;
class Solution {
    static int[] dx ={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length();
        char[][] graph = new char[N][M];
        int startX =0;
        int startY = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                graph[i][j] = board[i].charAt(j);
                if(graph[i][j] == 'R'){
                    startX = i;
                    startY = j;
                    //System.out.println(i+" "+j);
                }
            }
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(startX,startY));
        int dist[][] = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i],-1);
        }
        
        dist[startX][startY] = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(graph[cur.x][cur.y]=='G'){
                answer = dist[cur.x][cur.y];
                break;
            }
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                while(true){
                    
                    if(nx<0||ny<0||nx>=N || ny>=M){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                    if(graph[nx][ny]=='D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                    
                    nx+=dx[i];
                    ny+=dy[i];
                }
                if(dist[nx][ny]!=-1) continue;
                q.add(new Node(nx,ny));
                dist[nx][ny] = dist[cur.x][cur.y]+1;
                
            }
        }
        
        return answer==0 ? -1:answer;
    }
}