import java.util.Scanner;

/**
 * 창의적 알고리즘 201쪽 격자 문제
 * @since jdk1.8
 * @author Genie
 */
public class Page201 {
	public static Scanner sc = new Scanner(System.in);
	public static int H, W, count;
	
	/**
	 * 메인 수행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0, 0);
		output();
	}
	
	/**
	 * h,w까지 가는 경로를 찾을 떄마다 가는 길의 수를 증가시키는 메서드
	 * @param h
	 * @param w
	 */
	public static void solve(int h, int w) {
		if(h>H || w>W) {
			return;
		} else if(h==H && w==W) {
			count++;
			return;
		}
		solve(h+1, w);
		if((double)H/W <= (double)h/(w+1)) {
			solve(h, w+1);
		}
	}
	
	/**
	 * 사용자 입력 메서드 
	 */
	public static void input() {
		H = sc.nextInt();
		W = sc.nextInt();		
	}
	
	/**
	 * 결과 출력 메서드
	 */
	public static void output() {
		System.out.println(count);
	}
}
