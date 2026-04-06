import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x=x;
            this.y=y;

        }
    }
    static class Plus{
        int x,y,size;
        Plus(int x,int y,int size){
            this.x=x;
            this.y=y;
            this.size=size;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] graph = new char[N][M];
        List<Node> list = new ArrayList<>();
        List<Plus> plusList = new ArrayList<>();
        for(int i=0;i<N;i++){
            String line = sc.next();
            for(int j=0;j<M;j++){
                graph[i][j] = line.charAt(j);

            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j]=='*'){
                    int size=0;
                    while(true){
                        int nextSize = size+1;
                        boolean flag = true;
                        for(int d=0;d<4;d++){
                            int nx = i+dx[d]*nextSize;
                            int ny = j+dy[d]*nextSize;
                            if(nx<0 || ny<0 || nx>=N || ny>= M || graph[nx][ny]!='*'){
                                flag = false;
                                break;
                            }

                        }
                        if(flag){
                            plusList.add(new Plus(i,j,nextSize));
                            size++;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        boolean[][] visited = new boolean[N][M];
        for(Plus p: plusList){
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                for(int s =1;s<=p.size;s++){
                    int nx = p.x+dx[i]*s;
                    int ny = p.y+dy[i]*s;
                    visited[nx][ny] = true;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j]=='*'){
                    if(visited[i][j]){
                        continue;
                    }
                    else{
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if(plusList.size()==0){
            System.out.println(-1);
            return;
        }
        System.out.println(plusList.size());
        for(Plus p: plusList){
            System.out.println((p.x+1)+" "+(p.y+1)+" "+p.size);
        }

    }
}