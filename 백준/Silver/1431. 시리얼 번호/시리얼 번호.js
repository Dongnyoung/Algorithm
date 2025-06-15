const { setEngine } = require('crypto');
const fs = require('fs');
const [N, ...input] = fs.readFileSync('/dev/stdin').toString().trim().split("\n");
//const [N, ...input] = fs.readFileSync("input.txt").toString().trim().split("\n");


//A가 B의 앞에 오는 경우..?
//A와 B의 길이가 다르면, 짧은것이 먼저 온다...
//B가 더짧으면 앞에오겠군.
//길이가 같으면 숫자인것만 합해서 작은놈이 앞에옴. 
//1,2조건으로 안되면 사전순


function sumOfDigits(str){
    
    var sum=0;
    for(let i=0;i<str.length;i++){
        if(!isNaN(str[i]) && str[i]>='0' && str[i]<='9')
            sum+=parseInt(str[i]);
    }
    return sum;
}

//정렬
input.sort((a,b)=>{

    //길이 비교
    if(a.length !== b.length){
        return a.length - b.length; //오름차순
    }
    var sumA = sumOfDigits(a);
    var sumB = sumOfDigits(b);
    if(sumA!==sumB){
        return sumA-sumB; //오름차순
    }
    return a.localeCompare(b);
    
});
console.log(input.join("\n"));
