import java.util.Scanner;
/**
 * 주어진 화단 둘레의 길이를 이용하여 삼각형 모양의 화단을 만들려고 한다. 이 때
 * 만들어진 삼각형 화단 둘레의 길이는 반드시 주어진 화단 둘레의 길이와 같아야 한다.
 * 또한, 화단 둘레의 길이와 각 변의 길이는 자연수이다. 예를 들어, 만들고자 하는
 * 화단 둘레의 길이가 9m라고 하면,
 * -한 변의 길이가 1m, 두 변의 길이가 4m인 화단
 * -한 변의 길이가 2m, 다른 변의 길이가 3m, 나머지 변의 길이가 4m인 화단
 * -세 변의 길이가 모두 3m인 3가지 경우의 화단을 만들 수 있다.
 * @since jdk1.8 
 * @author Genie
 *
 */
public class Page119 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][][] chk = new int[21][21][21];
	public static int cnt = 0;
	public static void main(String[] args) {
		int n = sc.nextInt();
		solve(n, 1, 1, 1);
		System.out.println(cnt);
	}
	
	/**
	 * 삼각형 각각의 변을 a, b, c로 두고
	 * 길이를 a<=b<=c를 만족하는 값들만 검색하여
	 * 삼각형의 조건을 만족하면 cnt를 해당 경우의 수만큼 증가시켜
	 * cnt를 반환한다.
	 * @return
	 */
	public static void solve(int n, int a, int b, int c) {
		if(a+b+c==n) {
			if(a<=b && b<=c && a+b>c && chk[a][b][c]==0) {
				cnt++;
				chk[a][b][c] = 1;
			}
			return;
		}
		solve(n, a+1, b, c);
		solve(n, a, b+1, c);
		solve(n, a, b, c+1);
	}
}
