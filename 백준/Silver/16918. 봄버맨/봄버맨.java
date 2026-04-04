import java.util.*;

public class Main {

    static class Bomb{
        int x,y;
        Bomb(int x,int y){
            this.x=x;
            this.y=y;
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
        int N = sc.nextInt();
        ArrayDeque<Bomb> q = new ArrayDeque<>();
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
                if(graph[i][j] =='O'){
                    //1.설치
                    q.add(new Bomb(i,j));
                }
            }
        }

        //2.모든칸 설치
        int time=1;
        while(time<N){
            //모든칸설치
            installBomb();
            //printGraph();
            time+=1;
            if(time>=N){
                break;
            }
            // 3.원래설치햇던거 터짐
            while(!q.isEmpty()){
                Bomb cur = q.poll();
                graph[cur.x][cur.y]='.';
                for(int d=0;d<4;d++){
                    int nx = cur.x+dx[d];
                    int ny = cur.y+dy[d];
                    if(nx<0||ny<0||nx>=R||ny>=C){
                        continue;
                    }
                    if(graph[nx][ny]=='.'){
                        continue;
                    }
                    graph[nx][ny]='.';
                }
            }
            //printGraph();
            time+=1;
            if(time>=N){
                break;
            }
            //남은 폭탄 q에담기
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(graph[i][j]=='O'){
                        q.add(new Bomb(i,j));
                    }
                }
            }
        }
        printGraph();




    }
    static void printGraph(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
    static void installBomb(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(graph[i][j] == '.'){
                    graph[i][j]='O';
                }
            }
        }
    }
}