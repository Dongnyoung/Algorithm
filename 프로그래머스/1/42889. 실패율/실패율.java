import java.util.*;

class Solution {
    public int count(int[] stages, int a) {
        int cnt = 0; // 초기화
        for (int i : stages) {
            if (a == i)
                cnt++;
        }
        return cnt;
    }

    public int[] solution(int N, int[] stages) {
        int result[] = new int[N];
        HashMap<Integer, Double> fail = new HashMap<>();
        
        // 실패율 계산 및 HashMap에 저장
        for (int i = 1; i <= N; i++) { // 스테이지는 1부터 N까지
            int reached = 0;
            int failed = count(stages, i);

            for (int stage : stages) {
                if (stage >= i)
                    reached++;
            }

            fail.put(i, reached > 0 ? (double) failed / reached : 0.0);
        }

        // HashMap의 엔트리를 리스트로 변환
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fail.entrySet());

        // 내림차순 정렬
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 정렬된 결과를 배열에 저장
        int idx = 0;
        for (Map.Entry<Integer, Double> entry : entryList) {
            result[idx++] = entry.getKey();
        }

        return result;
    }
}
