package arang202406;

public class _0612Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 6, 13 }, { 4, 8 }, { 3, 6 }, { 5, 12 } };
		int maxWeight = 7;

		int maxValue = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length - 1; k++) {
				if (arr[k][0] > arr[k + 1][0]) {
					int[] temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}

		int s = 0;
		int e = 0;

		while (true) {
			if (s >= arr.length || e >= arr.length) {
				System.out.println("인덱스 오버 ");
				break;
			}

			e = s + 1;
			int tmpWeight = arr[s][0];
			int tmpValue = arr[s][1];
			System.out.print(arr[s][0]+" ");
			
			while (true) {
				if (e >= arr.length) {
					System.out.println("e 끝 ");
					break;
				}
				
				if (tmpWeight + arr[e][0] > maxWeight) {
					if(maxValue < tmpValue) {
						maxValue = tmpValue;
						
						System.out.println(".......max Value>" + maxValue);
					}
					
					break;
				}

				System.out.print(arr[e][0]+" ");

				tmpWeight += arr[e][0];
				tmpValue += arr[e][1];
			
				e++;
			}

			s++;
			System.out.println();
		}
	}
}
