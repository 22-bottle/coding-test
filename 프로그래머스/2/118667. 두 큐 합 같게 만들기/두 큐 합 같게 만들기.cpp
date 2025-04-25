#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long q1_sum = 0;
    long q2_sum = 0;
    for (int i = 0; i < queue1.size(); i++)
        q1_sum += queue1[i];
    for (int i = 0; i < queue2.size(); i++)
        q2_sum += queue2[i];
    
    int q1_idx = 0;
    int q2_idx = 0;
    int answer = 0;
    int count = (queue1.size() + queue2.size()) * 2;
    while (true) {
        if (answer >= count) return -1;
        int q1 = queue1[q1_idx];
        int q2 = queue2[q2_idx];
        if (q1_sum > q2_sum) {
            q1_idx++;
            q1_sum -= q1;
            queue2.push_back(q1);
            q2_sum += q1;
        } else if (q1_sum < q2_sum) {
            q2_idx++;
            q2_sum -= q2;
            queue1.push_back(q2);
            q1_sum += q2;
        } else break;
        answer++;
    }
    return answer;
}