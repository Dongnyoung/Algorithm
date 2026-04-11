import java.util.*;

public class Main {

    static class Node{
        int x,y,magic,dist;
        Node(int x,int y, int magic,int dist){
            this.x=x;
            this.y=y;
            this.magic=magic;
            this.dist = dist;
        }
    }
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int startX,startY;
    static int endX,endY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        startX = sc.nextInt()-1;
        startY = sc.nextInt()-1;
        endX = sc.nextInt()-1;
        endY = sc.nextInt()-1;
        graph = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        ArrayDeque<Node> q = new ArrayDeque<>();

        q.add(new Node(startX,startY,0,0));
        visited[startX][startY][0] = true;
        boolean flag = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x==endX && cur.y==endY){
                flag =false;
                System.out.println(cur.dist);
                break;
            }
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M){
                    continue;
                }
                //벽인경우
                if(graph[nx][ny]==1 && cur.magic==0 && !visited[nx][ny][1]){
                    //magic을 한번도 안썻어야하고, 이곳에 마법을 사용하며 지나간적이없어야함
                    q.add(new Node(nx,ny,1,cur.dist+1));
                    visited[nx][ny][1] = true;

                }
                //빈칸인경우
                if(graph[nx][ny]==0 && !visited[nx][ny][cur.magic]){
                    q.add(new Node(nx,ny,cur.magic,cur.dist+1));
                    visited[nx][ny][cur.magic] =true;
                }
            }
        }
        if(flag){
            System.out.println(-1);
        }
        else{
            return;
        }

    }
}