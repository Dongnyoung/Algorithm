class Solution {
    private static int zeroCount;
    //이진변환 함수
    private static String translate(String s){
        zeroCount += s.length() - s.replace("0","").length(); //0개수세기
        s=s.replaceAll("0","");
        return Integer.toBinaryString(s.length());
        
    }
    public int[] solution(String s) {
        zeroCount=0;
        int count=0;
        while(!s.equals("1")){
            s= translate(s);
            count++;
        }
        return new int[]{count,zeroCount};
    }
}