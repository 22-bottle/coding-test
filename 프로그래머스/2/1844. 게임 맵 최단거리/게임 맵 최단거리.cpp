#include <bits/stdc++.h>
using namespace std;

bool visited[105][105];

int solution(vector<vector<int> > maps) {
    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};
    int n = maps.size();
    int m = maps[0].size();
    
    queue<tuple<int, int, int>> q;
    q.push({0, 0, 1});
    visited[0][0] = 1;
    while (!q.empty()) {
        auto [r, c, nn] = q.front();
        q.pop();
        if (r == n - 1 && c == m - 1) return nn;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (!maps[nr][nc] || visited[nr][nc]) continue;
            q.push({nr, nc, nn + 1});
            visited[nr][nc] = 1;
        }
    }
    return -1;
}