package arang202409;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _0926Q1 {
	static int n = 5; // 마을 개수
	static ArrayList<Integer> distance = new ArrayList<Integer>();
	static ArrayList<int[]> arr = new ArrayList<int[]>();
	static ArrayList<ArrayList<Integer>> dis_table = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int n = 5; // 마을 개수
//		int[] distance = { 1, 1, 1, 1, 1 }; // 마을 간 거리
//		ArrayList<Integer> distance = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			distance.add(1);
		}

		int m = 4; // 지시사항 개수
//		ArrayList<int[]> arr = new ArrayList<int[]>();

		int[] tmp = { 1, 1, 5 };
		int[] tmp2 = { 4, 2 };
		int[] tmp3 = { 3, 2 };
		int[] tmp4 = { 4, 2 };
		int[] tmp5 = { 2, 1, 1 };
		arr.add(tmp);
		arr.add(tmp2);
		arr.add(tmp3);
		arr.add(tmp4);
		arr.add(tmp5);

//		ArrayList<int[]> dis_table = new ArrayList<int[]>();
		dis_cal();

		int cnt = 0;
		while (true) {
			System.out.println(cnt);
			if (cnt == arr.size()) {
				System.out.println("끝 ");
				break;
			}

			int x;
			int w;

			if (arr.get(cnt)[0] == 1) { // 1정책
				x = arr.get(cnt)[1] - 1;
				w = arr.get(cnt)[2];

				int max = 0;
				int y = 0;

				for (int i = 0; i < dis_table.get(x).size(); i++) {
					if (max < dis_table.get(x).get(i)) {
						max = dis_table.get(x).get(i);
						y = i;
					}
				}

				n++;
//				distance.add(w);
				dis_table.get(y).add(w);
//				dis_cal();
				dis_update(y);

			}
			if (arr.get(cnt)[0] == 2) { // 2정책
				x = arr.get(cnt)[1] - 1;
				w = arr.get(cnt)[2];

				n++;
				dis_table.get(x).add(w);
				dis_update(x);
			}
			if (arr.get(cnt)[0] == 3) { // 3정책
				x = arr.get(cnt)[1] - 1;

				int max = 0;
				int y = 0;

				for (int i = 0; i < dis_table.get(x).size(); i++) {
					if (max < dis_table.get(x).get(i)) {
						max = dis_table.get(x).get(i);
						y = i;
					}
				}

				for (int i = 0; i < dis_table.size(); i++) {
					dis_table.get(i).remove(n - 1);
				}
				for (int i = 0; i < dis_table.size(); i++) {
					System.out.println(dis_table.get(i));
				}
				n--;

			}
			if (arr.get(cnt)[0] == 4) { // 4정책
				x = arr.get(cnt)[1] - 1;

				int max = 0;
				int y = 0;

				for (int i = 0; i < dis_table.get(x).size(); i++) {
					if (max < dis_table.get(x).get(i)) {
						max = dis_table.get(x).get(i);
						y = i;
					}
				}

				System.out.println("max distance>" + max);

			}

			cnt++;
		}
	}

	static void dis_cal() {
//		dis_table.clear();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int k = 0; k < n; k++) {
				int dis = 0;
				if (i > k) { // 한바퀴 돌아야함
					for (int d = i; d < n; d++) {
						dis += distance.get(d);
					}
					for (int d = 0; d < k; d++) {
						dis += distance.get(d);
					}
				} else {
					for (int d = i; d < k; d++) {
						dis += distance.get(d);
					}
				}

				temp.add(dis);
			}
			dis_table.add(temp);
		}

		for (int i = 0; i < dis_table.size(); i++) {
			System.out.println(dis_table.get(i));
		}
	}

	static void dis_update(int y) {
//		dis_table.clear();

		for (int i = 0; i < n - 1; i++) {
			if (i != y) {
				int dis = 0;
//				System.out.println(dis_table.get(i).get(n - 2));
//				System.out.println(dis_table.get(y).get(dis_table.get(y).size() - 1));
				dis = dis_table.get(i).get(y) + dis_table.get(y).get(dis_table.get(y).size() - 1);
				dis_table.get(i).add(dis);
			}
			
		}

		for (int i = 0; i < dis_table.size(); i++) {
			System.out.println(dis_table.get(i));
		}
	}

}
