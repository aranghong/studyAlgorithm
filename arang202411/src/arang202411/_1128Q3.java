package arang202411;

import java.util.ArrayList;
import java.util.Arrays;

public class _1128Q3 {
	static ArrayList<int[]> sortArr = new ArrayList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 7;
//		int m = 2;
//		int[] arr = {1,2,2,2,1,2,1};	//m종류 n개 인형 
		
		int n = 12;
		int m = 4;
		int[] arr = {1,3,2,4,2,1,2,3,1,1,3,4};	//m종류 n개 인형 
		
		int[] Mcnt = new int[m];
		
		
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < arr.length; k++) {
				if (i + 1 == arr[k]) {
					Mcnt[i]++;
				}
			}
		}
		
		System.out.println(Arrays.toString(Mcnt));
		
		
		for (int i = 0; i < m; i++) {
			
			int[] check = new int[m];
			int[] temp = new int[n];
			sort(Mcnt, check, i, 0, temp, 0);
		}
		
		int min = 1000000;
		for (int i = 0; i < sortArr.size(); i++) {
			int cnt = 0;
			for (int k = 0; k < sortArr.get(i).length; k++) {
				if (arr[k] != sortArr.get(i)[k]) {
					cnt++;
				}
			}
			
			if (min > cnt) {
				min = cnt;
			}
		}
		
		System.out.println("result>" + min);
		
	}
	
	static void sort(int[] Mcnt, int[] check, int i, int cnt, int[] temp, int tempIdx) {
		if (tempIdx >= temp.length && cnt == Mcnt.length && !sortArr.contains(temp)) {
			System.out.println(Arrays.toString(temp));
			sortArr.add(temp);
		}
		
		if (i < 0 || i > Mcnt.length - 1 || tempIdx < 0 || tempIdx > temp.length - 1 || check[i] == 1 || cnt >= Mcnt.length) {
			return;
		}
		
		check[i] = 1;
		for (int x = 0; x < Mcnt[i]; x++) {
			temp[tempIdx] = i + 1;
			tempIdx++; 
		}
		
		sort(Mcnt, check, i + 1, cnt + 1, temp, tempIdx);
		sort(Mcnt, check, i - 1, cnt + 1, temp, tempIdx);

	}

}
