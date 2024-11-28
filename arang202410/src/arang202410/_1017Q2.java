package arang202410;

public class _1017Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String newB = "bar";
		String[] oldB = { "abracadabra", "bear", "bar", "baraxbara" };
		int cnt = 0;

		for (int i = 0; i < oldB.length; i++) {
			for (int k = 0; k < oldB[i].length(); k++) {
				if (oldB[i].charAt(k) == newB.charAt(0)) { // b찾음
//					System.out.println(oldB[i]);
					for (int g = 1; g < (int) (oldB[i].length() - k) / (newB.length() - 1); g++) { // 간격
						int check = 1;
						int gapcheck = k;

						for (int c = 1; c < newB.length(); c++) {
//							System.out.println(gapcheck);
							gapcheck += g;
//							System.out.println(gapcheck);
							if (gapcheck < oldB[i].length() && oldB[i].charAt(gapcheck) == newB.charAt(c)) {
								check++;
							}
						}
						if (check == newB.length()) {
//							System.out.println("!!!!!!!");
//							System.out.println(oldB[i]);
							cnt++;
						}
					}
				}
			}
		}

		System.out.println("cnt>" + cnt);
	}

}
