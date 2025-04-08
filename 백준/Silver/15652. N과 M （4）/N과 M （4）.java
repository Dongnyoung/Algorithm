import java.util.*;

class Main {
    private static int[] nums;
    private static int n, m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        nums = new int[m]; // 조합 저장할 배열 생성
        solution(1, 0);    // 시작값 1, 현재 깊이 0
        scan.close();
    }

    private static void solution(int num, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = num; i <= n; i++) {
            nums[depth] = i;
            solution(i, depth + 1); // 다음 숫자부터 탐색 (중복 방지)
        }
    }
}
