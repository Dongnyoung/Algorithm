#include <iostream>
#include <queue>

#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int main() {
    fastio;
    queue<int> Q;
    int n;
    cin >> n;
    for(int i =1; i<=n ; i++){
        Q.push(i);
    }
    while (Q.size()>1){
        Q.pop();
        Q.push(Q.front());
        Q.pop();
    }
    cout << Q.front() << '\n' ;
}

