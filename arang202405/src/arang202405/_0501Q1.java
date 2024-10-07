package arang202405;

public class _0501Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 5;
//		int m = 21;
//		int[] arr = {5,6,7,8,9};
		
		int n = 10;
		int m = 500;
		int[] arr = {93,181,245,214,315,36,185,138,216,295};
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length; k++) {
				if (k != i) {
					for (int x = 0; x < arr.length; x++) {
						if (x != i && x != k) {
							int temp = arr[i]+arr[k]+arr[x];
							if (temp <= m && sum < temp) {
								sum = temp;
							}
						}
					}
				}
				
			}
		}
		
		System.out.println("sum>"+sum);
	}

}
