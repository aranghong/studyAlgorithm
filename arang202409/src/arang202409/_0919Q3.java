package arang202409;

import java.util.ArrayList;

public class _0919Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int n = 19;
		int cur = n;
		int cnt = 0;

		while (true) {
			if (cur == 1) {
				System.out.println("great");
				break;
			}
			

			String str = Integer.toString(cur);
			int total = 0;

			for (int i = 0; i < str.length(); i++) {
				int tmp = Integer.parseInt(str.substring(i, i + 1));

				total += (tmp * tmp);
			}
			System.out.println(total);
			if (cnt > 0 && result.contains(total)) {
				System.out.println("stupid");
				break;
			}

			cur = total;
			result.add(cur);
			cnt++;
		}
	}

}
