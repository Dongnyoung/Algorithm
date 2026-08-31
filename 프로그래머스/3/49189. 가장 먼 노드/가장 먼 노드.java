import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int dist[] = new int[n+1];
        List<Integer>[] graph = new List[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=0;
        }
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        dist[1] = 1;
        while(!q.isEmpty()){
            int now =q.poll();
            for(int next: graph[now]){
                if(dist[next]>0){
                    continue;
                }
                dist[next]=dist[now]+1;
                q.add(next);
            }
        }
        
        //최대 개수 
        int maxLen =0;
        
        for(int i=1;i<dist.length;i++){
            if(maxLen<dist[i]){
                maxLen=dist[i];
            }
        }
        
        for(int i=1;i<dist.length;i++){
            if(maxLen==dist[i]){
                answer++;
            }
        }
        return answer;
    }
}