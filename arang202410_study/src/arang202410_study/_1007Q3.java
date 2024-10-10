package arang202410_study;

public class _1007Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_1007_3 s = new Solution_1007_3();

		s.solution(23);
	}

}

class Solution_1007_3 {
	public int solution(int age) {
		int answer = 0;

		answer = 2022 - age + 1;
		
//		System.out.println(answer);

		return answer;
	}
}
