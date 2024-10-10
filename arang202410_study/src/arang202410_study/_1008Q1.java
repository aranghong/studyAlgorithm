package arang202410_study;

public class _1008Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_1018_1 s = new Solution_1018_1();
		int[] w = { 50, 50 };
		int[] b = { 100, 241 };
		System.out.println("answer>" + s.solution(w, b));
	}

}

class Solution_1018_1 {
	public int solution(int[] wallet, int[] bill) {
		int answer = 0;

		int[] tmp = new int[2];
		tmp = bill;

		while (true) {
			if (tmp[0] <= wallet[0] && tmp[1] <= wallet[1]) {
				break;
			}
			if (tmp[1] <= wallet[0] && tmp[0] <= wallet[1]) {
				break;
			}

			if (tmp[0] > tmp[1]) {
				tmp[0] = tmp[0] / 2;
			} else {
				tmp[1] = tmp[1] / 2;
			}

			answer++;

		}

		return answer;
	}
}
