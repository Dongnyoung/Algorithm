
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;



    
int main() {
    fastio;
    int T;
    int a,b;
    int cnt;
    cin >> T;
    for(int i=0; i<T; i++){
        cin  >> a >> b;
        cnt =a%10;
        
        //제곱 구현
        for(int j=1; j<b; j++ ){
            cnt *=a;
            cnt %=10;
        }
        if (cnt==0) cout << "10" << '\n';
        else cout << cnt << '\n';
    }
    
}
    
