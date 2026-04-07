import java.util.*;

public class Main {

    static class Group{
        int size,x,y,rainbow;
        List<int[]> cell;
        Group(int size,int x,int y,int rainbow,List<int[]> cell){
            this.size=size;
            this.x=x;
            this.y=y;
            this.rainbow=rainbow;
            this.cell=cell;
        }
    }

    static int[] dx={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();

            }
        }


        int score=0;
        while(true){
            List<Group> list = find();
            if(list.isEmpty()){
                break;
            }
            Collections.sort(list,(o1,o2)->{
               if (o1.size!=o2.size){
                   return Integer.compare(o2.size,o1.size);
               }
               if(o1.rainbow!=o2.rainbow){
                   return Integer.compare(o2.rainbow,o1.rainbow);
               }
               if(o1.x != o2.x){
                   return Integer.compare(o2.x,o1.x);
               }
               return Integer.compare(o2.y,o1.y);
            });
            Group g = list.get(0);
            //System.out.println(g.size);
            score += (g.size*g.size);

            remove(g);
            gravity();
            rotate();
            gravity();
        }
        System.out.println(score);




    }
    static void remove(Group g){
        List<int[]> list = g.cell;
        for(int[] c : list){
            graph[c[0]][c[1]]=-2;
        }
    }
    static List<Group> find(){
        List<Group> list = new ArrayList<>();

        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]>0 && !visited[i][j]){
                    Group g = bfs(i,j);
                    if(g.size>=2){
                        list.add(g);
                    }

                }
            }
        }




        return list;
    }
    static Group bfs(int x,int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<int[]> rainbowList = new ArrayList<>();
        List<int[]> cell = new ArrayList<>();
        cell.add(new int[]{x,y});
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int rainbowCount =0;
        int size=1;
        int color = graph[x][y];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int k=0;k<4;k++){
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                if(graph[nx][ny]==-1 || graph[nx][ny]==-2){
                    continue;
                }
                if(graph[nx][ny]==0){
                    rainbowCount++;
                    q.add(new int[]{nx,ny});
                    rainbowList.add(new int[]{nx,ny});
                    cell.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    size++;
                }
                else if(graph[nx][ny]==color){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    cell.add(new int[]{nx,ny});
                    size++;
                }

            }
        }
        for(int[] rainbow : rainbowList){
            visited[rainbow[0]][rainbow[1]] = false;
        }
        Group g = new Group(size,x,y,rainbowCount,cell);
        return g;
    }
    static void gravity(){
        for(int j=0;j<N;j++){
            int empty = N-1;
            for(int i=N-1;i>=0;i--){
                if(graph[i][j]==-1){
                    empty= i-1;
                }
                else if(graph[i][j]>=0){
                    int temp = graph[i][j];
                    graph[i][j]=-2;
                    graph[empty][j] = temp;
                    empty--;
                }
            }
        }
    }
    static void rotate(){
        int[][] temp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[N-1-j][i] = graph[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                graph[i][j] = temp[i][j];
            }
        }
    }

}