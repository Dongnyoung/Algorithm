import java.util.*;

public class Main {
    static class Shark{
        int r,c,speed,direction,z;
        Shark(int r,int c,int speed,int direction,int z){
            this.r=r;
            this.c=c;
            this.speed=speed;
            this.direction=direction;
            this.z=z;
        }
    }
    static List<Shark>[][] graph;
    static List<Integer> sharksSize;
    static int R,C;
    static int dx[] = {-1,1,0,0};
    static int dy[] ={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int M = sc.nextInt();


        graph = new ArrayList[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                graph[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int speed = sc.nextInt();
            int direction = sc.nextInt();
            if (direction == 1) direction = 0;      // 위
            else if (direction == 2) direction = 1; // 아래
            else if (direction == 3) direction = 3; // 오른쪽
            else if (direction == 4) direction = 2; // 왼쪽
            int z = sc.nextInt();
            graph[r][c].add(new Shark(r,c,speed,direction,z));

        }

        sharksSize = new ArrayList<>();

        int startC = -1;
        for(int i=0;i<C;i++){

            startC++;
            searchShark(startC);
            moveShark();
            eatingShark();
        }
        int sum=0;
        for(int i=0;i<sharksSize.size();i++){
            sum += sharksSize.get(i);
        }
        System.out.println(sum);
    }
    private static void searchShark(int startC){
        for(int i=0;i<R;i++){
            if(graph[i][startC].isEmpty()){
                continue;
            }
            else{
                sharksSize.add(graph[i][startC].get(0).z);
                graph[i][startC].remove(graph[i][startC].get(0));

                return;
            }
        }
    }
    private static void eatingShark(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(graph[i][j].size()>=2){
                    eat(graph[i][j]);
                }
            }
        }
    }
    private static void eat(List<Shark> sharks){
        Collections.sort(sharks, (o1, o2) -> Integer.compare(o2.z, o1.z));
        Shark biggest = sharks.get(0);
        sharks.clear();
        sharks.add(biggest);
    }
    static void moveShark() {
        List<Shark>[][] nextGraph = new ArrayList[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                nextGraph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j].isEmpty()) continue;

                for (Shark shark : graph[i][j]) {
                    Shark moved = move(shark);   // 이동 결과 반환
                    nextGraph[moved.r][moved.c].add(moved);
                }
            }
        }

        graph = nextGraph;
    }
    private static Shark move(Shark shark){
        int nx = shark.r;
        int ny = shark.c;
        int dir = shark.direction;
        int moveCount;
        if(dir == 0 || dir == 1){
            moveCount = (R == 1) ? 0 : shark.speed % (2 * (R - 1));
        } else {
            moveCount = (C == 1) ? 0 : shark.speed % (2 * (C - 1));
        }
        for(int i=0;i<moveCount;i++){
            nx+=dx[dir];
            ny+=dy[dir];
            if(nx<0 || ny<0 || nx>=R || ny>=C){
                nx-=dx[dir];
                ny-=dy[dir];
                //방향전환
                if(dir ==0){
                    dir =1;
                }
                else if(dir == 1){
                    dir =0;
                }
                else if(dir == 2){
                    dir = 3;
                }
                else if(dir == 3){
                    dir = 2;
                }
                nx+=dx[dir];
                ny+=dy[dir];
            }

        }

        return new Shark(nx,ny,shark.speed,dir,shark.z);
    }
}