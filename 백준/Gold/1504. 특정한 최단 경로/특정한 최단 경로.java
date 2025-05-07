import java.util.*;

class Main{
    private static class Node{
        int vertex;
        int weight;
        public Node(int v, int w){
            vertex= v;
            weight=w;
        }
    }
    static int[]dijkstra(int start, ArrayList<Node>[]graph,int n) {
        //dist
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        //pq
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.vertex;
            int w = cur.weight;
            if (dist[v] < cur.weight) continue;

            for (Node next : graph[v]) {

                if (dist[next.vertex] > dist[v] + next.weight) {
                    dist[next.vertex] = dist[v] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();


        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        int start = scan.nextInt();
        int end = scan.nextInt();


        int[] from1 = dijkstra(1, graph, n);
        int[] fromStart = dijkstra(start, graph, n);
        int[] fromEnd = dijkstra(end, graph, n);
        int path1 = from1[start] + fromStart[end] + fromEnd[n];
        int path2 = from1[end] + fromEnd[start] + fromStart[n];
        int answer = Math.min(path1, path2);

        if (from1[start] == Integer.MAX_VALUE || fromStart[end] == Integer.MAX_VALUE || fromEnd[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);

        }
    }
}
