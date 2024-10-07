package arang202405;

public class _0501Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 187;
		int cnt = 1;
		int min = 666;
		
		while(true) {
			if (cnt == n) {
				System.out.println("result>"+min);
				break;
			}
			
			if (Integer.toString(min).contains("666")) {
				cnt++;
				
			}
			
			min++;
		}
	}

}
