//split,slice를 사용해서 분리


function solution(s) {
    
    var answer=0;
    while(s.length>0){
        let index=0;
        const x = s[0];
        let countX=0;
        let count=0;
        
        for(let i=0;i<s.length;i++){
            if(s[i] === x){
                countX++;
            }
            else{
                count++;
            }
            if(countX===count){
                index=i;
                break;
            }
            // 마지막 문자까지 왔는데도 countX !== count
            if (i === s.length - 1) {
                index = i; // 남은 전부를 하나의 덩어리로
            }
        }
        const front = s.slice(0,index+1);
        s = s.slice(index+1);
        answer++;
        
        
    }
    
    
    return answer;
}