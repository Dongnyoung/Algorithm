import java.util.*;

public class Main {
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static List<Node> empties;
    static int max=0;
    static List<Node> viruses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];

        empties = new ArrayList<>();
        viruses = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] ==0){
                    empties.add(new Node(i,j));
                }
                else if(graph[i][j] ==2){
                    viruses.add(new Node(i,j));
                }
            }
        }
        dfs(0,0,new Node[3]);
        System.out.println(max);
    }
    static void dfs(int start, int depth, Node[] pick){

        if(depth == 3){
            int size = sizeCheck(pick);
            max = Math.max(max, size);
            return;
        }

        for(int i=start; i<empties.size(); i++){

            pick[depth] = empties.get(i);

            dfs(i+1, depth+1, pick);
        }
    }
    static int sizeCheck (Node[] nums){
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp[i][j] = graph[i][j];
            }
        }
        for(Node n : nums){
            temp[n.x][n.y] = 1;
        }
        bfs(temp);
        int sum=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j] ==0){
                    sum+=1;
                }
            }
        }

        return sum;

    }
    static void bfs(int[][] temp){
        ArrayDeque<Node> q = new ArrayDeque<>();
        for(Node virus:viruses){
            q.add(virus);
        }

        boolean visited[][] = new boolean[N][M];

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M){
                    continue;
                }
                if(temp[nx][ny]==1){
                    continue;
                }
                if(!visited[nx][ny] && temp[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.add(new Node(nx,ny));
                    temp[nx][ny] =2;

                }
            }
        }

    }
}