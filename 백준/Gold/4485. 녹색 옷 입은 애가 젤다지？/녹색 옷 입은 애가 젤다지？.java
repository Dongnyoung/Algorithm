import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x, y, weight;
        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            int N = Integer.parseInt(line.trim());
            if (N == 0) break;

            int[][] board = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq =
                    new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

            dist[0][0] = board[0][0];
            pq.add(new Node(0, 0, dist[0][0]));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                // 낡은 정보 스킵
                if (cur.weight > dist[cur.x][cur.y]) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    int nextCost = dist[cur.x][cur.y] + board[nx][ny];
                    if (nextCost < dist[nx][ny]) {
                        dist[nx][ny] = nextCost;
                        pq.add(new Node(nx, ny, nextCost));
                    }
                }
            }

            sb.append("Problem ")
              .append(idx)
              .append(": ")
              .append(dist[N - 1][N - 1])
              .append('\n');

            idx++;
        }

        System.out.print(sb.toString());
    }
}