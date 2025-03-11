class Solution {
    private int zeroCount;

    // 이진 변환 함수
    private String translate(String s) {
        zeroCount += s.length() - s.replace("0", "").length(); // 0의 개수 세기
        s = s.replace("0", ""); // 0 제거
        return Integer.toBinaryString(s.length()); // 변환된 이진 문자열 반환
    }

    public int[] solution(String s) {
        int transCount = 0;
        zeroCount = 0;

        // 1이 될 때까지 반복
        while (!s.equals("1")) {
            s = translate(s);
            transCount++;
        }

        return new int[]{transCount, zeroCount};
    }
}
