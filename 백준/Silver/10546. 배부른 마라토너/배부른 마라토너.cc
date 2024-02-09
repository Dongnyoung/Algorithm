#include <iostream>
#include <cstring>
#include <algorithm>
#include <map>
#include <set>
#include <cctype>


#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

//홀수개인 문자열을 출력해주는게 답같음.
//map을 이용해서 나올때마다 +1해주는데 그게 홀수라면 출력.
int main(){
    
    fastio;
    int n;
    cin >> n;
    map <string,int> s1;
    string s;
    for (int i=0; i<n; i++){
       
        cin >> s;
        s1[s]++;
    }
    string answer;
    for(int i = 0; i < n - 1; i++){
        
           cin >> s;
           s1[s]--;
    }
    for (auto it : s1) if (it.second)answer = it.first;
        cout << answer << '\n';
}
