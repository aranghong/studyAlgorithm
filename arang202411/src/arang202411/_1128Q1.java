package arang202411;

public class _1128Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int q = 4;
		int[][] Aarr = {{35,100},{70,70},{45,15},{80,40},{20,95}};
		int[][] Barr = {{20,50,120},{10,10,100},{60,60,80},{0,100,100}};
		
		for(int i = 0; i < Barr.length; i++) {
			int result = 0;
			
			for (int k = 0; k < Aarr.length; k++) {
				if (Aarr[k][0] >= Barr[i][0] && Aarr[k][1] >= Barr[i][1] && (Aarr[k][0] + Aarr[k][1]) >= Barr[i][2]) {
					result++;
				}
			}
			
			System.out.println("result>"+result);
		}

	}

}
