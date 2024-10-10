package arang202410_study;

public class _1008Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] mats = { 5, 3, 2 };
		String[][] park = { { "A", "A", "-1", "B", "B", "B", "B", "-1" }, { "A", "A", "-1", "B", "B", "B", "B", "-1" },
				{ "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
				{ "D", "D", "-1", "-1", "-1", "-1", "-1", "F" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" } };

		Solution_1018_2 s = new Solution_1018_2();
		System.out.println("answer>" + s.solution(mats, park));
	}

}
//깃

class Solution_1018_2 {
	public int solution(int[] mats, String[][] park) {
		int answer = -1; 

		reverse(mats);

//		System.out.println(Arrays.toString(mats));
		int result = -1;

		for (int i = 0; i < park.length; i++) {
			for (int k = 0; k < park[i].length; k++) {
				if (park[i][k].equals("-1")) {
					result = checkFunc(mats, park, i, k);
					if (result >= 0 && result < mats.length) {
						answer = mats[result];
						return answer;
					}
				}
			}
		}
		return answer;
	}

	// 내림차순 배열을 위한 reverse 함수
	private void reverse(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
	        int maxIdx = i;
	        // 나머지 요소 중에서 가장 큰 값을 찾음
	        for (int j = i + 1; j < arr.length; j++) {
	            if (arr[j] > arr[maxIdx]) {
	                maxIdx = j;
	            }
	        }
	        // 가장 큰 값과 현재 i번째 요소를 교환
	        int temp = arr[i];
	        arr[i] = arr[maxIdx];
	        arr[maxIdx] = temp;
	    }
	}

	int checkFunc(int[] mats, String[][] park, int r, int c) {

		int cnt = 0;
		int chk = 0;

		for (int i = 0; i < mats.length; i++) {
			if (r + mats[i] <= park.length && c + mats[i] <= park[r].length) {
				for (int x = r; x < r + mats[i]; x++) {
					for (int y = c; y < c + mats[i]; y++) {
						if (park[x][y].equals("-1")) {
							cnt++;
						} else {
							chk = 1;
							break;
						}
					}
					if (chk == 1) {
						break;
					}
				}
				if (chk == 0 && cnt == mats[i] * mats[i]) {
					System.out.println(cnt);
					return i;
				}
			}
		}

		return -1;
	}

}