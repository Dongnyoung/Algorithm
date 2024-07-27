#include <vector>
#include <map>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    map<int,int>n;
    for(int i=0;i<nums.size();i++){
        n[nums[i]]++;
    }
    answer = min(n.size(),nums.size()/2);
    return answer;
}