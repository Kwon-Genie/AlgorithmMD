import java.util.Scanner;

public class Page184 {
	/**
	 * m: 거슬러 줘야할 돈의 액수
	 * n: 동전의 종류 수
	 * nlist: 도전 액수 오름차순
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int m, n, result;
	public static int[] nlist;
	
	/**
	 * 수행 메인 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	/**
	 * 거스름돈을 주는 최소 동전 가짓수를 찾는 메서드
	 */
	public static void solve() {
		for(int i=nlist.length-1; i>=0; i--) {
			if(m==0) {
				return;
			}
			result += m/nlist[i];
			m = m%nlist[i];
		}
	}
	
	/**
	 * 결과를 출력하는 메서드
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * 사용자 입력을 받는 메서드
	 */
	public static void input() {
		m = sc.nextInt();
		n = sc.nextInt();
		nlist = new int[n];
		for(int i=0; i<n; i++) {
			nlist[i] = sc.nextInt();
		}
	}
}
/*
730
5
10 50 100 500 1250
*/