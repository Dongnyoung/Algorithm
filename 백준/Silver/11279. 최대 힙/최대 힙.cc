
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;


    
int main() {
    fastio;
    int n;
    cin >> n;
    vector <int>  result;
    priority_queue<int> pq;
    for(int i =0; i<n; i++){
        int t;
        cin >> t;
        if (t!=0){
            pq.push(t);
        }
        
        else{
            if(pq.empty()){
                result.push_back(0);
            }
            else{
                result.push_back(pq.top());
                pq.pop();
            }
        }
    }
    for(int i=0 ; i<result.size();i++){
        cout << result[i] << '\n';
    }
    
    
}
    
