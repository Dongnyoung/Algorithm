class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] card : sizes) {
            // 가로, 세로 중 큰 값을 width로, 작은 값을 height로
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);

            maxWidth = Math.max(maxWidth, w);
            maxHeight = Math.max(maxHeight, h);
        }

        return maxWidth * maxHeight;
    }
}
