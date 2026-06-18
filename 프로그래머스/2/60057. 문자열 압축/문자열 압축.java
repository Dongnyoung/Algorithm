class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        answer = len;
        
        for(int i=1;i<=len/2;i++){
            String prev = s.substring(0,i);
            int count=1;
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<len;j+=i){
                String cur = s.substring(j,Math.min(j+i,len));
                if(prev.equals(cur)){
                    count++;
                }
                else{
                    if(count>1){
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = cur;
                    count=1;
                }
            }
            if(count>1){
                sb.append(count);
            }
            sb.append(prev);
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}