import java.util.*;
class Solution {
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;
    static int[][] graph;
    static boolean[][] comp;
    static int[][] group;
    static int[] oil;
    static boolean[][] visited;
    public int solution(int[][] land) {
        N=land.length;
        M=land[0].length;
        graph = land;
        int max=0;
        oil = new int[M];
        visited=new boolean[N][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(graph[j][i]!=0 && !visited[j][i]){
                    bfs(new Node(j,i));
                 
                }
            }
            
        }
        
        for(int o:oil){
            max = Math.max(max,o);
        }
        
        return max;
    }
    
    static void bfs(Node n){
        int width=1;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(n);
        
        visited[n.x][n.y] = true;
        boolean[] cols = new boolean[M];
        cols[n.y] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                if(graph[nx][ny]==0){
                    continue;
                }
                q.add(new Node(nx,ny));
                visited[nx][ny]=true;
                width++;
                cols[ny] = true;
            }
        }
        for(int i=0;i<M;i++){
            if(cols[i]){
                oil[i] +=width;
            }
        }
    }
    
}

    