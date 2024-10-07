package arang202408;

public class _0827Q2 {
	static int start = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 5;
		int e = 6;
//		int start = 1;

		int[][] arr = { { 5, 1, 1 }, { 1, 2, 2 }, { 1, 3, 3 }, { 2, 3, 4 }, { 2, 4, 5 }, { 3, 4, 6 } };

		for (int k = 1; k < v + 1; k++) {
			int min = 10000000;
			int[] minHolder = { min }; // min 값을 배열로 감싸기

			int chk = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][1] == k) {
					chk++;
				}
			}
			if (chk == 0) {
				System.out.println("INF");
			} else {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i][0] == start) {

						int[] check = new int[arr.length];
						dfs(arr, check, i, k, minHolder, 0, 0);

					}
				}
				System.out.println("min>" + minHolder[0]);

			}

		}

	}

	static void dfs(int[][] arr, int[] check, int i, int e, int[] min, int weight, int cnt) {
		if (e == start) {
			System.out.println("start>" + 0);
			return;
		}
		if (arr[i][1] == e) {
			weight += arr[i][2];
			if (min[0] > weight) {
				min[0] = weight;
			}
			System.out.println(min[0]);
			return;
		}

		if (check[i] == 1 || i < 0 || i > arr.length - 1) {
			return;
		}

		check[i] = 1;
//		weight += arr[i][2];

		for (int k = 0; k < arr.length; k++) {
			if (arr[i][1] == arr[k][0]) {
				dfs(arr, check, k, e, min, weight + arr[i][2], cnt + 1);
			}
		}

	}

}
