package arang202405;

public class _0508Q1 {
	String[][] arr;
	static int Bcount;
	static int Wcount;
	static int result = 100000;
	static String check;
	
	static void paint(String[][] arr, int sr, int sc){
		
		Bcount = 0;
		Wcount = 0;
		check = "B";
		
		for (int i = sr; i < sr+8; i++) {	//처음이 B일 경우 
			if (i > 0) {
				if(i%2==1) {
					check="W";
				}else {
					check="B";
				}
//				if (arr[i-1][0].equals("B")) {
//					check = "B";
//				}
//				else {
//					check = "W";
//				}
			}
			for (int k = sc; k < sc+8; k++) {
				if (i == 0 && k == 0) {
					if (arr[i][k].equals("W")) {
						Bcount++;
					}
					check = "B";
					continue;
				}
				if (arr[i][k].equals(check)) {	//왼쪽(체크)과 같음 
					Bcount++;
					if (arr[i][k].equals("B")) {
						check = "W";
					}
					else {
						check = "B";
					}
				}
				else {
					check = arr[i][k];
				}
			}	//한 행 끝
			
		}
		check="W";
		for (int i = sr; i < sr+8; i++) {	//처음이 W일 경우 
			if (i > 0) {
				if(i%2==1) {
					check="B";
				}else {
					check="W";
				}
//				if (arr[i-1][0].equals("B")) {
//					check = "W";
//				}
//				else {
//					check = "B";
//				}
			}
			for (int k = sc; k < sc+8; k++) {
				if (i == 0 && k == 0) {
					if (arr[i][k].equals("B")) {
						Wcount++;
					}
					check = "W";
					continue;
				}
				if (arr[i][k].equals(check)) {	//왼쪽(체크)과 같음 
					Wcount++;
					if (arr[i][k].equals("B")) {
						check = "W";
					}
					else {
						check = "B";
					}
				}
				else {
					check = arr[i][k];
				}
			}	//한 행 끝
			
		}
		System.out.println("Bcount>"+Bcount);
		System.out.println("Wcount>"+Wcount);
		
		int min = 100000;
		if (Bcount < Wcount) {
			min = Bcount;
		}
		else {
			min = Wcount;
		}
		
		if (result > min) {
			result = min;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 8;
//		int m = 8;
		
//		String[][] arr = {
//				{"W","B","W","B","W","B","W","B"},
//				{"B","W","B","W","B","W","B","W"},
//				{"W","B","W","B","W","B","W","B"},
//				{"B","W","B","B","B","W","B","W"},
//				{"W","B","W","B","W","B","W","B"},
//				{"B","W","B","W","B","W","B","W"},
//				{"W","B","W","B","W","B","W","B"},
//				{"B","W","B","W","B","W","B","W"}
//		};
		
		String[][] arr = {
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B"},
				{"B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","W"}
		};
		
		for (int i = 0; i <= arr.length-8; i++) {
			System.out.println(i);
			for (int k = 0; k <= arr[i].length-8; k++) {
				System.out.println(k);
				paint(arr,i,k);
				//System.out.println(result);
			}
			System.out.println();
		}
		
		
		
		System.out.println("result>"+result);
		System.out.println("check>"+check);
		
		
	}

}
