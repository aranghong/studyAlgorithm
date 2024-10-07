package arang202409;

import java.util.Arrays;

public class _0926Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;

		int[][] arr = { { 1, 4 }, { 3, 5 }, { 0, 6 }, { 5, 7 }, { 3, 8 }, { 5, 9 }, { 6, 10 }, { 8, 11 }, { 8, 12 },
				{ 2, 13 }, { 12, 14 } };

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i][1]) {
				max = arr[i][1];
			}
		}

		int[] time = new int[max + 1];
		int result = 0;
		int check = 0;

		for (int i = 0; i < arr.length; i++) {
			check = 0;
			for (int k = arr[i][0]; k <= arr[i][1]; k++) {
				if (time[k] > 0) {
					check = 1;
					break;
				}
				time[k] = 1;
			}
			if (check == 0) {
				result++;
			}
		}
		System.out.println(Arrays.toString(time));
		System.out.println("result>"+result);

	}

}
