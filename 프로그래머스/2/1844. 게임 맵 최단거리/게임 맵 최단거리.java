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
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] dist = new int[maps.length][maps[0].length];
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0));
        dist[0][0] =1;
        
                
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length){
                    continue;
                }
                if(maps[nx][ny]==0){
                    continue;
                }
                if(dist[nx][ny]==0){
                    q.add(new Node(nx,ny));
                dist[nx][ny] = dist[now.x][now.y]+1;
                }
                
            }
        }
        answer = dist[maps.length-1][maps[0].length-1];
        
        return answer == 0 ? -1:answer;
    }
}