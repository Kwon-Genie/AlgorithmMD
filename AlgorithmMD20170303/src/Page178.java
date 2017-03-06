import java.util.Scanner;

/**
 * 
 * @author Genie
 *
 */
public class Page178 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] nlist;
	public static int result;
	
	/**
	 * 실행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	/**
	 * 결과 값이 저장되어있는 result 출력 메서드
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * 연속된 합 중 가장 큰 합을 result에 저장하는 메서드
	 */
	public static void solve() {
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += nlist[j];
				if(sum > result) {
					result = sum;
				}
			}
		}
	}
	
	/**
	 * 사용자의 입력을 변수에 저장하는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
		nlist = new int[n];
		for(int i=0; i<n; i++) {
			nlist[i] = sc.nextInt();
		}
	}
}
/*
6
6 -7 3 -1 5 2
결과: 9
*/