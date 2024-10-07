package arang202408;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class _0813Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;

//		String[] arr = {"A B C D","A D","A B D","B D"};
//		int k = 2;
		
		String[] arr = {"J","J E J M","M E M","E M","E E E","M"};
		int k = 3;
		
		HashMap<String, Integer> id = new HashMap<String, Integer>();
		
		
		for (int i = 0; i < arr.length; i++) {	//날짜 별 
			HashMap<String, Integer> check = new HashMap<String, Integer>();
			String[] temp = arr[i].split(" ");
			for (int m = 0; m < temp.length; m++) {
				if (check.containsKey(temp[m])) {	//이미 하루에 쿠폰을 받은 고객 
//					System.out.println("이미 쿠폰을 받으셨습니다.");
					
				}
				else {
					check.put(temp[m], 1);
//					System.out.println(i+" " +check.entrySet());
					if (id.containsKey(temp[m])) {
						int value = id.get(temp[m]);
						if (value < k) {
							value++;
							id.replace(temp[m], id.get(temp[m]), value);
//							System.out.println("+++++"+id.entrySet());

						}
						else {
							id.replace(temp[m], id.get(temp[m]), value);
//							System.out.println(id.entrySet());

						}
						
					}
					else {
						id.put(temp[m], 1);
//						System.out.println(id.entrySet());

					}
				}
				
			}
		}
		
		System.out.println(id.entrySet());
		
		
		Collection<Integer> value = id.values();
		
		Iterator<Integer> iterator = value.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next(); // 다음 값을 가져옴
            result += temp; // 값을 합산
        }
        
        System.out.println("result>>>>>"+result);
	}

}
