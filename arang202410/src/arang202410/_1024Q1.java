package arang202410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _1024Q1 {
	static int total = 0;
	static int max = 0;
	static int[][] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 5;
//		int m = 5; // 가로 길이
//		String[][] arr = { 
//				{ ".", ".", ".", "3", "." },
//				{ ".", ".", ".", ".", "1" }, 
//				{ ".", ".", "0", ".", "3" },
//				{ "4", "8", "9", ".", "." }, 
//				{ ".", ".", ".", ".", "." } };

//		int n = 3;
//		int m = 5;
//		String[][] arr = {
//				{"9","9","9",".","1"},
//				{".",".",".",".","."},
//				{"1",".","9","9","9"}
//				
//		};

		int n = 5;
		int m = 5;
		String[][] arr = { 
				{ ".", "2", "7", ".", "." }, 
				{ "7", ".", "0", "6", "3" }, 
				{ ".", ".", ".", ".", "7" },
				{ "7", "8", ".", ".", "." }, 
				{ "8", ".", ".", ".", "2" } };

		ArrayList<Integer> list = new ArrayList<Integer>();

		check = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr[0].length; i++) {

//			//시추 전 최대 석유 추출할 수 있는 칸 선택 
//			HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
//			
//			for (int x = 0; x < arr[0].length; x++) {
//				max = 0;
//				int[] s_result = { 0 };
//				for (int y = 0; y < arr.length; y++) {
//					if (!arr[y][x].equals(".") && check[y][x] == 0) {
//						int[][] s_check = new int[arr.length][arr[0].length];
//						dfs(arr, s_check, y, x, s_result);
//					}
//				}
//				
//				temp.put(x, max);
//			}
//			
//			// HashMap의 값(Value) 중 가장 큰 값 찾기
//	        int maxValue = Collections.max(temp.values());
//
//	        // 가장 큰 값을 가진 키 찾기
//	        Integer maxKey = -1;
//	        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
//	            if (entry.getValue() == maxValue) {
//	                maxKey = entry.getKey();
//	                break;  // 첫 번째로 찾은 키를 반환 (중복 값이 있는 경우)
//	            }
//	        }
//			
//			int maxidx = maxKey;
//			System.out.println("i>" + maxidx);

			int maxidx = i;

			max = 0;
			int[] result = { 0 };
			for (int k = 0; k < arr.length; k++) {
				if (!arr[k][maxidx].equals(".") && check[k][maxidx] == 0) {
					dfs(arr, check, k, maxidx, result);
				}
			}

//			total += max;
			list.add(max);

//			System.out.println("total>" + total);

		}

		Collections.sort(list, Comparator.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
			System.out.println("total>" + total);
		}
	}

	static void dfs(String[][] arr, int[][] check, int r, int c, int[] result) {
		if (r < 0 || c < 0 || r > arr.length - 1 || c > arr[0].length - 1 || arr[r][c].equals(".")
				|| check[r][c] == 1) {
			if (result[0] > max) {
				max = result[0];
//				System.out.println(result);
			}
			return;
		}

		check[r][c] = 1;
		result[0] += Integer.parseInt(arr[r][c]);

		dfs(arr, check, r - 1, c, result); // 상
		dfs(arr, check, r + 1, c, result); // 하
		dfs(arr, check, r, c - 1, result); // 좌
		dfs(arr, check, r, c + 1, result); // 우
//		dfs(arr, check, r - 1, c - 1, result); // 좌상
//		dfs(arr, check, r - 1, c + 1, result); // 우상
//		dfs(arr, check, r + 1, c - 1, result); // 좌하
//		dfs(arr, check, r + 1, c + 1, result); // 우하

	}

}
