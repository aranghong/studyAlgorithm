package arang202409;

public class _0905Q3 {
	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2; // 슬롯
		int s = 4; // 전투력
		int[][] arr = { { 1, 0 }, { 2, 0 } };

//		int n = 2; // 슬롯
//		int s = 5; // 전투력
//		int[][] arr = { { 1, 0 }, { 3, 1 } };	// 중요도, 필수장착여부 

		// 전투력 = 중요도 * 강화레벨
		int score = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] == 1) {
				score += arr[i][0];
				cnt++;
			}
		}

//		dfs(arr, n, s, cnt, score, 0);
		dfs(arr, n, s, score, 0);

	}

	static void dfs(int[][] arr, int n, int s, int score, int be_score) {
		if (score > s) {
			return;
		}
		if (score <= s) {
			System.out.println("끝 !!!!!!!!!!!!! ");
			result++;
			System.out.println("result>" + result);

			System.out.println("score>" + (score));
//			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] == 0) {
				System.out.println(arr[i][0]);
//				System.out.println("score>" + (score + arr[i][0]));
//				result++;
				dfs(arr, n, s, score += arr[i][0], arr[i][0]);
//				dfs(arr, n, s, score, arr[i][0]);

			}
		}

	}

}