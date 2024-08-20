//이용료 price , n번째이용 n*price
//count번 타고싶다? price*1 .. price*count
//총 이용료는 price*1 + .. + price*count
//result는 총이용료  - money
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
      
        for(int i=1;i<=count;i++){
            answer+=price*i; // 총이용료
        }
        answer -= money;
        
        return answer<0? 0:answer;
    }
}