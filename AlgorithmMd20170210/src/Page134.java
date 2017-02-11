import java.util.Scanner;

/**
 * 정올이는 GSHS에서 연구활동 교수님을 뵈러 A대학교를 가려고 한다. 출발점과 도
 * 착점을 포함하여 경유하는 지역 n개, 한 지역에서 다른 지역으로 가는 방법이 총 m
 * 개이며 GSHS는 지역 1이고 A대학교는 지역 n이라고 할 때 대학까지 최소 비용을
 * 구하시오.
 * 단, n은 10 이하, m은 30 이하, 그리고 한 지역에서 다른 지역으로 가는 데에 필
 * 요한 비용은 모두 200 이하 양의 정수이며 한 지역에서 다른 지역으로 가는 어떠한
 * 방법이 존재하면 같은 방법과 비용을 통해 역방향으로 갈 수 있다.
 * 다음 그래프는 예를 보여준다.(단, 정점a->정점b로의 간선이 여러 개 있을 수 있으
 * 며, 자기 자신으로 가는 정점을 가질 수도 있다.)
 * 입력
 * 첫 번째 줄에는 정점의 수 n과 간선의 수 m이 공백으로 구분되어 입력된다. 다음
 * 줄부터 m개의 줄에 걸쳐서 두 정점의 번호와 가중치가 입력된다. (자기 간선, 멀티
 * 간선이 있을 수 있다.)
 * 출력
 * 대학까지 가는 데 드는 최소 비용을 출력한다. 만약 갈 수 없다면 “-1”을 출력.
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page134 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, m, sol = 0x7fffffff;
	public static int[] chk = new int[11];
	public static int[][] g = new int[11][11];
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int s, e, w;
			s = sc.nextInt();
			e = sc.nextInt();
			w = sc.nextInt();
			g[s][e] = g[e][s] = w;
		}
		solve(1,0);
		System.out.println(sol==0x7fffffff?-1:sol);
	}
	
	/**
	 * 경로 찾아서 찾은 경로의 가중치가 이전에 찾은 가중치보다 작은 경우
	 * sol에 경로 가중치를 넣어주는 메서드
	 * @param v
	 * @param w
	 */
	public static void solve(int v, int w) {
		if(v==n) {
			if(w<sol)
				sol = w;
			return;
		}
		for(int i=1; i<=n; i++) {
			if(chk[i]!=1 && g[v][i]!=0) {
				chk[i] = 1;
				solve(i, w+g[v][i]);
				chk[i] = 0;
			}
		}
	}
}
