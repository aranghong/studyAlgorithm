package arang202406;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _0625Q1 {
	static boolean result = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 100;
		int q = 100;

		
		// 총 입력 수 :n-1+q+1+n-1 -> 2n+q-1
		int total_input = 0;
		int[][] arr = null;
		int a = 0;

		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print("입력> ");
			
			if (total_input == (2 * n) + q - 1) {
				System.out.println("끗!!!!!!!");
				break;
			}

			String s = in.nextLine();

			if (total_input == 0) {
				String[] temp = s.split(" ");
				n = Integer.parseInt(temp[0]);
				q = Integer.parseInt(temp[1]);

				arr = new int[n][n]; // 부모 기준 자식과 엣지 연결된건 1, 연결안된건 0
				System.out.println("입력수>" + ((2 * n) + q - 1));
			}

			if (total_input > 0 && total_input < n && s.length() < 3) {
				a = Integer.parseInt(s);

				arr[a - 1][total_input] = 1; // total 자식이랑 a 부모 연결
				System.out.println("엣지 연결 ");
			}

			if ((s.length() == 3 || s.length() == 4) && total_input > 0) { // 공백 포함 2글자 -> 엣지 지우기
				String[] temp = s.split(" ");
				int b = Integer.parseInt(temp[1]); // 부모랑 b의 엣지를 지움

				for (int i = 0; i < arr.length; i++) {
					if (arr[i][b - 1] == 1) {
						arr[i][b - 1] = 0;
					}
				}
				System.out.println("엣지 삭제 ");
			}
			if (s.length() >= 5) { // 공백 포함 3글자 -> 질의 응답
				result = false;
				int chk = 0;
				
				String[] temp = s.split(" ");
				int c = Integer.parseInt(temp[1]);
				int d = Integer.parseInt(temp[2]);
				
				//dfs
				int[] check = new int[n];
				int[] tmp = new int[n];
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = -1;
				}
				
				dfs(arr,c-1,d-1,c-1,check,tmp,0);	//start:c, end:d
				System.out.println(result);
				if (result == true) {
					chk++;
				}
				System.out.println(Arrays.toString(tmp));
				
				check = new int[n];
				result = false;
				tmp = new int[n];for (int i = 0; i < tmp.length; i++) {
					tmp[i] = -1;
				}
				
				dfs(arr,d-1,c-1,d-1,check,tmp,0);	//start:d. end:c
				System.out.println(result);
				if (result == true) {
					chk++;
				}
				System.out.println(Arrays.toString(tmp));
				
				if (chk > 0) {
					System.out.println("*****YES");
				}
				else {
					System.out.println("*****NO");
				}
			}

			total_input++;
		}

	}
	
	static void dfs(int[][] arr, int s, int e, int cur, int[] check, int[] tmp, int cnt) {
		if (cur == e) {
			tmp[cnt] = cur+1;
			result = true;
			return;
		}
		if (cur < 0 || cur >= arr.length || check[cur] == 1) {
			result = false;
			return;
		}
		
		//부모가 있으면 
		check[cur] = 1;
		tmp[cnt] = cur+1;
		
		for (int i = 0; i < arr[0].length; i++) {	//부모cur->자식 
			if (arr[cur][i] == 1) {
				dfs(arr,s,e,i,check,tmp,cnt+1);
			}
		}
		for (int i = 0; i < arr.length; i++) {	//자식cur->부모 
			if (arr[i][cur] == 1) {
				dfs(arr,s,e,i,check,tmp,cnt+1);
			}
		}
		
	}

}
