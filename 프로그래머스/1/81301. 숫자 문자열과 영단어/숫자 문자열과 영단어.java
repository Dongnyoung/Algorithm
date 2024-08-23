//영어문자면 숫자로 바꾸고 그냥 숫자면 그대로
//문자열 배열을 생성하자

class Solution {
    public int solution(String s) {
        int answer=0;
        String [] eng = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        for(int i =0;i<eng.length;i++)
            if(s.contains(eng[i]))
                s = s.replace(eng[i],Integer.toString(i));
        answer = Integer.parseInt(s);
        return answer;
    }
}