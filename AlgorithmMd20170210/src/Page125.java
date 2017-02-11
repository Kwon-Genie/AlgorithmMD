import java.util.Scanner;
/**
 * 우리나라 최고의 어부 정올이가 이번에 네모네모 배 고기잡이 대회에 참가한다.
 * 이 대회에는 3개의 라운드가 있는데, 두 번째 라운드는 2차원 형태로 표현될 수
 * 있는 작은 연못에서 길쭉한 그물을 던져서 최대한 많은 고기를 잡는 것이 목적이다.
 * 1라운드의 예를 들면 연못의 크기가 1*6이고 물고기의 위치와 가치가 다음과 같다
 * 고 하자.
 * 1 0 2 0 4 3
 * 여기서 그물의 크기는 1*3이라고 할 때, 잡을 수 있는 방법은 (1 0 2), (0 2 0)
 * , (2 0 4), (0 4 3)의 4가지 방법이 있다.
 * 이 중 가장 이득을 보는 방법은 마지막 방법 0 + 4 + 3 = 7이다. 따라서 주어진
 * 경우의 최대 이득은 7이 된다. 정올이는 최대한 가치가 큰 물고기를 잡아서 우승하
 * 고 싶어 한다.
 * 연못의 폭과 각 칸에 있는 물고기의 가치, 그물의 가로의 길이가 주어질 때, 잡을
 * 수 있는 물고기의 최대이득을 구하는 프로그램을 작성하시오.
 * 입력
 * 첫 번째 줄에 연못의 폭 N, M이 입력된다. ( N, M <= 100 인 자연수 )
 * 두 번째 줄에 그물의 폭 W, H가 입력된다. ( W <= N, H <= M 인 자연수 )
 * 세 번째 줄에 N*M개의 물고기의 가치가 공백으로 구분되어 주어진다. 각 물고기
 * 의 가치는 7 이하의 자연수이다. 0일 경우에는 물고기가 없다는 의미이다.
 * 출력
 * 잡을 수 있는 물고기의 최대 가치를 출력한다.
 * @since jdk1.8
 * @author Genie
 */
public class Page125 {
	/**
	 * sc: 사용자의 입력을 받는데 사용될 변수
	 * n: 연못의 폭 n <=100
	 * m: 연못의 폭 m
	 * w: 그물의 폭 w <= n
	 * h: 그물의 폭 h 
	 * worth: 물고기의 가치
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, m, w, h;
	public static int[][] worth;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		w = sc.nextInt();
		worth = new int[n][m];
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++)
				worth[i][j] = sc.nextInt();
		System.out.println(solve());		
	}
	
	/**
	 * 그물을 던질 때 가장 물고기가 많은 양을 찾아 반환하는 메서드
	 * @return
	 */
	public static int solve() {
		int result = 0;
		for(int i=0; i<n-h+1; i++)
			for(int j=0; j<m-w+1; j++) {
				int sum = 0;
				for(int a=0; a<h; a++)
					for(int b=0; b<w; b++)
						sum += worth[i+a][j+b];
				if(sum>result)
					result = sum;
			}
		return result;
	}
}
