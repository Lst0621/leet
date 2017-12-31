#include <vector>
#include <iostream>
using namespace std;
class Solution {
  public:
	int getMoneyAmount(int n) {
		vector<vector<int>> v =
		    vector<vector<int>>(n + 1, vector<int>(n + 1, 0));
		return helper(1, n, v);
	}

  private:
	int helper(int x, int y, vector<vector<int>> &v) {
		if (x >= y)
			return 0;
		if (v[x][y] != 0)
			return v[x][y];
		int ret = y + helper(x, y - 1, v);
		for (int i = x; i <= y; i++)
			ret = min(ret, i + max(helper(x, i - 1, v), helper(i + 1, y, v)));
		v[x][y] = ret;
		return ret;
	}
};

int main() {
	cout << "test" << endl;
	Solution s = Solution();
	for (int i = 1; i < 20; i++)
		cout << i << " " << s.getMoneyAmount(i) << endl;
}
