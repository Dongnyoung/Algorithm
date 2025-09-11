import java.util.*;

class Main{
    static int rx[] = {0,0,-1,1};
    static int ry[] = {1,-1,0,0};
    static final int INF = 1000000000;
    private static class Node{
        int x,y;
        int time;
        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static char graph[][];
    static int tVisited[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        graph = new char[R][C];
        for(int i = 0; i < R; i++){
            String line = scan.next();
            for(int j = 0; j < C; j++){
                graph[i][j] = line.charAt(j);
            }
        }
        int endX = 0;
        int endY = 0;
        int startX=0;
        int startY=0;
        ArrayDeque<Node> waterQ = new ArrayDeque<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(graph[i][j] == 'D'){
                    endX = i;
                    endY = j;
                }
                else if(graph[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                else if(graph[i][j] == '*'){
                    waterQ.add(new Node(i, j, 0));
                }
            }
        }

        tVisited = new int[R][C];
        for(int i=0; i < R; i++){Arrays.fill(tVisited[i], INF);}
        for(Node w : waterQ){
            tVisited[w.x][w.y] = 0;
        }
        ArrayDeque<Node> wQ = new ArrayDeque<>(waterQ);
        while(!wQ.isEmpty()){
            Node w = wQ.poll();
            for(int i=0;i<4;i++){
                int wx = w.x + rx[i];
                int wy = w.y + ry[i];
                int wt = w.time+1;
                if(wx<0 || wx>=R || wy<0 || wy>=C){
                    continue;
                }
                if(graph[wx][wy] == 'D'|| graph[wx][wy] == 'X'||graph[wx][wy] == 'S'){
                    continue;
                }
                if(tVisited[wx][wy]<=wt) {
                    continue;
                }
                tVisited[wx][wy]=wt;
                wQ.add(new Node(wx, wy, wt));

            }
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        int time=  0;
        q.add(new Node(startX,startY,time));
        visited[startX][startY] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == endX && now.y == endY){
                System.out.println(now.time);
                return;
            }
            for(int i = 0; i < 4; i++){
                int dx = now.x+rx[i];
                int dy = now.y+ry[i];
                int dt = now.time+1;
                if(dx < 0 || dx >= R || dy < 0 || dy >= C){
                    continue;
                }
                if(graph[dx][dy] == 'X' || visited[dx][dy]){
                    continue;
                }
                if(tVisited[dx][dy]<=dt){
                    continue;
                }
                visited[dx][dy] = true;
                q.add(new Node(dx, dy, dt));
            }
        }
        System.out.println("KAKTUS");
    }
}
