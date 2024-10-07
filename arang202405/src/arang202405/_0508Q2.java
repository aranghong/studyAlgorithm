package arang202405;

public class _0508Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n = 256;
		int n = 216;
		
		int tmp = n;
		int result = 10000;
		int sum = 0;
		int m = 0;
		
		while(true) {
			if (sum == n && result > m) {
				result = m;
				System.out.println("result>"+m);
				break;
			}
			
			m++;
			tmp = m;
			sum = m;
			
			while(true) {
				if (tmp / 10 == 0) {
					sum += tmp%10;
					break;
				}
				
				sum += tmp%10;
				
				tmp /= 10;
			}
			
			
		}
	}

}
