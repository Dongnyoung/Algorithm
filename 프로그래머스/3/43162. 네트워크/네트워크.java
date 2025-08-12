class Solution {
    public static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int edges=0;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                
                if(i!=j && computers[i][j]==1){
                    union(i,j);
                    
                    
                }
            }
            
        }
        for(int i=0;i<n;i++){
            if(find(i)==i){
                answer++;
            }
        }
        return answer;
    }
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public static int union(int x,int y){
        int root1 = find(x);
        int root2 = find(y);
        return parent[root2] = root1;
    }
}