package arang202405;

public class _0522Q1 {
	static int min = 10000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 3;
		int e = 4;
		int[][] arr = { { 1, 2, 1 }, { 3, 2, 1 }, { 1, 3, 5 }, { 2, 3, 2 } };
		int[] check;
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			result = 0;
			System.out.println("start>" + arr[i][0] + " " + arr[i][1]);
			check = new int[v];
			cycle(arr, check, result, i, i);
		}

		System.out.println();
		System.out.println("min>" + min);
	}

	static void cycle(int[][] arr, int[] check, int result, int sidx, int curidx) {
		if (result > 0 && arr[sidx][0] == arr[curidx][1]) {
			result += arr[curidx][2];
			if (result < min) {
				System.out.println("Cycle!!!!!!");
				System.out.println("result>" + result);
				min = result;
			}

			return;
		}
		if (check[arr[curidx][0] - 1] > 0 && arr[curidx][1] != arr[sidx][0]) { // 다른 사이클 발생
			System.out.println("xxxx");
			return;
		}
		System.out.println("cur>" + arr[curidx][0] + " " + arr[curidx][1]);
		check[arr[curidx][0] - 1]++;
		result += arr[curidx][2];

		for (int i = 0; i < arr.length; i++) {
			if (arr[curidx][1] == arr[i][0]) {
				cycle(arr, check, result, sidx, i);
			}
		}
	}

}
