package arang202410_study;

public class _1007Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution_1017_1 s = new Solution_1017_1();

		String[] c = { "prev", "next", "next" };

		String answer = s.solution("10:55", "00:05", "00:15", "06:55", c);

		System.out.println("answer>" + answer);
	}

}

class Solution_1017_1 {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		String answer = "";

		int vl = timeToSec(video_len);
		int p = timeToSec(pos);
		int s = timeToSec(op_start);
		int e = timeToSec(op_end);

		if (p >= s && p <= e) {
			p = e;
		}
		
		for (int i = 0; i < commands.length; i++) {
			if (commands[i].equals("prev")) {
				if (p >= 10) {
					p -= 10;
				} else {
					p = 0;
				}
			} else {
				if (p <= vl - 10) {
					p += 10;
				} else {
					p = vl;
				}
			}
			if (p >= s && p <= e) {
                p = e;
            }
		}
		
		int mm = p / 60;
		int ss = p % 60;

		String temp1;
		String temp2;
		if (mm < 10) {
			temp1 = "0" + Integer.toString(mm);
		} else {
			temp1 = Integer.toString(mm);
		}

		if (ss < 10) {
			temp2 = "0" + Integer.toString(ss);
		} else {
			temp2 = Integer.toString(ss);
		}

		answer = temp1 + ":" + temp2;

		return answer;
	}

	int timeToSec(String str) {
		String[] spl = str.split(":");

		int result = Integer.parseInt(spl[0]) * 60 + Integer.parseInt(spl[1]);

		System.out.println(result);
		
		return result;
	}
}
