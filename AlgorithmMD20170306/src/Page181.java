import java.util.Scanner;

/**
 * 
 * @author Genie
 *
 */
public class Page181 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, count;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0);
		output();
	}
	
	/**
	 * result�� ���� n�� �ǰų� �� �̻��� �ɶ����� �ݺ��ϴ� ��� �޼���
	 * @param result
	 */
	public static void solve(int result) {
		if(result==n) {
			count++;
			return;
		} else if(result>n) {
			return;
		}
		for(int i=1; i<3; i++) {
			solve(result+i);
		}
	}
 	
	/**
	 * ������� �Է��� �޴� �޼���
	 */
	public static void input() {
		n = sc.nextInt();
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.println(count);
	}
}
