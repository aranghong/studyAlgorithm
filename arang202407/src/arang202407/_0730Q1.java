package arang202407;

import java.util.ArrayList;
import java.util.Arrays;

public class _0730Q1 {
//	static int[][] dice = { { 1, 2, 3, 4, 5, 6 }, { 3, 3, 3, 3, 4, 4 }, { 1, 3, 3, 4, 4, 4 }, { 1, 1, 4, 4, 5, 5 } };

//	static int[][] dice = { { 1, 2, 3, 4, 5, 6 }, { 2, 2, 4, 4, 6, 6 } };

	static int[][] dice = { { 40, 41, 42, 43, 44, 45 }, { 43, 43, 42, 42, 41, 41 }, { 1, 1, 80, 80, 80, 80 },
			{ 70, 70, 1, 1, 70, 70 } };

	static ArrayList<int[]> selected = new ArrayList<int[]>();

	static ArrayList<int[]> result = new ArrayList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = dice.length;
		int[] dicecheck = new int[dice.length];
		int[] seldice = new int[n / 2];

		selectdice(seldice, dicecheck, 0, 0, n);

		for (int i = 0; i < result.size(); i++) {
			System.out.println("result>" + Arrays.toString(result.get(i)));
		}

		int max_index = 0;
		int max_value = result.get(0)[n / 2]; // n/2 인덱스의 값을 초기 최대값으로 설정

		for (int i = 1; i < result.size(); i++) {
			if (result.get(i)[n / 2] > max_value) {
				max_value = result.get(i)[n / 2];
				max_index = i;
			}
		}

		System.out.println("max result>>>>>" + Arrays.toString(result.get(max_index)));

	}

	static void selectdice(int[] seldice, int[] dicecheck, int s, int cnt, int n) {
		if (cnt == n / 2) {
//			System.out.println("check dice>" + Arrays.toString(dicecheck));
			System.out.println("select dice>" + Arrays.toString(seldice));
			selected.add(seldice);

			int[] noseldice = new int[n / 2];
			int count = 0;

			for (int i = 0; i < dicecheck.length; i++) {
				if (dicecheck[i] == 0) {
					noseldice[count++] = i;
				}
			}

			System.out.println("no select dice>" + Arrays.toString(noseldice));

			int[] temp = new int[seldice.length];
			int sumA = 0;
			scoreA(seldice, noseldice, temp, 0, sumA, n);

			return;
		}

		for (int i = s; i < n; i++) {
			dicecheck[i] = 1;
			seldice[cnt] = i;
			selectdice(seldice, dicecheck, i + 1, cnt + 1, n);
			dicecheck[i] = 0;
		}
	}

	static void scoreA(int[] seldice, int[] noseldice, int[] temp, int cnt, int sum, int n) { // sel
		if (seldice.length == cnt) {
//			System.out.println(sum);
			System.out.println("aaaaaaaaaaaaaaaaaa>" + Arrays.toString(temp));

			int check = 0;
			int index = 0;
			for (int i = 0; i < result.size(); i++) {
				int[] result_temp = result.get(i);
				int check_cnt = 0;
				for (int k = 0; k < seldice.length; k++) {
					if (result_temp[k] == seldice[k]) {
						check_cnt++;
					}
				}
				if (check_cnt == seldice.length) {
					index = i;
					check = 1;
					break;
				}
			}
			int[] result_a = new int[(n / 2) + 1];
			if (check == 0) { // arraylist에 저장되지 않은 주사위 쌍
				for (int i = 0; i < n / 2; i++) {
					result_a[i] = seldice[i];
				}
//				result_a[n/2] = 0;
				// arraylist에 저장해야 함
			}

			temp = new int[noseldice.length];
			int sumB = 0;
			scoreB(noseldice, temp, 0, sumB, n, result_a, check, sum, index);

			return;
		}
		for (int i = 0; i < dice[0].length; i++) {
			temp[cnt] = dice[seldice[cnt]][i];
			scoreA(seldice, noseldice, temp, cnt + 1, dice[seldice[cnt]][i] + sum, n);

		}

	}

	static void scoreB(int[] noseldice, int[] temp, int cnt, int sumB, int n, int[] result_a, int check, int sumA,
			int index) { // nosel
		if (noseldice.length == cnt) {
			System.out.println(sumA);
			System.out.println("bbbbbbb>" + Arrays.toString(temp));

			if (check == 0) { // arraylist에 저장되지 않은 주사위 쌍
				if (sumA > sumB) {
					result_a[n / 2]++;
				}
				result.add(result_a);
				System.out.println("r_a>" + Arrays.toString(result_a));

			} else if (check == 1) { // arraylist에 저장되어 있던 주사위 쌍
				if (sumA > sumB) {
					int[] result_temp = result.get(index);
					result_temp[n / 2]++;
					result.set(index, result_temp);
					System.out.println("r_a>" + Arrays.toString(result_temp));
				}
			}

			return;
		}
		for (int i = 0; i < dice[0].length; i++) {
			temp[cnt] = dice[noseldice[cnt]][i];
			scoreB(noseldice, temp, cnt + 1, dice[noseldice[cnt]][i] + sumB, n, result_a, check, sumA, index);

		}

	}

}
