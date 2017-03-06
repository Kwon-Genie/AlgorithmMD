import java.util.Scanner;

/**
 * 
 * @author Genie
 *
 */
public class Page181 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, count;
	
	/**
	 * 수행 메인 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0);
		output();
	}
	
	/**
	 * result의 값이 n이 되거나 그 이상이 될때까지 반복하는 재귀 메서드
	 * @param result
	 */
	public static void solve(int result) {
		if(result==n) {
			count++;
			return;
		} else if(result>n) {
			return;
		}
		for(int i=1; i<3; i++) {
			solve(result+i);
		}
	}
 	
	/**
	 * 사용자의 입력을 받는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
	}
	
	/**
	 * 결과를 출력하는 메서드
	 */
	public static void output() {
		System.out.println(count);
	}
}
