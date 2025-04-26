#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> ARR;
vector<int> answer;

void compress(int r, int c, int n) {
    int num = ARR[r][c];
    bool res = true;
    for (int i = r; i < r + n; i++) {
        if (!res) break;
        for (int j = c; j < c + n; j++) {
            if (ARR[i][j] != num) {
                res = false;
                break;
            }
        }
    }
    if (res) {
        answer[num]++;
        return;
    }
    n /= 2;
    compress(r, c, n);
    compress(r + n, c, n);
    compress(r, c + n, n);
    compress(r + n, c + n, n);
}

vector<int> solution(vector<vector<int>> arr) {
    ARR = arr;
    for (int i = 0; i < 2; i++) answer.push_back(0);
    compress(0, 0, arr.size());
    return answer;
}