package arang202408;

import java.util.ArrayList;

public class _0827Q3 {
	static int v1 = 2;
	static int v2 = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int e = 6;

		int[][] arr = { { 1, 2, 3 }, { 2, 3, 3 }, { 3, 4, 1 }, { 1, 3, 5 }, { 2, 4, 5 }, { 1, 4, 4 } };
//		int v1 = 2;
//		int v2 = 3;
		// 양방향, 여러번 갈수있음, v1v2는 꼭 통과해야함, 1에서 n(4)로 가야함
		int[] min = { 10000000 };
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 1) {
				result = new ArrayList<Integer>();
				dfs(arr, i, n, min, 0, result);

			}
		}
		System.out.println("min>" + min[0]);

	}

	static void dfs(int[][] arr, int i, int e, int[] min, int dis, ArrayList<Integer> result) {
		result.add(arr[i][0]);
		if (result.contains(v1) && result.contains(v2) && arr[i][1] == e) {
			System.out.println(dis);
			dis += arr[i][2];
//			System.out.println(">>>>arr[i][1]>"+arr[i][1]);
			result.add(arr[i][1]);

			System.out.println(result.toString());
			System.out.println("dis>" + dis);

			if (min[0] > dis) {
				min[0] = dis;
				System.out.println("min>" + min[0]);
			}
			return;
		}

		System.out.println(dis);
		dis += arr[i][2];

		for (int k = 0; k < arr.length; k++) {
			if (arr[i][1] == arr[k][0]) {
//				System.out.println("arr[i][1]>"+arr[i][1]);
				dfs(arr, k, e, min, dis, result);
				result.remove(result.size() - 1);
			}
		}
		

	}

}
