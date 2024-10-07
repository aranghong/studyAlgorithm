package arang202409;

import java.util.Arrays;

public class _0926Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = { 3, 1, 4, 3, 2 };

		for (int i = 0; i < n; i++) {
			int[] check = new int[arr.length];
			int[] result = new int[arr.length];

			dfs(arr, i, check, 0, result, 0);

		}
	}

	static void dfs(int[] arr, int s, int[] check, int cnt, int[] result, int sum) {
		if (s < 0 || s > arr.length - 1 || check[s] == 1) {
			System.out.println("aaa");
			return;
		}
		if (cnt == arr.length) {
			System.out.println(Arrays.toString(result));
			System.out.println("sum>" + sum);
			return;
		}
		System.out.println(s);
		check[s] = 1;
		sum += arr[s];
		result[cnt] = s;

		for (int i = 0; i < arr.length; i++) {
			dfs(arr, i, check, cnt + 1, result, sum);
		}
	}
}
