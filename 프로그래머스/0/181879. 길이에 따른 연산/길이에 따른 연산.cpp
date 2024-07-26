#include <string>
#include <vector>
#include <numeric>
using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int sum1 =0;
    int s2=1;
    if(num_list.size()>=11){
        sum1 = accumulate(num_list.begin(),num_list.end(),0);
        answer =sum1;
    }
    else{
        for(int i = 0 ; i<num_list.size();i++)
            s2*=num_list[i];
        answer = s2;
    }
    return answer;
}