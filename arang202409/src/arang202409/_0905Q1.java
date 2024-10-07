package arang202409;

public class _0905Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] si = { 800, 700, 900 };
//		int[] di = { 198, 330 };
		
		//조합 

		int[] si = { 1999, 1999, 100 };
		int[] di = { 189, 100 };
		
		int min = 100000;
		
		for (int i = 0; i < si.length; i++) {
			
			for (int k = 0; k < di.length; k++) {
				System.out.println(si[i]+" "+di[k]);
				
				int cost = si[i] + di[k] - 50;
				
				if (cost < min) {
					min = cost;
				}
				
			}
		}
		
		
		System.out.println("cost>"+min);
		

	}

}
