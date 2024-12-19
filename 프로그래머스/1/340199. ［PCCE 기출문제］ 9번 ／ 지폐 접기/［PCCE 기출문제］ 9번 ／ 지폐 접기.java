import java.util.*;
class Solution {
    public int maxL(int[] list){
        return Math.max(list[0],list[1]);
    }
    public int minL(int[] list){
        return Math.min(list[0],list[1]);
    }
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            
            int minWallet = minL(wallet);
            int minBill = minL(bill);
            
            int maxWallet = maxL(wallet);
            int maxBill = maxL(bill);
            
            if(minWallet< minBill || maxBill>maxWallet){
                if(bill[0]>bill[1])
                    bill[0]/=2;
                else
                    bill[1]/=2;
                answer++;
            }
            else
                break;
        }
        
        return answer;
    }
    
    
}