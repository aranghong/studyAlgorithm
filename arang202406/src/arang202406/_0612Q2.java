package arang202406;

import java.util.Arrays;

public class _0612Q2 {

	static int minDistance = 10000; // 능력치 차이
	static int n = 4; // 총 사람 수
	static int people = n / 2; // 한팀당 팀원 수
	static int[][] arr = {
			{0,1,2,3,4,5},
			{1,0,2,3,4,5},
			{1,2,0,3,4,5},
			{1,2,3,0,4,5},
			{1,2,3,4,0,5},
			{1,2,3,4,5,0},
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 4; // 총 사람 수
//		int[][] arr = { { 0, 1, 2, 3 }, { 4, 0, 5, 6 }, { 7, 1, 0, 2 }, { 3, 4, 5, 0 } };
		int start = 0;
		int link = 0;

//		int people = n / 2; // 한팀당 팀원 수
		int tempDistance = 0;
		int startPower = 0; // ->check==0
		int linkPower = 0; // ->check==1
		int thisPeople = 0;

		int[] check = new int[n];

//		for (int i = 0; i < n; i++) {
//			int[][] arr = { { 0, 1, 2, 3 }, { 4, 0, 5, 6 }, { 7, 1, 0, 2 }, { 3, 4, 5, 0 } };
//			check = new int[n];
//			startPower = 0;
//			linkPower = 0;
//			dfs(arr, check, i, 0, startPower, linkPower);
//		}
		
		int[] chk = new int[6];
		
		
		dfs(chk,3,0,0);

	}
	//0 1    2 3
	//0 2    1 3
	//0 3    1 2
	//
	
	static void dfs(int chk[],int n,int cnt,int s) {
		if(cnt==n) {
			System.out.println(Arrays.toString(chk));
			cc(0,0,chk,arr);
			return;
		}
		for(int i=s;i<chk.length;i++) {
			if(chk[i]==0) {
				chk[i]=1;
				dfs(chk,n,cnt+1,i+1);
				chk[i]=0;
			}
		}
		
	}
	
	static void cc(int startPower, int linkPower,int[] chk,int[][] arr) {
		
//		int checkA = 0;
//		int checkB = 0;

		for (int i = 0; i < chk.length; i++) {
			if (chk[i] == 0) { // start
//				if (checkA > 0) {
//					continue;
//				}
//				checkA++;
				System.out.print("start>");
				System.out.print(i + " ");
				for (int k = i + 1; k < chk.length; k++) {
					if (chk[k] == 0) {
						startPower += arr[i][k] + arr[k][i];
						
						System.out.print(k + " ");
					}
				}
				System.out.println();
			} else if (chk[i] == 1) { // link
//				if (checkB > 0) {
//					continue;
//				}
//				checkB++;
				System.out.print("link>");
				System.out.print(i + " ");
				for (int k = i + 1; k < chk.length; k++) {
					if (chk[k] == 1) {
						linkPower += arr[i][k] + arr[k][i];
						
						System.out.print(k + " ");
					}
				}
				System.out.println();
			}
		}

		System.out.println("startPower>" + startPower);
		System.out.println("linkPower>" + linkPower);

		if (startPower - linkPower > 0) {
			if (startPower - linkPower < minDistance) {
				minDistance = startPower - linkPower;
				System.out.println("minDistance>" + minDistance);
				System.out.println();
			}
		} else if (startPower - linkPower == 0) {
			minDistance = 0;
			System.out.println("minDistance>" + minDistance);
			System.out.println();
		} else {
			if (startPower - linkPower < minDistance) {
				minDistance = (-1) * (startPower - linkPower);
				System.out.println("minDistance>" + minDistance);
				System.out.println();
			}
		}

	}
	
	static void dfs(int[][] arr, int[] check, int cur, int pp, int startPower, int linkPower) {
		if (cur < 0 || cur > arr.length - 1 || check[cur] > 0) {
			return;
		}
		System.out.println("cur>" + cur);
		
		if (pp == people) {
			int checkA = 0;
			int checkB = 0;

			for (int i = 0; i < check.length; i++) {
				if (check[i] == 0) { // start
					if (checkA > 0) {
						continue;
					}
					checkA++;
					System.out.print("start>");
					System.out.print(i + " ");
					for (int k = i + 1; k < check.length; k++) {
						if (check[k] == 0) {
							startPower += arr[i][k] + arr[k][i];
							arr[i][k] = 0;
							arr[k][i] = 0;
							System.out.print(k + " ");
						}
					}
					System.out.println();
				} else if (check[i] == 1) { // link
					if (checkB > 0) {
						continue;
					}
					checkB++;
					System.out.print("link>");
					System.out.print(i + " ");
					for (int k = i + 1; k < check.length; k++) {
						if (check[k] == 1) {
							linkPower += arr[i][k] + arr[k][i];
							arr[i][k] = 0;
							arr[k][i] = 0;
							System.out.print(k + " ");
						}
					}
					System.out.println();
				}
			}

			System.out.println("startPower>" + startPower);
			System.out.println("linkPower>" + linkPower);

			if (startPower - linkPower > 0) {
				if (startPower - linkPower < minDistance) {
					minDistance = startPower - linkPower;
					System.out.println("minDistance>" + minDistance);
					System.out.println();
					return;
				}
			} else if (startPower - linkPower == 0) {
				minDistance = 0;
				System.out.println("minDistance>" + minDistance);
				System.out.println();
				return;
			} else {
				if (startPower - linkPower < minDistance) {
					minDistance = (-1) * (startPower - linkPower);
					System.out.println("minDistance>" + minDistance);
					System.out.println();
					return;
				}
			}
		}

		check[cur] = 1; // link

		dfs(arr, check, cur + 1, pp + 1, startPower, linkPower);
		check[cur] = 0;

	}

}
