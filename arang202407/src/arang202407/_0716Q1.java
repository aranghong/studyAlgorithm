package arang202407;

import java.util.Arrays;

public class _0716Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] edge = { { 2, 3 }, { 4, 3 }, { 1, 1 }, { 2, 1 } };

		int[][] edge = { { 4, 11 }, { 1, 12 }, { 8, 3 }, { 12, 7 }, { 4, 2 }, { 7, 11 }, { 4, 8 }, { 9, 6 }, { 10, 11 },
				{ 6, 10 }, { 3, 5 }, { 11, 1 }, { 5, 3 }, { 11, 9 }, { 3, 8 } };

		int[] result = new int[4];

		// 생성 정점: 들어오는거 없이 나가는게 제일 많은 점
		// 그래프는 생성 정점이 포함되면 안됨
		// 도넛 그래프: 정점 개수 = 엣지 개수
		// 막대 그래프: 정점 개수 > 엣지 개수
		// 8자 그래프: 정점 개수 < 엣지 개수

		int[][] point = new int[20][2]; // 나가는 엣지 수, 들어오는 엣지 수 저장
		int total_pointCnt = 0;
		for (int i = 0; i < edge.length; i++) {
			point[edge[i][0] - 1][0]++;
			point[edge[i][1] - 1][1]++;
		}
		for (int i = 0; i < point.length; i++) {
			if (point[i][0] == 0 && point[i][1] == 0) {

			} else {
				total_pointCnt++;
			}
		}

		for (int i = 0; i < point.length; i++) {
//			System.out.println(Arrays.toString(point[i]));
		}
		System.out.println("총 정점의 개수>" + total_pointCnt);

		int max = 0;
		int maxidx = 0;
		for (int i = 0; i <= total_pointCnt; i++) {
			if (max < point[i][0] && point[i][1] == 0) {
				max = point[i][0];
				maxidx = i + 1;
			}
		}
		result[0] = maxidx;
		System.out.println("생성 정점>" + maxidx);

		for (int i = 1; i <= total_pointCnt; i++) {
			if (i != result[0]) {

				int pointCnt = 0;
				int edgeCnt = 0;

				for (int k = 0; k < edge.length; k++) {
					if (edge[k][1] == i && edge[k][0] == result[0]) {
						int[] check = new int[edge.length];
						int[] temp = new int[total_pointCnt + 1];
						int[] tempChk = new int[total_pointCnt + 1];

						dfs(edge, result, total_pointCnt, i, temp, tempChk, check);

						System.out.println("temp>" + Arrays.toString(temp));
						for (int x = 0; x < temp.length; x++) {
							if (temp[x] == 1) {
								pointCnt++;
								for (int y = 0; y < edge.length; y++) {
									if (x == edge[y][0]) {
										edgeCnt++;
									}
								}
							}
						}

						System.out.println("pointCnt>" + pointCnt);
						System.out.println("edgeCnt>" + edgeCnt);

						if (pointCnt == edgeCnt && pointCnt != 0) {
							result[1]++;
						} else if (pointCnt > edgeCnt) {
							result[2]++;
						} else if (pointCnt < edgeCnt && pointCnt != 0) {
							result[3]++;
						}
						
						
						System.out.println(i+"의 result>" + Arrays.toString(result));

					}
				}

				// i(s)는 1~
			}
		}

		System.out.println("result>" + Arrays.toString(result));

	}

	static void dfs(int[][] edge, int[] result, int total_pointCnt, int s, int[] temp, int[] tempChk, int[] check) {
		if (s < 1 || s > total_pointCnt) {
			return;
		}

		System.out.println(">>>>>s>" + s);
		for (int i = 0; i < tempChk.length; i++) {
			if (tempChk[s] == 0) {
				temp[s] = 1;
				tempChk[s] = 1;
			}
		}

		int chk = 0;
		for (int i = 0; i < edge.length; i++) {
			if (edge[i][0] == s && check[i] == 0) {
				chk++;
				check[i] = 1;
				if (edge[i][0] == edge[i][1]) {
					System.out.println("edge[i][1]>" + edge[i][1]);
					dfs(edge, result, total_pointCnt, edge[i][1], temp, tempChk, check);
				} else {
					System.out.println("edge[i][1]>" + edge[i][1]);
					dfs(edge, result, total_pointCnt, edge[i][1], temp, tempChk, check);
				}
			}
		}
		if (chk == 0) {

			return;
		}
	}

}
