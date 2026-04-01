import java.util.*;

public class Main {

    static class Node{
        int x,y,floor,time;
        Node(int x,int y,int floor,int time){
            this.x=x;
            this.y=y;
            this.floor = floor;
            this.time = time;
        }
    }

    static int dx[] = {-1,1,0,0,0,0};
    static int dy[] ={0,0,-1,1,0,0};
    static int df[] = {0,0,0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int L = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            if(L ==0 && R ==0 && C ==0){
                break;
            }
            char[][][] graph = new char[L][R][C];
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][][] visited = new boolean[L][R][C];
            int startX = 0;
            int startY = 0;
            int startFloor = 0;
            int endX = 0;
            int endY = 0;
            int endFloor = 0;
            for(int i=0;i<L;i++){
                for(int j=0;j<R;j++){
                    String line = sc.next();
                    for(int k=0;k<line.length();k++){
                        graph[i][j][k] = line.charAt(k);
                        if(graph[i][j][k]=='S'){
                            startFloor = i;
                            startX = j;
                            startY = k;
                        }
                        else if(graph[i][j][k]=='E'){
                            endFloor = i;
                            endX = j;
                            endY = k;
                        }
                    }
                }
            }
            q.add(new Node(startX,startY,startFloor,0));
            visited[startFloor][startX][startY] = true;

            boolean flag = false;
            while(!q.isEmpty()){
                Node cur = q.poll();
                if(cur.floor == endFloor && cur.x==endX && cur.y==endY){
                    System.out.println("Escaped in " +cur.time + " minute(s).");
                    flag = true;
                    break;
                }

                for(int i=0;i<6;i++){
                    int nf = cur.floor+df[i];
                    int nx = cur.x+dx[i];
                    int ny = cur.y+dy[i];
                    if(nf>=L || nf<0 || nx<0 || ny<0 || nx>=R || ny>=C){
                        continue;
                    }
                    if(visited[nf][nx][ny]){
                        continue;
                    }
                    if(graph[nf][nx][ny] == '#'){
                        continue;
                    }

                    visited[nf][nx][ny] = true;
                    q.add(new Node(nx,ny,nf,cur.time+1));
                }
            }
            if(flag == false){
                System.out.println("Trapped!");
            }

        }
    }
}