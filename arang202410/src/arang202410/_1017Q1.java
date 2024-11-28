package arang202410;

import java.util.Arrays;

public class _1017Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 100, 99, 98 }, { 100, 97, 92 }, { 63, 89, 63 }, { 99, 99, 99 }, { 89, 97, 98 } };
		int[] result = new int[arr.length];

		for (int i = 0; i < arr[0].length; i++) { // 3
			int cur = 0;
			for (int k = 0; k < arr.length; k++) { // n
				int check = 0;
				cur = arr[k][i];
				for (int x = 0; x < arr.length; x++) {
					if (x != k && arr[x][i] == cur) {
//						System.out.println(cur);
						check++;
						break;
					}
				}
				if(check == 0) {
					System.out.println(cur);
					result[k] += cur;
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
	}

}
