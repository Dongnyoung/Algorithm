import java.util.*;

public class Main {

   static class Shark{
       int x,y;
       int direction;
       int number;
       int[][] priority;
       boolean alive;
       Shark(int x, int y,int direction, int number){
           this.x = x;
           this.y = y;
           this.direction = direction;
           this.number = number;
           this.priority = new int[4][4];
           this.alive = true;
       }
   }
    static class Node{
       int sharkNum,smellTime,smellMaster;
       Node(int sharkNum, int smellTime, int smellMaster){
           this.sharkNum = sharkNum;
           this.smellTime = smellTime;
           this.smellMaster = smellMaster;
       }
    }
    static int[] dx={-1,1,0,0}; //위 아래 왼쪽 오른쪽
    static int[] dy ={0,0,-1,1};
    static int N,M,k;
    static Node[][] graph;
    static Shark[] sharks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        k = sc.nextInt();

        graph = new Node[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int sharkNum = sc.nextInt();
                if(sharkNum>0){
                    graph[i][j] = new Node(sharkNum,k,sharkNum);
                }
                else{
                    graph[i][j] = new Node(0,0,0);
                }
            }
        }
        sharks = new Shark[M+1];
        for(int i=1;i<=M;i++){
            int direction = sc.nextInt()-1;
            int xy[] = findShark(i);
            sharks[i] = new Shark(xy[0],xy[1],direction,i);
        }

        for(int i=1;i<M+1;i++){
            Shark s = sharks[i];
            for(int dir=0;dir<4;dir++){
                for(int j=0;j<4;j++){
                    s.priority[dir][j] = sc.nextInt()-1;
                }
            }

        }

        for(int i=0;i<1000;i++){
            List<Shark> sharkList = collect();

            Node[][] temp = moveAndSmell(sharkList);

            graph =temp;
            boolean flag = true;
            flag = check();
            if(flag){
                System.out.println(i+1);
                return;
            }
            else{
                continue;
            }
        }
        System.out.println(-1);
    }
    static Node[][] moveAndSmell(List<Shark> sharkList){
        Node temp[][] =new Node[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[i][j] = new Node(0,0,0);
            }
        }
        //기존 냄새 먼저 복사하면서 감소
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j].smellTime >0){
                    temp[i][j].smellTime = graph[i][j].smellTime-1;
                    if(temp[i][j].smellTime > 0){
                        temp[i][j].smellMaster = graph[i][j].smellMaster;
                    }
                    else{
                        temp[i][j].smellMaster = 0;
                    }
                }
            }
        }

        for(Shark s: sharkList){
            int x = s.x;
            int y = s.y;
            int num = s.number;
            if(temp[x][y].sharkNum ==0){
                temp[x][y].sharkNum = num;
                sharks[num].x=x;
                sharks[num].y=y;
                sharks[num].direction = s.direction;
                sharks[num].alive = true;
            }
            else{
                int other = temp[x][y].sharkNum;
                if(other <num){
                    sharks[num].alive = false;
                }
                else{
                    sharks[other].alive = false;
                    temp[x][y].sharkNum = num;
                    sharks[num].x=x;
                    sharks[num].y=y;
                    sharks[num].direction = s.direction;
                    sharks[num].alive = true;
                }
            }
        }
        for(int i=1;i<=M;i++){
            if(sharks[i].alive==true){
                int x = sharks[i].x;
                int y = sharks[i].y;
                temp[x][y].smellMaster = i;
                temp[x][y].smellTime =k;
                temp[x][y].sharkNum = i;
            }
        }
        return temp;
    }
    static List<Shark> collect(){
        List<Shark> sharkList = new ArrayList<>();

        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive){
                continue;
            }
            int[] dir = s.priority[s.direction];
            boolean move = false;
            for(int j=0;j<4;j++){
                int nx = s.x+dx[dir[j]];
                int ny = s.y+dy[dir[j]];
                if(nx<0 || ny<0 || nx>=N || ny>=N){
                    continue;
                }
                if(graph[nx][ny].smellMaster ==0){
                    sharkList.add(new Shark(nx,ny,dir[j],s.number));
                    move = true;
                    break;
                }


            }
            if(!move){
                for(int j=0;j<4;j++){
                    int nx = s.x+dx[dir[j]];
                    int ny = s.y+dy[dir[j]];
                    if(nx<0 || ny<0 || nx>=N || ny>=N){
                        continue;
                    }
                    if(graph[nx][ny].smellMaster ==s.number){
                        sharkList.add(new Shark(nx,ny,dir[j],s.number));

                        break;
                    }


                }
            }

        }


        return sharkList;
    }
    static boolean check(){
        for(int i=2;i<=M;i++){
            if(sharks[i].alive) return false;
        }
        return sharks[1].alive;
    }
    static int[] findShark(int target){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j].sharkNum==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

}