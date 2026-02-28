import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static int N;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph = new ArrayList<>();
        N=n;
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //그래프 구성
        for(int[] r : roads){
            int start = r[0];
            int end = r[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            int source = sources[i];
            answer[i] = bfs(source,destination);
            
            
        }
        
        return answer;
    }
    private static int bfs(int source, int destination){
        if(source == destination)
            return 0;
        
        int[] dist = new int[N+1];
        Arrays.fill(dist,-1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(source);
        dist[source] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next]!=-1) continue;
                
                
                    dist[next] = dist[cur]+1;
                
                
                if(next == destination) return dist[next];
                q.add(next);
            }
        }
        return -1;
    }
}