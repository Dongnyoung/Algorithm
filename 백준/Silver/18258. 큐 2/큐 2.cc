#include <iostream>
#include <queue>

#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int main() {
    fastio;
    queue<int> Q;
    int n,t; cin >> n;
    
    while(n--){
        string s; cin>>s;
        if (s=="push") {cin >>t; Q.push(t);}
        else if(s=="pop") cout << (Q.empty() ? -1 : Q.front()) << '\n', Q.size() ? Q.pop() : void();
        
        else if(s=="size") cout << Q.size() <<'\n';
        else if(s=="empty") {cout << Q.empty() << '\n';}
        else if(s=="front"){
            if(Q.empty()) cout << "-1" <<'\n';
            else cout << Q.front() <<'\n';
        }
        else if(s=="back"){
            if(Q.empty()) cout << "-1" << '\n';
            else cout << Q.back() << '\n';
        }
    }
}

