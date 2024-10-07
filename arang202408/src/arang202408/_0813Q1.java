package arang202408;

import java.util.Arrays;

public class _0813Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] flower = { { 2, 5 }, { 3, 7 }, { 10, 11 } };
		int[][] flower = { { 3, 4 }, { 4, 5 }, { 6, 7 }, { 8, 10 } };

		int min = flower[0][0];
		int max = flower[0][1];

		for (int i = 0; i < flower.length; i++) {
			if (min > flower[i][0]) {
				min = flower[i][0];
			}
			if (max < flower[i][1]) {
				max = flower[i][1];
			}
		}

		int[] arr = new int[max + 1];

		for (int i = 0; i < flower.length; i++) {
			for (int k = flower[i][0]; k < flower[i][1]; k++) {
				arr[k]++;
			}
		}

		System.out.println(Arrays.toString(arr));

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				result++;
			}
		}

		System.out.println("result>" + result);
	}

}
