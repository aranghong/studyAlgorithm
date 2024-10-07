package arang202409;

import java.util.Arrays;

public class _0919Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4; // n행
		int m = 8; // m열
		int q = 9;

		int result = 0;

		
		// 샘플
		String[][] arr = { { "A", "B", "B", "A", "A", "A", "A", "A" }, { "A", "B", "A", "A", "A", "A", "B", "A" },
				{ "C", "A", "A", "D", "A", "B", "B", "A" }, { "A", "A", "A", "A", "A", "A", "A", "A" } };

		// 0~8번 학생의 영역
		int[][] land = { { 1, 1, 4, 8 }, { 3, 5, 3, 8 }, { 1, 3, 2, 4 }, { 1, 4, 2, 5 }, { 1, 1, 3, 3 }, { 4, 4, 4, 4 },
				{ 2, 6, 4, 8 }, { 3, 5, 4, 6 }, { 1, 6, 3, 8 } };

		for (int i = 0; i < land.length; i++) {
			result = 0;
			int[][] check = new int[arr.length][arr[0].length];
			for (int x = land[i][0] - 1; x < land[i][2]; x++) {
				for (int y = land[i][1] - 1; y < land[i][3]; y++) {
					// r->x, c->y
					if (check[x][y] == 0) {
						dfs(arr, land[i][0] - 1, land[i][2] - 1, land[i][1] - 1, land[i][3] - 1, check, x, y,
								arr[x][y]);
						for (int k = 0; k < check.length; k++) {
							System.out.println(Arrays.toString(check[k]));
						}
						System.out.println();
						result++;
						
					}
				}
			}
			System.out.println("result>" + result);

		}

	}

	static void dfs(String[][] arr, int x1, int x2, int y1, int y2, int[][] check, int r, int c, String str) {
		if (r < x1 || r > x2 || c < y1 || c > y2 || check[r][c] == 1 || !arr[r][c].equals(str)) {
			return;
		}

		check[r][c] = 1;

		dfs(arr, x1, x2, y1, y2, check, r - 1, c, str); // 상
		dfs(arr, x1, x2, y1, y2, check, r + 1, c, str); // 하
		dfs(arr, x1, x2, y1, y2, check, r, c - 1, str); // 좌
		dfs(arr, x1, x2, y1, y2, check, r, c + 1, str); // 우

	}
}
