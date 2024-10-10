package arang202410_study;

public class _1007Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_1017_2 s = new Solution_1017_2();

		int[] d = { 1, 99999, 100000, 99995 };
		int[] t = {9999, 9001, 9999, 9001};
		long l = 3456789012L;

		s.solution(d, t, l);
	}

}

//이분 탐색을 사용하면 시간 복잡도가 줄어듬 !!!!

//class Solution_1017_2 {
//	public int solution(int[] diffs, int[] times, long limit) {
//		int answer = 0;
//		int tp = 0;
//		int tc;
//		int level = 1;
//		long total_time = 0;
//
//		while (true) {
//
//			total_time = 0;
//
//			for (int i = 0; i < diffs.length; i++) {
//				tc = times[i];
//				if (diffs[i] <= level) {
//					total_time += tc;
//				} else {
//					for (int k = 0; k < diffs[i] - level; k++) {
//						total_time += tp + tc;
//					}
//					total_time += tc;
//				}
//
//				tp = times[i];
//				
////				System.out.println(total_time);
//			}
//
//			if (total_time <= limit) {
//				answer = level;
//				System.out.println("answer>" + answer);
//				break;
//			}
//
//			level++;
//
//		}
//
//		return answer;
//	}
//}

class Solution_1017_2 {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;  // 최소 숙련도는 1
        int right = getMaxDiff(diffs);  // 최대 난이도를 동적으로 설정
        int answer = right;

        // 이분 탐색을 통해 최소 숙련도 탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            long total_time = calculateTotalTime(diffs, times, mid);

            if (total_time <= limit) {
                answer = mid;  // 현재 숙련도로 제한 시간 내에 해결 가능하면 답을 갱신
                right = mid - 1;  // 더 낮은 숙련도로 가능한지 탐색
            } else {
                left = mid + 1;  // 현재 숙련도로는 해결 불가능하므로 숙련도를 높임
            }
        }
		System.out.println("answer>" + answer);

        return answer;
    }

    // 주어진 숙련도로 모든 퍼즐을 푸는 데 걸리는 시간을 계산하는 함수
    private long calculateTotalTime(int[] diffs, int[] times, int level) {
        long total_time = 0;
        int tp = 0;  // 이전 퍼즐의 시간

        for (int i = 0; i < diffs.length; i++) {
            int tc = times[i];
            if (diffs[i] <= level) {
                total_time += tc;
            } else {
                total_time += (long)(diffs[i] - level) * (tp + tc);  // 틀린 횟수만큼 추가 시간 계산
                total_time += tc;
            }
            tp = tc;

            // 계산 중간에 제한 시간을 넘기면 더 이상 계산할 필요 없음
            if (total_time > Long.MAX_VALUE) {
                return total_time;
            }
        }

        return total_time;
    }

    // 난이도 배열에서 최대 난이도를 찾는 함수
    private int getMaxDiff(int[] diffs) {
        int maxDiff = 0;
        for (int diff : diffs) {
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}