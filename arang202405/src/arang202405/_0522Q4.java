package arang202405;

public class _0522Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int sum = 15; // 15이상 합
		int[] arr = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
		int s = 0;
		int e = 0;
		int total = 0;
		int result = 0;
		int min = 10000;

		while (true) {
			if (s > arr.length - 1 || e > arr.length - 1) {
				break;
			}
			total = arr[s];
			e = s + 1;
			result = 1;
			System.out.println();
			System.out.print(arr[s] + " ");

			while (true) {
				if (e > arr.length - 1) {
					break;
				}
				if (total >= 15) {
					if (result < min) {
						min = result;
						System.out.println();
						System.out.println("min>" + min);
					}
					break;
				}

				System.out.print(arr[e] + " ");
				result++;
				total += arr[e];
				e++;
			}

			s++;
		}

		System.out.println("result>" + min);
	}

}
