package arang202409;

public class _0919Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 200; // 총 인원 수
		int k = 56;
		int m = 5;
		int cur = 0;

		int[] p = { 40, 50, 30, 40, 40 };

		for (int i = 0; i < p.length; i++) {
			if (i == 0 && p[i] >= k) {
				System.out.println("result>" + (i + 1));
				break;
			}

			cur += p[i];

			if (i > 0 && cur >= k && cur - p[i - 1] < k) {
				System.out.println("result>" + (i + 1));
				break;
			}
		}
	}

}
