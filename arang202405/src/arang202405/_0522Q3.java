package arang202405;

public class _0522Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = { -2, 4, -99, -1, 98 };

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length - 1; k++) {
				if (arr[k] > arr[k + 1]) {
					int temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int x = 0;
		int y = 0;
		int min = 10000; // 0에서 얼마나 멀어져 있는지

		int s = 0;
		int e = arr.length - 1;

		while (true) {
			if (s == e) {
				System.out.println(x + " " + y);
				System.out.println("min>" + min);
				break;
			}

			if (arr[s] + arr[e] < 0) {
				int result = arr[s] + arr[e];
				result *= -1;
				if (min > result) {
					min = result;
					x = arr[s];
					y = arr[e];
				}
			} else if (arr[s] + arr[e] == 0) {
				System.out.println(x + " " + y);
				System.out.println("min>" + min);

				break;
			} else {
				int result = arr[s] + arr[e];
				if (min > result) {
					min = result;
					x = arr[s];
					y = arr[e];
				}
			}

			s++;
			e--;
		}

	}

}
