import java.util.*;

public class Main {

    static class Stone{
        int a,b,c;
        public Stone(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }

    static int dx[] = {-1,1,0,0,0,0};
    static int dy[] ={0,0,-1,1,0,0};
    static int df[] = {0,0,0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(bfs(A,B,C)? 1:0);


    }
    static boolean bfs(int a,int b,int c){
        if((a+b+c)%3!=0){
            return false;
        }
        ArrayDeque<Stone> q = new ArrayDeque<>();
        q.add(new Stone(a,b,c));
        boolean[][] visited = new boolean[1501][1501];
        while(!q.isEmpty()){
            Stone s = q.poll();
            if(s.a == s.b && s.b == s.c){
                return true;
            }

            if(s.a!=s.b){
                int nx=0;
                int ny=0;
                if(s.a>s.b){
                    int x = s.b;
                    int y = s.a;

                    nx = 2*x;
                    ny =y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(ny,nx,s.c));

                    }
                }
                else{
                    int x = s.a;
                    int y = s.b;
                    nx = 2*x;
                    ny =y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(nx,ny,s.c));
                    }
                }
            }
            if(s.b!=s.c){
                int nx=0;
                int ny=0;
                if(s.b>s.c){
                    //a가 x, b가 y
                    int x = s.c;
                    int y = s.b;
                    nx= x*2;
                    ny= y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(s.a,ny,nx));
                    }
                }
                else{
                    int x = s.b;
                    int y = s.c;
                    nx= x*2;
                    ny= y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(s.a,nx,ny));
                    }
                }
            }
            if(s.a!=s.c){
                int nx=0;
                int ny=0;
                if(s.a>s.c){
                    //a가 x, b가 y
                    int x = s.c;
                    int y = s.a;
                    nx= x*2;
                    ny= y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(ny,s.b,nx));
                    }
                }
                else{
                    int x = s.a;
                    int y = s.c;
                    nx= x*2;
                    ny= y-x;
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Stone(nx,s.b,ny));
                    }
                }
            }
        }
        return false;
    }
}