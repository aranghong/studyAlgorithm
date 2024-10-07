package arang202404;

public class _0411Q2 {

	static String[] g = { "S", "L", "R" }; // s직진 l좌회전 r우회전
	static String[][] grid;
	static int start_r = 0;
	static int start_c = 0;

	static int start_pos = 0;
	// int start_be_c = 0;

	static int cur_r = 0;
	static int cur_c = 0;

	static int pos = 0;
	// int be_c = 0;

	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "SL", "LR" };
		// String[] arr = { "S" };
		// String[] arr = { "R, R" };

		grid = new String[arr.length][arr[0].length()];

		for (int i = 0; i < arr.length; i++) {
			grid[i] = arr[i].split("");
		}

//		for (int i = 0; i < arr.length; i++) {
//			for (int k = 0; k < arr[i].length(); k++) {
//				System.out.print(grid[i][k]+" ");
//			}
//			System.out.println();
//		}

		if (grid[0][0].equals("S")) { // 0:위>아래 1:아래>위 2:좌>우 3:우>좌
			for (int i = 0; i < 4; i++) {
				pos = i;
				cycle();
			}
		}
		if (grid[0][0].equals("L")) { // 10:위>우 11:아래>좌 12:좌>위 13:우>아래
			for (int i = 0; i < 4; i++) {
				pos = 10 + i;
				cycle();
			}
		}
		if (grid[0][0].equals("R")) { // 20:위>좌 21:아래>우 22:좌>아래 23:우>위
			for (int i = 0; i < 4; i++) {
				pos = 20 + i;
				cycle();
			}
		}

	}

	static void cycle() {
		while (true) {
			if (start_r == cur_r && start_c == cur_c && start_pos == pos) {
				System.out.println("result>" + result);
				break;
			}

			if (grid[cur_r][cur_c].equals("S")) {
				if (pos == 0) {
					//if () {	//인덱스 끝일 경우 	
					//}
					cur_r++;
				}
			}
			if (grid[cur_r][cur_c].equals("L")) {

			}
			if (grid[cur_r][cur_c].equals("R")) {

			}
		}
	}

}
