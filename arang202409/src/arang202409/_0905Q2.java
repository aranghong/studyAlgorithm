package arang202409;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0905Q2 {
//	static int d = 2;
	static int d = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] arr = { { ".", ".", ".", "#", "." }, { "#", ".", ".", ".", "#" }, { ".", ".", ".", ".", "#" } };

		String[][] arr = { { ".", "#", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", "#", "#" },
				{ ".", ".", ".", ".", ".", ".", "." }, { "#", ".", ".", ".", ".", ".", "." } };

		int[][] check = new int[arr.length][arr[0].length];
		int[] result = { 0 };
		String resultstr = "";
		Set<String> resultset = new HashSet<String>();

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				check = new int[arr.length][arr[0].length];
				System.out.println("start>>>>>>>>>>>>>>>>>>>>>");
				dfs_down(arr, check, i, k, 0, result, resultstr, resultset);
				check = new int[arr.length][arr[0].length];
				dfs_right(arr, check, i, k, 0, result, resultstr, resultset);
				for (int x = 0; x < resultset.size(); x++) {
					System.out.println(resultset.toString());
				}
			}
		}
		System.out.println("result>" + result[0]);

	}

	static void dfs_down(String[][] arr, int[][] check, int r, int c, int cnt, int[] result, String resultstr,
			Set<String> resultset) {
		if (cnt == d) {
			System.out.println("배치 ");
			result[0]++;
			System.out.println(result[0]);
			System.out.println(resultstr);
			resultset.add(resultstr);
//			System.out.println(resultarr.toString());

			return;
		}
		if (r < 0 || r > arr.length - 1 || c < 0 || c > arr[0].length - 1 || arr[r][c].equals("#")
				|| check[r][c] == 1) {
			System.out.println("뒤로 !!!!!!!!!!!!!!!!!!!!!!!!!");
			return;
		}

		check[r][c] = 1;
//		resultstr += r + "" + c + "";
		System.out.println(r + " " + c + " " + cnt);
//		dfs(arr, check, r - 1, c, cnt + 1, result, resultarr);
		dfs_down(arr, check, r + 1, c, cnt + 1, result, resultstr += r + "" + c + "", resultset); // 하
//		dfs(arr, check, r, c - 1, cnt + 1, result, resultarr);
//		dfs(arr, check, r, c + 1, cnt + 1, result, resultstr, resultset);	//우 

	}

	static void dfs_right(String[][] arr, int[][] check, int r, int c, int cnt, int[] result, String resultstr,
			Set<String> resultset) {
		if (cnt == d) {
			System.out.println("배치 ");
			result[0]++;
			System.out.println(result[0]);
			System.out.println(resultstr);
			resultset.add(resultstr);
//			System.out.println(resultarr.toString());

			return;
		}
		if (r < 0 || r > arr.length - 1 || c < 0 || c > arr[0].length - 1 || arr[r][c].equals("#")
				|| check[r][c] == 1) {
			System.out.println("뒤로 !!!!!!!!!!!!!!!!!!!!!!!!!");
			return;
		}

		check[r][c] = 1;
//		resultstr += r + "" + c + "";
		System.out.println(r + " " + c + " " + cnt);
//		dfs(arr, check, r - 1, c, cnt + 1, result, resultarr);
//		dfs(arr, check, r + 1, c, cnt + 1, result, resultstr, resultset);	//하 
//		dfs(arr, check, r, c - 1, cnt + 1, result, resultarr);
		dfs_right(arr, check, r, c + 1, cnt + 1, result, resultstr += r + "" + c + "", resultset); // 우

	}

}
