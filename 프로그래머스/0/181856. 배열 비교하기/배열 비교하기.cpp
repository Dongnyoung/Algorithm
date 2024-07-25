#include <string>
#include <vector>
#include <numeric>
using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    int answer = 0;
    int sum1=0;
    int sum2=0;
    
    sum1=accumulate(arr1.begin(),arr1.end(),0);
    sum2=accumulate(arr2.begin(),arr2.end(),0);
    
    if(arr1.size() == arr2.size()){
        if(sum1>sum2)
            answer = 1;
        else if(sum1<sum2)
            answer = -1;
        else
            answer = 0;
    }
    else{
        if(arr1.size()>arr2.size())
            answer= 1;
        else
            answer =-1;
    }
    return answer;
}