import java.util.Scanner;

/**
 * 
 * @author Genie
 *
 */
public class Page178 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] nlist;
	public static int result;
	
	/**
	 * ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	/**
	 * ��� ���� ����Ǿ��ִ� result ��� �޼���
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * ���ӵ� �� �� ���� ū ���� result�� �����ϴ� �޼���
	 */
	public static void solve() {
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += nlist[j];
				if(sum > result) {
					result = sum;
				}
			}
		}
	}
	
	/**
	 * ������� �Է��� ������ �����ϴ� �޼���
	 */
	public static void input() {
		n = sc.nextInt();
		nlist = new int[n];
		for(int i=0; i<n; i++) {
			nlist[i] = sc.nextInt();
		}
	}
}
/*
6
6 -7 3 -1 5 2
���: 9
*/