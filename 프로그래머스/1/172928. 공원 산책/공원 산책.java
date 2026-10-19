import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1}; //서,동,북,남
    static int[] dy = {-1,1,0,0}; 
    
    public int[] solution(String[] park, String[] routes) {
        
        int startX =0;
        int startY =0;
        int endX = park.length;
        int endY = park[0].length();
        
        //맵만들기
        char[][] graph = new char[park.length][park[0].length()];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                graph[i][j] = park[i].charAt(j);
            }
        }
        
        //시작지점 찾기
        for(int i=0;i<park.length;i++){
            String p = park[i];
            for(int j=0;j<p.length();j++){
                if('S' == p.charAt(j)){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        
        
            int nx = startX;
            int ny = startY;
            //System.out.println("시작: "+nx+","+ny);
            for(int i=0;i<routes.length;i++){
                String cmd = routes[i];
                String[] cmdList = cmd.split(" ");
               
                char direction = cmdList[0].charAt(0);
                //System.out.println(direction);
                int moveCount = Integer.parseInt(cmdList[1]);
                //System.out.println(moveCount);
                int d = translate(direction);
                
                int rx = nx;
                int ry = ny;
                
                boolean flag = false;
                
                for(int j=0;j<moveCount;j++){
                    rx+=dx[d];
                    ry+=dy[d];
                    if(rx<0||ry<0||rx>=endX||ry>=endY||graph[rx][ry]=='X'){
                        flag = true;
                        break;
                    }
                    
                    
                }
                if(!flag){
                    nx= nx+moveCount*dx[d];
                    ny= ny+moveCount*dy[d]; 
                }
                //System.out.print("nx: "+nx+","+"ny: "+ny);
            }
            
            
        
        
        return new int[]{nx,ny};
    }
    static private int translate(char direction){
        if(direction=='W'){
            return 0;
        }
        else if(direction=='E'){
            return 1;
        }
        else if(direction=='N'){
            return 2;
        }
        else{
            return 3;
        }
    }
}