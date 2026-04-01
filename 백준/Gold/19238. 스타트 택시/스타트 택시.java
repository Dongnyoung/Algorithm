import java.util.*;

public class Main {

    static class Person{
        int x,y,shortDistance,endX,endY;
        public Person(int x,int y,int shortDistance,int endX,int endY){
            this.x = x;
            this.y = y;
            this.shortDistance = shortDistance;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static class Taxi{
        int x,y,fuel;
        public Taxi(int x,int y,int fuel){
            this.x = x;
            this.y = y;
            this.fuel = fuel;
        }
    }

    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int N,M;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int fuel = sc.nextInt();

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int startTaxiX = sc.nextInt()-1;
        int startTaxiY = sc.nextInt()-1;
        Taxi taxi = new Taxi(startTaxiX, startTaxiY, fuel);

        List<Person> q = new ArrayList<>();
        for(int i=0;i<M;i++){
            int startX = sc.nextInt()-1;
            int startY = sc.nextInt()-1;
            int endX = sc.nextInt()-1;
            int endY = sc.nextInt()-1;
            q.add(new Person(startX, startY, 0, endX, endY));
        }


        boolean flag = true;


        for(int turn=0;turn<M;turn++){
            int[][] dist = set(graph, taxi);

            int idx = -1;
            int bestDist = Integer.MAX_VALUE;

            for(int i = 0; i < q.size(); i++){
                Person p = q.get(i);
                int d = dist[p.x][p.y];

                if(d == -1) continue;

                if(d < bestDist){
                    bestDist = d;
                    idx = i;
                } else if(d == bestDist){
                    Person selected = q.get(idx);
                    if(p.x < selected.x || (p.x == selected.x && p.y < selected.y)){
                        idx = i;
                    }
                }
            }
            if(idx==-1){
                flag =false;
                break;
            }
            Person p = q.get(idx);
            int ridingFuel = dist[p.x][p.y];
            if (ridingFuel == -1 || taxi.fuel < ridingFuel) {
                flag = false;
                break;
            }

            taxi.fuel -= ridingFuel;
            taxi.x = p.x;
            taxi.y = p.y;

            int movingFuel = bfs(p,graph);
            if (movingFuel == -1 || taxi.fuel < movingFuel) {
                flag = false;
                break;
            }

            taxi.fuel -= movingFuel;
            taxi.fuel += (movingFuel * 2);
            taxi.x = p.endX;
            taxi.y = p.endY;
            q.remove(idx);


        }

        if(flag){
            System.out.println(taxi.fuel);
        }
        else{
            System.out.println(-1);
        }
    }

    private static int call(Taxi taxi,Person p,int[][] graph){
        ArrayDeque<Taxi> moveTaxi = new ArrayDeque<>();
        moveTaxi.add(new Taxi(taxi.x,taxi.y,0));

        boolean[][] visited = new boolean[N][N];
        visited[taxi.x][taxi.y] = true;

        while(!moveTaxi.isEmpty()){
            Taxi cur = moveTaxi.poll();

            if(cur.x == p.x && cur.y == p.y){
                return cur.fuel;
            }

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }
                if(graph[nx][ny] == 1){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }

                visited[nx][ny] = true;
                moveTaxi.add(new Taxi(nx,ny,cur.fuel+1));
            }
        }
        return -1;
    }

    private static int bfs(Person p,int[][] graph){
        ArrayDeque<Taxi> moveTaxi = new ArrayDeque<>();
        moveTaxi.add(new Taxi(p.x,p.y,0));

        boolean[][] visited = new boolean[N][N];
        visited[p.x][p.y] = true;

        while(!moveTaxi.isEmpty()){
            Taxi taxi = moveTaxi.poll();

            if(taxi.x == p.endX && taxi.y == p.endY){
                return taxi.fuel;
            }

            for(int i=0;i<4;i++){
                int nx = taxi.x + dx[i];
                int ny = taxi.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }
                if(graph[nx][ny] == 1){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }

                visited[nx][ny] = true;
                moveTaxi.add(new Taxi(nx,ny,taxi.fuel+1));
            }
        }
        return -1;
    }

    private static int[][] set(int[][] graph, Taxi taxi){
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], -1);
        }

        ArrayDeque<Taxi> q = new ArrayDeque<>();
        q.add(new Taxi(taxi.x, taxi.y, 0));
        dist[taxi.x][taxi.y] = 0;

        while(!q.isEmpty()){
            Taxi cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(graph[nx][ny] == 1) continue;
                if(dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Taxi(nx, ny, 0));
            }
        }

        return dist;
    }
}