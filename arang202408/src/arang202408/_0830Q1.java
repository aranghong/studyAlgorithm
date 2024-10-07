package arang202408;

import java.util.ArrayList;

public class _0830Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] order = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
//		String[] order = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
//		String[] order = { "XYZ", "XWY", "WXA" };

		int[] course = { 2, 3, 4 };
//		int[] course = { 2, 3, 5 };
//		int[] course = { 2, 3, 4 };

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//조합->빈도수계산->가장많이주문된조합선택->결과정렬,출력 
		
		for (int i = 0; i < course.length; i++) {
			for (int k = 0; k < order.length; k++) {
				if (order[k].length() >= course[i]) {
					
				}
			}
		}
		
		
		
		
	}
	
//	static dfs(String[] order, int course, int cnt, ) {
//		
//	}

}
