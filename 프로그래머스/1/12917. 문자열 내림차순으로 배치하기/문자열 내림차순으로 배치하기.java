import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        //문자를 큰거 부터 작은거
        char[] words = s.toCharArray();
        ArrayList<Character> wordsList = new ArrayList<>();
        for(char word:words){
            wordsList.add(word);
        }
        Collections.sort(wordsList,Collections.reverseOrder());
        for(int i=0;i<wordsList.size();i++){
            answer+=wordsList.get(i);
        }
        return answer;
    }
}