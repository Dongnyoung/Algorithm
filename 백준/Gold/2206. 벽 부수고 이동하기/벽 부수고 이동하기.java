import java.util.*;

public class Main {
    static class Node{
        int x,y,broken,dist;

        Node(int x, int y,int broken, int dist){
            this.x=x;
            this.y=y;
            this.broken=broken;
            this.dist=dist;
        }
    }
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int[][][] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String line = sc.next();
            for(int j=0;j<M;j++){
                graph[i][j] = line.charAt(j)-'0';
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0,1));
        visited[0][0][0]=true;
        boolean flag = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x==N-1 && cur.y==M-1){
                System.out.println(cur.dist);
                flag = false;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx<0||ny<0||nx>=N || ny>=M){
                    continue;
                }

                if(graph[nx][ny]==1 && cur.broken==0 && !visited[nx][ny][1]){
                    q.add(new Node(nx,ny,1,cur.dist+1));
                    visited[nx][ny][1] =true;

                }
                if(graph[nx][ny]==0 && !visited[nx][ny][cur.broken]){
                    q.add(new Node(nx,ny,cur.broken,cur.dist+1));
                    visited[nx][ny][cur.broken] = true;

                }
            }
        }
        if(!flag){
            return;
        }
        else{
            System.out.println(-1);
        }
    }
}