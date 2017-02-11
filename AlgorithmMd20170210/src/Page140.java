import java.util.Scanner;

/**
 * 컴퓨터실에서 수업 중인 정보 선생님은 냉난방기의 온도를 조절하려고 한다.
 * 냉난방기가 멀리 있어서 리모컨으로 조작하려고 하는데, 리모컨의 온도 조절 버튼
 * 은 다음과 같다.
 * 1) 온도를 1도 올리는 버튼
 * 2) 온도를 1도 내리는 버튼
 * 3) 온도를 5도 올리는 버튼
 * 4) 온도를 5도 내리는 버튼
 * 5) 온도를 10도 올리는 버튼
 * 6) 온도를 10도 내리는 버튼
 * 이와 같이 총 6개의 버튼으로 목표 온도를 조절해야 한다.
 * 현재 설정 온도와 변경하고자 하는 목표 온도가 주어지면 이 버튼들을 이용하여
 * 목표 온도로 변경하고자 한다.
 * 이 때 버튼 누름의 최소 횟수를 구하시오. 예를 들어, 7도에서 34도로 변경하는 경우,
 * 7 → 17 → 27 → 32 → 33 → 34
 * 이렇게 총 5번 누르면 된다.
 * 입력
 * 현재 온도 a와 목표 온도 b가 입력된다(0 <= a, b <= 40).
 * 출력
 * 최소한의 버튼 사용으로 목표 온도가 되는 버튼 누름의 횟수를 출력한다.
 * 
 * @since jdk1.8 
 * @author Genie
 */
public class Page140 {
	public static Scanner sc = new Scanner(System.in);
	public static int result  = 40;
	public static int a, b;
	
	public static void main(String[] args) {
		a = sc.nextInt();
		b = sc.nextInt();
		temp(a, 0);
		System.out.println(result);
	}
	
	/**
	 * 목표 온도까지의 최소횟수를 찾는 DFS 메서드
	 * @param temp
	 * @param cnt
	 */
	public static void temp(int temp, int cnt) {
		if(cnt>result)
			return;
		if(temp==b && cnt<result) {
			result = cnt;
			return;
		}
		temp(temp+1, cnt+1);
		temp(temp+5, cnt+1);
		temp(temp+10, cnt+1);
		temp(temp-1, cnt+1);
		temp(temp-5, cnt+1);
		temp(temp-10, cnt+1);
	}
}
