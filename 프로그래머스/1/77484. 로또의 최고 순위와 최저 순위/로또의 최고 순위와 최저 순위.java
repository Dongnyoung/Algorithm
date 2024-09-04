//최고순위는 0이 맞고 남은것들을 대체할수있다고 해야함
//최저순위는 0이 다른수라고 생각해야함
//0이 없다면 맞은개수에 따라서 순위 결정

//0의 개수로 최고순위 최저순위를 정할수있다..!
//우선은 for문으로 비교해서 있으면 count하는데 0을 그냥 count에 추가하면됨

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int countZero = 0;  // 0의 개수 카운트
        int count = 0;      // 맞춘 숫자의 개수 카운트
        int [] answer = new int[2];
        // 6개의 로또 번호를 순회하며 0의 개수와 맞춘 개수를 계산
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                countZero++;
            } else {
                for (int j = 0; j < 6; j++) {
                    if (lottos[i] == win_nums[j]) {
                        count++;
                        break;  // 같은 숫자를 찾으면 더 이상 비교하지 않음
                    }
                }
            }
        }
        
        // 최고 순위와 최저 순위 계산
        int maxRank = 7 - (count + countZero);  // 최고 순위
        int minRank = 7 - count;                // 최저 순위
        
        // 순위가 6보다 높으면 6으로 수정
        if (maxRank > 6) maxRank = 6;
        if (minRank > 6) minRank = 6;
        
        // 결과 배열에 순위를 저장하고 반환
        answer[0] = maxRank;
        answer[1] = minRank;
        return answer;
    }
}
