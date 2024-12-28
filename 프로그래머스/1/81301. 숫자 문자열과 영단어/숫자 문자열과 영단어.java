

class Solution {
    public int solution(String s) {
      //숫자 문자열
        String [] number = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        for(int i=0;i<number.length;i++){
            s = s.replaceAll(number[i],Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}