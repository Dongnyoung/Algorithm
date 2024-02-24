
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

//운동 n분
//초기 맥박 m , 맥박 제한값M
int N,m,M,T,R;
int x,minute;
    
int main() {
    fastio;
    cin >> N >> m >> M >> T >> R;
    
    if(m+T>M){
        cout << -1;
        return 0;
    }
    x=m;
    while(1){
        if(x+T<=M){
            x+=T;
            N--;
        }
        else {
            x-=R;
            if (x<m) x=m;
        }
        minute++;
        
        if(N==0){
            cout << minute ;
            return 0;
        }
    }
    
}
    
