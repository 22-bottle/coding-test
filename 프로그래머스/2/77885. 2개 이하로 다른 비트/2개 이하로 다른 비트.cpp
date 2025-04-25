#include <string>
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for (int i = 0; i < numbers.size(); i++) {
        long long target = numbers[i];
        long long n = 1;
        while (target % 2 == 1) {
            target /= 2;
            n *= 2;
        }
        long long ans = numbers[i] + n;
        ans -= (n / 2);
        answer.push_back(ans);
    }
    return answer;
}