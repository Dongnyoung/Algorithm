import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static int R, C;
    static char[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(graph[i], '*');
        }

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 'X';
        }

        int robotR = sc.nextInt();
        int robotC = sc.nextInt();
        visited[robotR][robotC] = true;

        int[] patterns = new int[4];
        for (int i = 0; i < 4; i++) {
            patterns[i] = sc.nextInt() - 1;
        }

        int dir = 0;     // patterns에서 현재 바라보는 방향 index
        int fail = 0;    // 연속으로 막힌 횟수

        while (true) {
            int nx = robotR + dx[patterns[dir]];
            int ny = robotC + dy[patterns[dir]];

            if (canMove(nx, ny)) {
                robotR = nx;
                robotC = ny;
                visited[robotR][robotC] = true;
                fail = 0; // 이동 성공했으니 실패 횟수 초기화
            } else {
                dir = (dir + 1) % 4; // 다음 방향으로 회전
                fail++;
                if (fail == 4) {
                    System.out.println(robotR + " " + robotC);
                    break;
                }
            }
        }
    }

    static boolean canMove(int x, int y) {
        if (x < 0 || y < 0 || x >= R || y >= C) return false;
        if (graph[x][y] == 'X') return false;
        if (visited[x][y]) return false;
        return true;
    }
}