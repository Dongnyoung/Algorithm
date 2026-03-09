import java.util.*;
class Solution {
    static int[] dx ={0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;
    static char[][] graph;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        
        List<Integer> days = new ArrayList<>();
        N=maps.length;
        M=maps[0].length();
        graph = new char[maps.length][maps[0].length()];
        visited = new boolean[N][M];
        for(int i=0;i<maps.length;i++){
            
                char[] map = maps[i].toCharArray();
                graph[i] = map;
                
        }
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(graph[i][j] !='X' && !visited[i][j]){
                    
                    int day = calc(i,j);
                    days.add(day);
                }
            }
        }
        
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for(int i=0;i<days.size();i++){
            answer[i] = days.get(i);
        }
        
        return answer.length == 0 ? new int[]{-1} : answer;
    }
    private static int calc(int x, int y){
        visited[x][y] = true;
        int sum = graph[x][y]-'0';
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny >=M){
                continue;
            }
            if(visited[nx][ny]){
                continue;
            }
            if(graph[nx][ny]=='X'){
                continue;
            }
            sum+=calc(nx,ny);
        }
        return sum;
    }
    
}