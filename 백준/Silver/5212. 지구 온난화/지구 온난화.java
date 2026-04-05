import java.util.*;

public class Main {

    static class Node{
        int x,y,count;
        Node(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    static char[][] graph;
    static int[] dx={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static int R,C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        graph = new char[R][C];
        List<Node> list = new ArrayList<>();
        for(int i=0;i<R;i++){
            String line = sc.next();
            for(int j=0;j<C;j++){
                graph[i][j] = line.charAt(j);
                if(graph[i][j]=='X'){
                    list.add(new Node(i,j,0));
                }
            }
        }

        for(Node cur : list){
            int cnt=0;
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx<0 || ny<0 || nx>=R || ny>=C){
                    cnt++;
                    continue;
                }
                if(graph[nx][ny]=='X'){
                    continue;
                }
                cnt++;

            }
            cur.count = cnt;
        }
        for(Node cur : list){
            if(cur.count>=3){
                graph[cur.x][cur.y]='.';
            }
        }
        int startR =R;
        int endR=0;
        int startC =C;
        int endC=0;


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(graph[i][j]=='X'){
                    startR = Math.min(startR,i);
                    startC = Math.min(startC,j);
                    endR = Math.max(endR,i);
                    endC = Math.max(endC,j);
                }
            }
        }
        for(int i=startR;i<=endR;i++){
            for(int j=startC;j<=endC;j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

    }
}