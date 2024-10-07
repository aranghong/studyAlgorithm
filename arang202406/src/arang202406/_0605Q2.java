package arang202406;

public class _0605Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
		int[] arr = { 2, 1, -4, 3, 4, -4, 6, 5, -5, 1 };

		int[] dp = new int[arr.length];
		int idx = 1;
		dp[0] = arr[0];

		while (true) {
			if (idx > arr.length - 1) {
				break;
			}
			dp[idx] = Math.max(arr[idx], arr[idx] + dp[idx - 1]);
			System.out.print(dp[idx] + " ");
			idx++;
		}
		System.out.println();

		int max = dp[0];

		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println("max>" + max);

//		int s = 0;
//		int e = 0;
//		int total = 0;
//		int max = 0;
//		int before = 0;
//
//		while (true) { //s++
//			if (s > arr.length - 1 || e > arr.length - 1) {
//				break;
//			}
//			total = arr[s];
////			max = total;
//			before = total;
//			e = s + 1;
//			System.out.println();
//			System.out.println("s>"+arr[s]);
//
//			while (true) { //e++
//				if (e > arr.length - 1) {
//					break;
//				}
//				if (total >= max) {
//					
//					while (true) {
//						if (e > arr.length - 1) {
//							System.out.println("xxxxx");
//							break;
//						}
//						
//						System.out.print(arr[e] + " ");
//						before = total;
//						total += arr[e];
////						max = before;
//						e++;
//						if (total < before) {
//							System.out.println("max>" + before);
//							break;
//						}
//					}
//					
//					max = total;
//					System.out.println("max>"+max);
//					break;
//					
//				}
////				if (total < before) {
////					break;
////				}
//
//				System.out.print(arr[e] + " ");
//				before = total;
//				total += arr[e];
//				e++;
//			}
//			
//			System.out.println();
//			s++;
//			e = s + 1;
//		}
	}

}
