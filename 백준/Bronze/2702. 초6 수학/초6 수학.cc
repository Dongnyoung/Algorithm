
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int gcd(int a, int b){
   
    while(b!=0){
        int r= a%b;
        a=b;
        b=r;
        
    }
    return a;
    
}
    
int main() {
    fastio;
    int T;
    cin >>T ;
    while(T--){
        int n , m;
        cin >> n >> m;
        cout << (n*m) / gcd(n,m) << " ";
        cout << gcd(n,m) << '\n';
    }
    
    
}
    
