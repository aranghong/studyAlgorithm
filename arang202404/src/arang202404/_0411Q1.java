package arang202404;

public class _0411Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 3;
//		int left = 2;
//		int right = 5;

		int n = 4;
		int left = 7;
		int right = 14;

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < i + 1; k++) {
				arr[i][k] = i + 1;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < k + 1; i++) {
				arr[i][k] = k + 1;
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int k = 0; k < n; k++) {
//				System.out.print(arr[i][k]+" ");
//			}
//			System.out.println();
//		}

		int[] result = new int[n * n];
		int idx = 0;
		
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				result[idx++] = arr[i][k];
			}
		}
		
		for (int i = left; i < right + 1; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
