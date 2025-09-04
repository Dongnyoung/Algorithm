class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if((len ==4 || len ==6) && isNum(s)){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean isNum(String s){
        char[] sChar = s.toCharArray();
        for(char c: sChar){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}