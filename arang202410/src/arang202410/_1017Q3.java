package arang202410;

public class _1017Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Long.parseLong(a);
		long a = 6;
		long b = 1234567;
		int v = 3;
		
//		long a = 100;
//		long b = 200;
//		int v = 5;

		long cur = a;
		long cnt = 0;


		while (true) {
			if (cur > 0 && cur < 10 && cur % v == 0) {
				System.out.println(cur + " cnt++");
				cnt++;
				cur++;
			}
			else if (cur > 0 && cur < 10 && cur % v != 0) {
				cur++;
				continue;
			}
			
			if (cur >= 10 && cur % v != 0) {
				cur++;
			} 
			else if (cur >= 10 && cur % v == 0) {
				if (cur > b) {
					System.out.println("cnt>" + cnt);
					System.out.println("cnt%%>" + cnt % 10000);
					break;
				}

				String strcur = Long.toString(cur);
				int be = strcur.charAt(0);
				int check = 0;
//				System.out.println(strcur.charAt(0));

				if (Integer.parseInt(Character.toString(strcur.charAt(1))) < Integer.parseInt(Character.toString(be))) {
//					System.out.println("감소 ");
//					System.out.println(strcur.charAt(1));

					check = -1;
					be = strcur.charAt(1);
					int chk = 0;

					for (int i = 2; i < strcur.length(); i++) {
						if (check == -1 && Integer.parseInt(Character.toString(strcur.charAt(i))) > Integer
								.parseInt(Character.toString(be))) { // 현재 감소일 경우 증가되어야 함
//							System.out.println("증가 ");
//							System.out.println(strcur.charAt(i));

							check = 1;
							chk++;
						}
						if (check == 1 && Integer.parseInt(Character.toString(strcur.charAt(i))) < Integer
								.parseInt(Character.toString(be))) { // 현재 증가일 경우 감소되어야 함
//							System.out.println("감소 ");
//							System.out.println(strcur.charAt(i));

							check = -1;
							chk++;
						}
					}

					if (chk == strcur.length() - 2) {
						System.out.println(cur + " cnt++");

						cnt++;
					}

				} else if (Integer.parseInt(Character.toString(strcur.charAt(1))) > Integer
						.parseInt(Character.toString(be))) {
//					System.out.println("증가 ");
//					System.out.println(strcur.charAt(1));

					check = 1;
					be = strcur.charAt(1);
					int chk = 0;

					for (int i = 2; i < strcur.length(); i++) {
						if (check == -1 && Integer.parseInt(Character.toString(strcur.charAt(i))) > Integer
								.parseInt(Character.toString(be))) { // 현재 감소일 경우 증가되어야 함
//							System.out.println("증가 ");
//							System.out.println(strcur.charAt(i));

							check = 1;
							chk++;
						}
						if (check == 1 && Integer.parseInt(Character.toString(strcur.charAt(i))) < Integer
								.parseInt(Character.toString(be))) { // 현재 증가일 경우 감소되어야 함
//							System.out.println("감소 ");
//							System.out.println(strcur.charAt(i));

							check = -1;
							chk++;
						}
					}

					if (chk == strcur.length() - 2) {
						System.out.println(cur + " cnt++");

						cnt++;
					}
				} else {
					System.out.println(cur + " xxxxxx");
				}

				cur++;
			}

		}
	}

}
