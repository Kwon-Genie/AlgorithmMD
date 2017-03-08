import java.util.Scanner;

/**
 * 창의적 알고리즘 중급 190쪽 책에 나와있는 코드 정리
 * 백트래킹에 의한 전체 탐색법 연습문제
 * 
 * 정보 선생님은 예산이 많은 부서에서 일하고 있다. 학기말이 가까워지면서 부서의
 * 예산을 가급적 모두 집행해야 될 상황이 되었다.
 * 정보 선생님은 예산 범위를 넘지 않는 선에서 다양한 활동을 하고 싶어 한다.
 * 입력
 * 첫째 줄에 남은 예산(B)이 입력된다. ( 10 <= B <= 35,000 )
 * 둘째 줄에 예산을 사용할 수 있는 활동의 수(n)가 입력된다. (1 <= n <= 21 )
 * 셋째 줄에 공백을 기준으로 n개의 활동비가 양의 정수로 입력된다.
 * 출력
 * 남은 예산을 초과하지 않으면서 최대로 사용할 수 있는 비용액을 출력한다.
 * @since jdk1.8
 * @author Genie
 */
public class Page190Book {
	public static Scanner sc = new Scanner(System.in);
	public static int B, n, res;
	public static int[] act = new int[23];
	
	/**
	 * 백트레킹을 해서 답을 찾기위한 전체탐색 메서드
	 * @param i: 현재 위치
	 * @param sum: 더한 값
	 */
	public static void function(int i, int sum) {
		if(i==n+1) {
			if(sum<=B && sum>res) {
				res = sum;
				return;
			}
		}
		function(i+1, sum+act[i]);
		function(i, sum);
	}
	
	/**
	 * 메인 수행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		B = sc.nextInt();
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			act[i] = sc.nextInt();
		}
		function(1,0);
		System.out.println(res);
	}
}
