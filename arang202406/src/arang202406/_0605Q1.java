package arang202406;

public class _0605Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ACAYKP";
		String s2 = "CAPCAK";
		int result = 0;
		int max = 0;
		
		int[][] dp = new int[s2.length()+1][s1.length()];
		
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int k = 0; k < dp[i].length; k++) {
				if (k == 0) {
					if (s1.charAt(k) == s2.charAt(i-1)) {
						dp[i][k] = dp[i-1][0] + 1;
					}
					else {
						dp[i][k] = dp[i-1][0];
					}
				}
				else {
					if (s1.charAt(k) == s2.charAt(i-1)) {
						dp[i][k] = dp[i-1][k-1] + 1;
					}
					else {
						dp[i][k] = Math.max(dp[i-1][k], dp[i][k-1]);
					}
				}
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int k = 0; k < dp[0].length; k++) {
				System.out.print(dp[i][k] + " ");
			}
			System.out.println();
		}
		
		System.out.println(dp[s2.length()][s1.length()-1]);
		
		
//		for (int i = 0; i < s1.length(); i++) {
//			result = 0;
//			char s1_c = s1.charAt(i);
//			char s2_c;
//			int s2_idx = 0;
//			for (int k = 0; k < s2.length(); k++) {
//				if (s1_c == s2.charAt(k)) {
//					s2_c = s2.charAt(k);
//					s2_idx = k;
////					System.out.print(s2_c+" ");
//					break;
//				}
//				else {
//					s2_idx = -1;
//				}
//			}
//			
//			if (s2_idx >= 0) {
//				int x_idx = i;
//				int y_idx = s2_idx;
//				
//				for (int x = x_idx; x < s1.length(); x++) {
//					for (int y = y_idx; y < s2.length(); y++) {
//						if (s1.charAt(x) == s2.charAt(y)) {
//							result++;
//							y_idx = y;
//							System.out.print(s1.charAt(x)+" ");
//							break;
//						}
//					}
//					
//				}
//				System.out.println();
//				System.out.println("result>"+ result);
//				if (result > max) {
//					max = result;
//					System.out.println("max>"+max);
//				}
//			}
//			
//		}
//		result = max;
//		System.out.println("result>"+result);
	}

}
