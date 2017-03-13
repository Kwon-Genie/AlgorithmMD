import java.util.Scanner;

/**
 * 창의적 알고리즘 P204 문제
 * @since jdk1.8
 * @author Genie
 */
public class Page204 {
	/**
	 * sc: 사용자의 입력을 위한 변수
	 * d: 길동 선물의 부피 합 - 길삼 선물의 부피 합
	 * g1: 길동 선물 부피 합
	 * g2: 길순 선물 부피 합
	 * g3: 길삼 선물 부피 합
	 * W: 전체 선물 부피 합
	 * w: 선물 부피 리스트
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int G1, G2, G3, n, d = Integer.MAX_VALUE;
	public static int[] w;
	
	/**
	 * 메인 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0, 0, 0, 0);
		output();
	}
	
	/**
	 * 문제가 제시하는 룰을 만족하는 여부를 반환하는 메서드
	 * @param g1
	 * @param g2
	 * @param g3
	 * @return
	 */
	public static boolean isRightRule(int g1, int g2, int g3) {
		return (g1>=g2)&&(g2>=g3)?true:false;
	}
	
	/**
	 * 조건을 만족하는 결과값을 찾는 메서드
	 * @param g1
	 * @param g2
	 * @param g3
	 * @param pos
	 */
	public static void solve(int g1, int g2, int g3, int pos) {
		if(pos==n) {
			if(isRightRule(g1,g2,g3)) {
				if(d>g1-g3) {
					d = g1-g3;
					G1 = g1;
					G2 = g2;
					G3 = g3;
				}
			}
			return;
		}
		solve(g1+w[pos], g2, g3, pos+1);
		solve(g1, g2+w[pos], g3, pos+1);
		solve(g1, g2, g3+w[pos], pos+1);
	}
	
	/**
	 * 결과를 출력하는 메서드
	 */
	public static void output() {
		System.out.println(G1+" "+G2+" "+G3);
	}
	
	/**
	 * 사용자의 입력을 받는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
		w = new int[n];
		for(int i=0; i<n; i++) {
			w[i] = sc.nextInt();
		}
	}
}
