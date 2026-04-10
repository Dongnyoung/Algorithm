import java.util.*;

public class Main {

    static class Fish{
        int x,y,direction;
        Fish(int x,int y,int direction){
            this.x=x;
            this.y=y;
            this.direction=direction;
        }
    }
    static class Direction{
        int first,second,third,count;
        Direction(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
            this.count=0;
        }
    }
    static int[] dx={0,-1,-1,-1,0,1,1,1}; // 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dy ={-1,-1,0,1,1,1,0,-1};
    static int M,S;
    static List<Fish> fishes;
    static List<Fish> copyFishes;
    static int sharkX,sharkY;
    static List<Integer>[][] fishMap;
    static List<Direction> list;
    static int[] sdx = {-1, 0, 1, 0}; // 상 좌 하 우
    static int[] sdy = {0, -1, 0, 1};
    static int[][] smell;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        S = sc.nextInt();
        fishes = new ArrayList<>();
        for(int i=0;i<M;i++){
            fishes.add(new Fish(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt()-1));
        }

        sharkX = sc.nextInt()-1;
        sharkY = sc.nextInt()-1;
        smell = new int[4][4];
        fishMap = new ArrayList[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                fishMap[i][j] = new ArrayList<>();
            }
        }
        for(Fish f : fishes){
            int x =f.x;
            int y =f.y;
            fishMap[x][y].add(f.direction);
        }

        for(int turn=0;turn<S;turn++){
            copyFishes = new ArrayList<>();
            for(Fish f : fishes){
                copyFishes.add(new Fish(f.x, f.y, f.direction));
            }
            //모든 물고기 한칸 이동
            moveFish();
            //상어이동
            list = new ArrayList<>();
            collect();
            sorting(list);
            Direction d = list.get(0);

            moveShark(d,turn+1);
            deleteSmell(turn+1);
            copy();
        }
        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(fishMap[i][j].size()==0){
                    continue;
                }
                sum+=fishMap[i][j].size();
            }
        }
        System.out.println(sum);
    }
    static void collect(){
        int[] path = new int[3];
        boolean[][] visited = new boolean[4][4];

        dfs(sharkX,sharkY,0,0,path, visited);
    }
    static void dfs(int x,int y,int depth,int count, int[] path, boolean[][] visited){
        if(depth==3){
            Direction d =new Direction(path[0],path[1],path[2]);
            d.count =count;
            list.add(d);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x+sdx[i];
            int ny = y+sdy[i];
            if(nx<0 || ny<0 || nx>=4 || ny>=4){
                continue;
            }
            path[depth] = i;

            int add =0;
            boolean flag = false;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                flag = true;
                add = fishMap[nx][ny].size();
            }
            dfs(nx,ny,depth+1,count+add,path,visited);
            if(flag){
                visited[nx][ny] = false;
            }
        }
    }

    static void moveFish(){
        List<Fish> nextFishes = new ArrayList<>();
        List<Integer>[][] nextMap = new ArrayList[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                nextMap[i][j] = new ArrayList<>();
            }
        }
        for(Fish f : fishes){
            int x = f.x;
            int y = f.y;
            int direction = f.direction;
            boolean move = false;
            for(int i=0;i<8;i++){
                int nd = (direction-i+8)%8;
                int nx = x+dx[nd];
                int ny = y+dy[nd];
                if(nx<0 || ny<0 || nx>=4 || ny>=4) continue;
                if(nx==sharkX && ny==sharkY) continue;
                if(smell[nx][ny] > 0) continue;
                nextFishes.add(new Fish(nx,ny,nd));
                nextMap[nx][ny].add(nd);
                move = true;
                break;
            }
            if (!move) {
                nextFishes.add(new Fish(x,y,direction));
                nextMap[x][y].add(direction);
            }
        }
        fishes = nextFishes;
        fishMap = nextMap;

    }
    static void deleteSmell(int turn){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(smell[i][j] > 0 && turn - smell[i][j] >= 2){
                    smell[i][j] = 0;
                }
            }
        }
    }
    static void sorting(List<Direction> list){
        Collections.sort(list,(o1,o2)->{
            if(o1.count!=o2.count){
                return Integer.compare(o2.count,o1.count);
            }
            else{
                StringBuilder sb1 = new StringBuilder();
                sb1.append(o1.first);
                sb1.append(o1.second);
                sb1.append(o1.third);
                String num1 = sb1.toString();
                int n1 = Integer.parseInt(num1);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(o2.first);
                sb2.append(o2.second);
                sb2.append(o2.third);
                String num2 = sb2.toString();
                int n2 = Integer.parseInt(num2);
                return Integer.compare(n1,n2);
            }

        });
    }
    static void moveShark(Direction d,int turn){
        int first = d.first;
        int second = d.second;
        int third = d.third;
        boolean[][] eaten = new boolean[4][4];

        sharkX += sdx[first];
        sharkY += sdy[first];
        if(!fishMap[sharkX][sharkY].isEmpty()){
            fishMap[sharkX][sharkY].clear();
            smell[sharkX][sharkY] = turn;
            eaten[sharkX][sharkY] = true;
        }

        sharkX += sdx[second];
        sharkY += sdy[second];
        if(!fishMap[sharkX][sharkY].isEmpty()){
            fishMap[sharkX][sharkY].clear();
            smell[sharkX][sharkY] = turn;
            eaten[sharkX][sharkY] = true;
        }
        sharkX += sdx[third];
        sharkY += sdy[third];
        if(!fishMap[sharkX][sharkY].isEmpty()){
            fishMap[sharkX][sharkY].clear();
            smell[sharkX][sharkY] = turn;
            eaten[sharkX][sharkY] = true;
        }

        List<Fish> next = new ArrayList<>();

        for(Fish f : fishes){
            if(eaten[f.x][f.y]) continue;
            next.add(f);
        }

        fishes = next;

    }
    static void copy(){
        for(Fish f : copyFishes){
            fishMap[f.x][f.y].add(f.direction);
            fishes.add(new Fish(f.x, f.y, f.direction));

        }
    }

}