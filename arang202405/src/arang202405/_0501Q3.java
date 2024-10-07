package arang202405;

public class _0501Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{55,185},{58,183},{88,186},{60,175},{46,155}};
		int[][] temp = arr.clone();
		
		int[] result = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length -1; k++) {
				if (temp[k][0] < temp[k+1][0]) {
					int[] t = temp[k];
					temp[k] = temp[k+1];
					temp[k+1] = t;
				}
				
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i][0]+" "+temp[i][1]);
		}
		
		int cnt = 0; // 총 사람 수 카운
		
		while(true) {
			if (cnt == temp.length) {
				System.out.println("끗");
				break;
			}
			
			int max = 0;
			int n = 1; // 같은 등수 카운
			
			for (int i = 0; i < arr.length; i++) {
				if (temp[cnt][0] == arr[i][0]) {
					result[i] = cnt+1;
					
					for (int k = cnt+1; k < temp.length; k++) {
						max = temp[cnt][1];
						if (max < temp[k][1]) {
							for (int x = 0; x < arr.length; x++) {
								if (temp[k][0] == arr[x][0]) {
									result[x] = cnt+1;
									n++;
									break;
								}
							}
						}
					}
					break;
				}
			}
			
			cnt += n;
			
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
