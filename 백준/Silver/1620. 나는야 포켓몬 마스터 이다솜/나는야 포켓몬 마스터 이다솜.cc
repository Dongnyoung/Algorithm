#include <iostream>
#include <cstring>
#include <algorithm>
#include <map>
#include <cctype>


#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

//문자열이든 숫자든 받는다.
//문자열로 물어보면 문자열의 인덱스값 출력
//숫자로 물어보면 인덱스값으로 문자열 출력

int main(){
    
    fastio;
    int n,m ; cin >> n>>m;
    map <string,int> name;
    map <int, string> idx;
    for(int i=1; i<=n; i++){
        string s;
        cin >>s;
        name[s]=i;
        idx[i]=s;
    }
    while(m--){
        string s; cin>>s;
        if(isdigit(s[0])) cout << idx[stoi(s)] <<'\n';
        else
            cout << name[s] <<'\n';
    }
}
