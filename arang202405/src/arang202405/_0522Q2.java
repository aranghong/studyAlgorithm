package arang202405;

public class _0522Q2 {

	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int[] arr = { 5, 12, 7, 10, 9, 1, 2, 3, 11 };
		int x = 13;
		int[] check;

		for (int i = 0; i < arr.length; i++) {
			check = new int[arr.length];
			dfs(arr, check, x, i, i + 1);
		}

		System.out.println("result>" + result);
	}

	static void dfs(int[] arr, int[] check, int x, int i, int j) {
		if (j < 0 || j > arr.length - 1 || check[j] > 0) {
			return;
		}
		if (arr[i] + arr[j] == x) {
			result++;
			System.out.println(arr[i] + "+" + arr[j]);
			return;
		}

		check[j] = 1;
		dfs(arr, check, x, i, j + 1);
	}

}
