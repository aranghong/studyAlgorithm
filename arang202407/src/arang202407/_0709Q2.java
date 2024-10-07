package arang202407;

import java.util.Arrays;

public class _0709Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] friend = { "m", "r", "f", "n" }; // 0 1 2 3
//		String[] gift = { "m f", "m f", "r m", "r m", "r m", "f m", "f r", "n m" }; // 1->2 한테 선물 줌

		String[] friend = {"j", "b", "a", "c", "d"};
		String[] gift = {"a b", "a j", "a c", "d a", "a d"};

//		String[] friend = {"a", "b", "c"};
//		String[] gift = {"a b", "b a", "c a", "a c", "a c", "c a"};

		int result = 0;

		int[][] arr = new int[friend.length][friend.length];
		int[] give = new int[friend.length]; // 선물 준 수
		int[] take = new int[friend.length]; // 선물 받은 수
		int[] score = new int[friend.length]; // 선물 지수
		int[] next = new int[friend.length]; // 다음 달에 선물 받을 수

		for (int i = 0; i < gift.length; i++) {
			String[] temp = gift[i].split(" ");
			int[] temp2 = new int[2];
			for (int k = 0; k < friend.length; k++) {
				if (temp[0].equals(friend[k])) {
					temp2[0] = k;
				}
				if (temp[1].equals(friend[k])) {
					temp2[1] = k;
				}
			}
			arr[temp2[0]][temp2[1]]++;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				give[i] += arr[i][k];
				take[i] += arr[k][i];
			}
			score[i] = give[i] - take[i];
		}

		System.out.println("give>" + Arrays.toString(give));
		System.out.println("take>" + Arrays.toString(take));
		System.out.println("score>" + Arrays.toString(score));

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				if (arr[i][k] < arr[k][i]) { // k가 선물을 더 많이 줌
					next[k]++;
				} else if (arr[i][k] == arr[k][i]) { // k가 선물 준 수 = i가 선물 준
					if (score[i] < score[k]) { // 선물지수
						next[k]++;
					} else if (score[i] > score[k]) {
						next[i]++;
					}
				} else { // i가 선물을 더 많이 줌
					next[i]++;
				}
			}
		}
//		System.out.println("next>" + Arrays.toString(next));

		int max = 0;
		int maxidx = 0;
		for (int i = 0; i < next.length; i++) {
			next[i] /= 2;
			if (max < next[i]) {
				max = next[i];
				maxidx = i;
			}
		}

		System.out.println("next>" + Arrays.toString(next));
		System.out.println("result>" + max);

	}

}
