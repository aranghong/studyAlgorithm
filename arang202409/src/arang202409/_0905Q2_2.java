package arang202409;

public class _0905Q2_2 {
//	static int d = 2;
	static int d = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] arr = { { ".", ".", ".", "#", "." }, { "#", ".", ".", ".", "#" }, { ".", ".", ".", ".", "#" } };

		String[][] arr = { { ".", "#", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", "#", "#" },
				{ ".", ".", ".", ".", ".", ".", "." }, { "#", ".", ".", ".", ".", ".", "." } };
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				int check = 0;
				// 우
				for (int x = 0; x < d; x++) {
					if (k + x >= arr[0].length || arr[i][k + x].equals("#")) {
						check = 1;
						break;
					}
				}
				if (check == 0) {
					result++;
				}

				check = 0;
				// 좌
				for (int x = 0; x < d; x++) {
					if (i + x >= arr.length || arr[i + x][k].equals("#")) {
						check = 1;
						break;
					}
				}
				if (check == 0) {
					result++;
				}
			}
		}

		System.out.println("result>" + result);
	}

}
