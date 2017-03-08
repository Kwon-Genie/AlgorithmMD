import java.util.Scanner;

/**
 * 어떤 배낭에 W무게만큼 물건을 담을 수 있다.
 * 물건들은 (무게 wi, 가격 vi) 정보를 가지고 있는데, 물건들을 조합해서 담아 
 * 가격의 총합이 최대가 되게 하려고 한다.
 * 물건들은 한 종류씩 밖에 없으며, 절대 배낭의 무게를 초과해서는 안 된다.
 * 입력
 * 첫째 줄에 물건의 개수 n(1<= n <= 100)과 배낭의 무게 w(1 <= w <= 10000)가 입력된다.
 * 둘째 줄부터 n+1째줄 까지 물건들의 정보가 wi, vi가 한 줄에 하나씩 입력된다.(1 <= wi, vi <= 100)
 * 출력
 * 배낭의 무게 W를 초과하지 않으면서 물건의 가격의 총합의 최댓값을 출력한다.
 * @since jdk1.8
 * @author Genie
 */
public class Page193 {
	/**
	 * sc: 사용자의 입력을 받는데 사용될 Scanner 변수
	 * n: 물건의 갯수
	 * bw: 배낭의 무게
	 * wi: 물건의 무게값들
	 * vi: 물건의 가치값들
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, bw, result;
	public static int[] wi, vi;
	public static long time1;
	
	/**
	 * 메인 수행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		time1 = System.currentTimeMillis();
		solve(0, 0, 0);
		output();
		long time2 = System.currentTimeMillis();
		System.out.println((time2-time1)/1000.0);
	}
	
	/**
	 * 배낭의 무게를 초과하지 않으면서 물건의 가격 총합의 최댓값을 찾는 메서드
	 * @param vSum: 이전의 가격정보가 저장된 파라미터
	 * @param wSum: 이전의 무게정보가 저장된 파라미터
	 * @param pos: 현재 봐야할 위치
	 */
	public static void solve(int vSum, int wSum, int pos) {
		if(pos==n || wSum>=bw) {
			if(vSum>result && wSum<=bw) {
				result = vSum;
			}
			return;
		}
		solve(vSum+vi[pos], wSum+wi[pos], pos+1);
		solve(vSum, wSum, pos+1);
	}
	
	/**
	 * 결과를 출력하는 메서드
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * 사용자의 입력을 받아서 변수에 값을 저장하는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
		bw = sc.nextInt();
		wi = new int[n];
		vi = new int[n];
		for(int i=0; i<n; i++) {
			wi[i] = sc.nextInt();
			vi[i] = sc.nextInt();
		}
	}
}
/*
입력 예제
4 5
2 3
1 2 
3 3
2 2
답
7

15 20
1 2 
3 4
2 5
1 6
2 4
3 2
3 1
7 2
5 3
5 2
5 1
9 1
1 9
2 5
3 6
44

26 17
1 2 
3 4
2 5
1 6
2 4
3 2
3 1
7 2
5 3
5 2
5 1
9 1
1 9
2 5
3 6
2 8
6 1
7 3
5 9
2 7
7 5
9 4
10 3
10 2
10 1
1 3
55
*/
