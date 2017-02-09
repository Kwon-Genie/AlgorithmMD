import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Page108에 있는 문제1
 * 한 정수 n을 입력받아서 n의 모든 약수의 합을 구하는 프로그램을 작성하시오
 * @author Genie
 *
 */
public class Page108 {
	/**
	 * sc 사용자의 입력을 받을 수 있는 전역변수
	 * n 사용자에게 입력받는 정수 값을 저장할 전역변수
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		System.out.println(solve());
	}
	
	/**
	 * 약수를 찾는 메서드
	 * 
	 * i를 1부터 n까지 반복하며
	 * n이 i로 완전히 나누어 떨어지면 i는 n의 약수이므로
	 * sum변수에 해당 i의 값을 더한다.
	 * @return
	 */
	public static int solve() {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(n%i==0)
				sum += i;
		}
		return sum;
	}
}
