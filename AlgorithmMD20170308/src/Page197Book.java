import java.util.Scanner;

/**
 * 창의적 알고리즘 중급 197쪽 책에 나와있는 코드 정리
 * 평형저울을 이용하여 1kg 이하의 물건의 무게를 재려고 한다. 
 * 준비되어 있는 추는 1g, 3g, 9g, 27g, 81g, 243g, 729g과 같이 7개의 추뿐이다.
 * 평형저울의 양쪽 접시에 물건과 추를 적절히 놓음으로써 물건의 무게를 잴 수 있는데,
 *  예를 들어, 25g의 물건을 재기 위해서는 다음과 같이 저울에 올려놓으면 된다.
 *  물건의 무게가 입력되었을 때 양쪽의 접시에 어떤 추들을 올려놓아야 평형을 이루는지를 결정하는 프로그램을 작성하시오.
 *  입력
 *  1. 물건의 무게를 나타내는 하나의 정수 n이 입력된다(1≤n≤1,000).
 *  2. n은 물건의 무게가 몇 그램인지를 나타낸다.
 *  출력
 *  1. 저울의 왼쪽 접시와 오른쪽 접시에 올린 추를 0으로 구분하여 출력한다.
 *  2. 각 접시에 올린 추들을 무게가 가벼운 추부터 하나의 공백으로 구분하여 출력한다.
 *  3. 물건의 무게를 왼쪽 접시의 처음에 표시한다.
 * @since jdk1.8
 * @author Genie
 */
public class Page197Book {
	/**
	 * sc: 사용자의 입력을 하기위한 Scanner 변수
	 * n: 물건의 무게를 나타내는 정수
	 * w: 물건의 무게를 잴 수 있는 추의 무게 리스트
	 * visit: 물건의 무게 추가 어떻게 쓰였는지 확인하는 리스트(0: 쓰이지 않음, 1: 왼쪽 접시에서 사용, 2: 오른쪽 접시에서 사용)
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, end;
	public static int[] scale = {1, 3, 9, 27, 81, 243, 729};
	public static int[] chk = new int[7];
	public static long time1;
	
	/**
	 * 메인 수행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		time1= System.currentTimeMillis ();
		System.out.print(n+" ");
		solve(n, 0);
		long time2 = System.currentTimeMillis ();
		System.out.println ("\n"+( time2 - time1 ) / 1000.0 );
	}
	
	public static void solve(int n, int sum) {
		if(end==1) {
			return;
		}
		if(sum==n) {
			for(int c=2; c>0; c--) {
				for(int i=0; i<7; i++) {
					if(chk[i]==c) {
						System.out.print(scale[i]+" ");
					}
				}
				if(c==2) {
					System.out.print("0 ");
				}
			}
			end = 1;
		}
		for(int i=0; i<7; i++) {
			if(chk[i]==0) {
				chk[i] = 1;
				solve(n, sum+scale[i]);
				chk[i] = 2;
				solve(n+scale[i], sum);
				chk[i] = 0;
			}
		}
	}
	
	/**
	 * 사용자의 입력을 받아 변수에 저장하는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
	}	
}
/*
입력예제
25
출력
25 3 0 1 27
입력예제
40
출력
40 0 1 3 9 27
*/