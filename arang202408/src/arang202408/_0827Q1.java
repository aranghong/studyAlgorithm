package arang202408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0827Q1 {
	static ArrayList<ArrayList<String>> totalresult = new ArrayList<ArrayList<String>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] arr = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] arr = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };

		String start = "ICN";
		int[] check = new int[arr.length];
//		String[] result = new String[arr.length];
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {
			if (start.equals(arr[i][0])) {
				check = new int[arr.length];
				result = new ArrayList<String>();
				result.add(start);
				dfs(arr, i, 0, check, result);
			}
		}
		
		for (int i = 0; i < totalresult.size(); i++) {
			System.out.println(totalresult.get(i).toString());
		}
		// 알파벳 순으로 가장 앞선 배열 찾기
        List<String> firstarr = totalresult.get(0);  // 첫번째 배열로 초기화

        for (int i = 1; i < totalresult.size(); i++) {
            List<String> cur = totalresult.get(i);

            // 알파벳 순 비교
            int size = Math.min(cur.size(), firstarr.size());
            boolean chk = false;

            for (int j = 0; j < size; j++) {
                int cmp = cur.get(j).compareTo(firstarr.get(j));
                if (cmp < 0) {
                	chk = true;
                    break;
                } else if (cmp > 0) {
                    break;
                }
            }

            // 리스트의 길이가 다를 경우, 더 짧은 리스트가 우선됨
            if (!chk && cur.size() < firstarr.size()) {
            	chk = true;
            }

            if (chk) {
            	firstarr = cur;
            }
        }

        // 결과 출력
        System.out.println("result>" + firstarr);

	}

	static void dfs(String[][] arr, int i, int cnt, int[] check, ArrayList<String> result) {
		if (cnt == arr.length - 1) {
			System.out.println(cnt);
			check[i] = 1;
			result.add(arr[i][1]);
			System.out.println(Arrays.toString(arr[i]));

			System.out.println("dfs 끝 ");
//			System.out.println(Arrays.toString(result));
			System.out.println(result.toString());
			
			totalresult.add(result);
			return;
		}
		if (i < 0 || i > arr.length - 1 || check[i] == 1) {
			return;
		}

		System.out.println(cnt);
		check[i] = 1;
		result.add(arr[i][1]);
		System.out.println(Arrays.toString(arr[i]));
		for (int k = 0; k < check.length; k++) {
			System.out.print(check[k] + " ");
		}
		System.out.println();

		for (int k = 0; k < arr.length; k++) {
			if (arr[i][1] == arr[k][0] && check[k] == 0) {
				dfs(arr, k, cnt + 1, check, result);
			}
		}
	}

}
