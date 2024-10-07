package arang202407;

import java.util.Arrays;

public class _0709Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int m = 3; // 랜덤박스의 개수 = 선택된 슬라임의 개수
//		int[][] rules = { { 0, 1 }, { 1, 0 } }; // 슬라임 합성 규칙

//		int m = 4; // 랜덤박스의 개수 = 선택된 슬라임의 개수
//		int[][] rules = { { 0, 0 }, { 0, 0 } }; // 슬라임 합성 규칙

		int m = 10; // 랜덤박스의 개수 = 선택된 슬라임의 개수
		int[][] rules = { { 0, 1, 2 }, { 1, 2, 1 }, { 2, 1, 0 } }; // 슬라임 합성 규칙 59049

		int n = rules.length; // 랜덤박스 하나에 들어있는 슬라임 개수
		int[] result = new int[n];

		int S[] = new int[m];

		dfs(S, 0, m, rules, 0, result);
	}

	static void dfs(int S[], int idx, int m, int[][] rules, int last, int[] result) {
		if (idx == m) {
			System.out.println("S>" + Arrays.toString(S));
			last = cal(S, last, rules);
			result[last]++;
			System.out.println("result>" + Arrays.toString(result));
			return;
		}

		for (int i = 0; i < rules.length; i++) {
			S[idx] = i;
//			if (idx == 1) {
//				last = rules[S[0]][S[1]];
//			} else if (idx > 1) {
//				last = rules[last][S[idx]];
//			}
			dfs(S, idx + 1, m, rules, last, result);
		}
	}

	static int cal(int[] S, int last, int[][] rules) {
		for (int i = 0; i < S.length; i++) {
			if (i == 1) {
				last = rules[S[0]][S[1]];
			} else if (i > 1) {
				last = rules[last][S[i]];
			}
		}
		return last;
	}

}
