class Solution {
    static int answer,N;
    static int[][] map;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        N = dungeons.length;
        map =dungeons;
        visited = new boolean[N];
        dfs(k,0);
        return answer;
    }
    //dfs는 최대던전수체킹
    private static void dfs(int hp, int count){
       
        
        for(int i=0;i<N;i++){
            
            if(!visited[i] && hp>=map[i][0]){
                //System.out.println(map[i][0]);
                visited[i] = true;
                dfs(hp-map[i][1],count+1);
                visited[i] =false;
            }
            
            
        }
         answer= Math.max(count,answer);
    }
}