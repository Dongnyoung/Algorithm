#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;


int main() {
    fastio;
    string n;
    int idx = 0;

    cin >> n;
    while(idx<n.size()) {
        if (n[idx] == 'p' and n[idx + 1] == 'i') idx = idx + 2;
        else if (n[idx] == 'k' and n[idx + 1] == 'a') idx = idx + 2;
        else if (n[idx] == 'c' and n[idx + 1] == 'h' and n[idx + 2] == 'u') idx = idx + 3;
        else break;
       
   
    }
    if (idx != n.size()) cout << "NO";
    else cout << "YES";
}
