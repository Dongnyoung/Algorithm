import java.util.*;

class Solution {
    //큐에 들어가야할건 좌표와 비용
    private static class Node{
        int x,y,cost;
        public Node(int x, int y , int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    //방향설정
    private static int[] rx ={0,0,1,-1};
    private static int[] ry ={1,-1,0,0};
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        boolean visited[][] = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(0,0,0));
        int result=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.x][now.y]){
               continue; 
            }
            visited[now.x][now.y] = true;
            result+=now.cost;
            for(int i=0; i<4;i++){
                int dx = now.x+rx[i];
                int dy = now.y+ry[i];
                
                if(dx>=0 && dx<n && dy>=0 && dy<n && !visited[dx][dy]){
                    int newCost = Math.abs(land[dx][dy]-land[now.x][now.y]);
                    int heightCost = height >= newCost ? 0 : newCost;
                    pq.add(new Node(dx,dy,heightCost));
                }
            }
           
        }
        return result;
        
        
        
    }
}
