package arang202411;

public class _1128Q2 {
//	static int n = 3;
//	static int a = 12;	//도우 가격 
//	static int b = 2;	//토핑 가격 
//	static int c = 200;	//도우 칼로리 
//	static int[] arr = {50,300,100};	//토핑 칼로리
//	static int best = 0; //베스트피자칼로리
	
	static int n = 4;
	static int a = 20;	//도우 가격 
	static int b = 3;	//토핑 가격 
	static int c = 900;	//도우 칼로리 
	static int[] arr = {300,100,400,1300};	//토핑 칼로리
	static int best = 0; //베스트피자칼로리 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for (int i = 0; i < arr.length; i++) {
			int[] check = new int[arr.length];
			dfs(check, c, 0, i);
		}
		
		
	}
	
	static void dfs(int[] check, int total, int k, int i) {	//토핑체크, 총칼로리, 토핑개수, 토핑번호
		if (total / (a + k * b) > best) {
			best = total / (a + k * b);
			System.out.println("best pizza kcal>" + best);
		}
		if (i < 0 || i > arr.length - 1 || k > n || check[i] == 1) {
			return;
		}
		
		check[i] = 1;
		total += arr[i];
		
		dfs(check, total, k + 1, i - 1);
		dfs(check, total, k + 1, i + 1);
		
	}

}
