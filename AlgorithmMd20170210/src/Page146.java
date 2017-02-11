import java.util.Scanner;

/**
 * 수학자들에게 소수란 매우 흥미 있는 연구 주제이다. 소수(prime number)란 약수
 * 가 1과 자기 자신밖에 없는 1보다 큰 자연수를 말한다. 수학자들은 소수를 연구하면
 * 서 특이한 소수들을 발견하여 이름을 명명하였다. 메르센 소수, 페르마 소수, 쌍둥이
 * 소수 등이 그 예이다.
 * 우리에게는 생소하지만 오른편 절단 가능 소수가 있다. 이 소수는 오른쪽부터 하
 * 나씩 제거해도 계속 소수가 되는 소수이다.
 * 크기가 네 자리인 7193을 예로 들어보자. 7193은 소수이고, 7193의 오른편 숫자 3
 * 을 제거하여 남은 719도 소수이다. 719의 오른편 숫자 9를 제거하여 남은 71도 소수
 * 이다. 71의 오른편 숫자 1을 제거하여 남은 7도 소수이다. 따라서 7193은 오른편 절
 * 단 가능 소수이다.
 * 입력
 * 자릿수 n이 정수로 입력된다.(1 <= n <= 10)
 * 출력
 * 1. n자리로 이루어진 오른편 절단 가능 소수들을 한 줄에 하나씩 오름차순으로 출
 * 력한다.
 * 2. 마지막 줄에 출력된 오른편 절단 가능 소수들의 개수를 출력한다.
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page146 {
	public static Scanner sc = new Scanner(System.in);
	public static int num;
	public static void main(String[] args) {
		num = sc.nextInt();
		solve();
	}
	
	/**
	 * n의 자리수 숫자들이 오른편 절단 가능 소수인경우의 수와 
	 * 소수들을 출력하는 메서드
	 */
	public static void solve() {
		int cnt = 0;
		for(int i=(int) Math.pow(10, num-1); i<Math.pow(10, num); i++) {
			if(isPrime(i)) {
				cnt++;
				System.out.println(i);
			}	
		}
		System.out.println(cnt);
	}	
	
	/**
	 * 해당 수 n이 오른편 절단 가능 소수인지 확인하는 메서드
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		while (n > 1) {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
			n = n/10;
		}
		if(n==1)
			return false;
		return true;
	}
}
