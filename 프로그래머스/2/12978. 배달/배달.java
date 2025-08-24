import java.util.*;
class Solution {
    private static class Node{
        int cost;
        int vertex;
        public Node(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }
    }
    private static ArrayList<Node>[] nodeList;
    private static int dist[];
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        nodeList= new ArrayList[N+1];
        for(int i=1;i<nodeList.length;i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int []edge : road){
            nodeList[edge[0]].add(new Node(edge[1],edge[2]));
            nodeList[edge[1]].add(new Node(edge[0],edge[2]));
        }
        dist = new int[N+1];
        for(int i=1;i<=N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(1,0));
        dist[1]=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.vertex]<now.cost){
                continue;
            }
            for(Node next: nodeList[now.vertex]){
                if(dist[next.vertex]>next.cost+now.cost){
                    dist[next.vertex]=next.cost+now.cost;
                    pq.add(new Node(next.vertex,dist[next.vertex]));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(dist[i]<=K){
                answer++;
            }
        }
        return answer;
    }
}