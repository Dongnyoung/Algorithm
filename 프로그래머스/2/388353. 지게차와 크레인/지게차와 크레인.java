import java.util.*;
class Solution {
    static char[][] graph;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        graph = new char[storage.length][storage[0].length()];
        for(int i=0;i<graph.length;i++){
            String s = storage[i];
            for(int j=0;j<graph[i].length;j++){
                graph[i][j] = s.charAt(j);
                
            }
        }
        
        for(String r : requests){
            if(r.length()>1){
                //크레인
                char target = r.charAt(0);
                find(target);
            }
            else{
                //지게차
                char target = r.charAt(0);
                //System.out.println(target);
                List<int[]> list = finding(target);
                List<int[]> l = bfs(list);
                pullOut(l);
            }
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]!=' '){
                    answer++;
                }
            }
        }
        return answer;
    }
    static void pullOut(List<int[]> l){
        
        for(int[] location: l){
            //System.out.println(location[0]+" "+location[1]);
            graph[location[0]][location[1]]=' ';
        }
        //System.out.println();
    }
    static List<int[]> finding(char target){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]==target){
                    //System.out.println(i+" "+j);
                    list.add(new int[]{i,j});
                }
            }
        }
        return list;
    } 
    static List<int[]> bfs(List<int[]> target){
        List<int[]> list = new ArrayList<>();
        
        for(int i=0;i<target.size();i++){
            int[] location = target.get(i);
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{location[0],location[1]});
            boolean visited[][] = new boolean[graph.length][graph[0].length];
            visited[location[0]][location[1]]= true;
            boolean flag = false;
            while(!q.isEmpty()&& !flag){
                int[] cur = q.poll();
                for(int d=0;d<4;d++){
                    int x = cur[0]+dx[d];
                    int y = cur[1]+dy[d];
                    
                    if(x<0 ||y<0 || x>=graph.length || y>=graph[0].length){
                        //외부연결
                        flag =true;
                        break;
                    }
                    if(visited[x][y]){
                        continue;
                    }
                    if(graph[x][y]==' '){
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                    
                }
            }
            if(flag){
                list.add(new int[]{location[0],location[1]});
            }
        }
        
        
        return list;
    }
    static void find(char target){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]==target){
                    graph[i][j]=' ';
                    //System.out.println(i+" "+j);
                }
            }
        }
    }
}