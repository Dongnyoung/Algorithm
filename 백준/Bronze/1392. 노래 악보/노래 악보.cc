#include <iostream>
#include <algorithm>
using namespace std;

// 왜자꾸 큐누를 때마다 ㅇㅈㄹ이야...
// n개악보, i번째 악보는 bi로 이루어져잇다.

int main(){
    int N,Q;
    cin >> N >> Q;
    int a[N+1]; a[0] = 0;
    for(int i=1; i<=N; i++){
        cin >> a[i] ;
    }
    for(int i=1; i<=N; i++){
        a[i] +=a[i-1];
    }
    for(int i=0; i<Q; i++){
        int n_Q; cin >> n_Q;
        cout << distance(a, upper_bound(a,a+(N+1),n_Q)) << '\n';
    }
}