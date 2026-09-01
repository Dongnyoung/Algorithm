import java.util.*;
class Solution {
    static int[][] graph;
    static int answer;
    static int N;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer=0;
        graph=dungeons;
        N=dungeons.length;
        visited = new boolean[N];
        dfs(0,k);
        return answer;
    }
    private static void dfs(int depth,int piro){
        answer = Math.max(answer,depth);
        if(depth == N){
            return;
        }
        
        for(int i=0;i<N;i++){
            int lastPiro = graph[i][0];
            int cost = graph[i][1];
            if(!visited[i]){
                if(piro>=lastPiro){
                    visited[i] = true;
                    //System.out.println(lastPiro);
                    dfs(depth+1,piro-cost);
                    visited[i] = false;
                }
            }
            
        }
    }
}