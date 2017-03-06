import java.util.Scanner;

public class Page184 {
	/**
	 * m: �Ž��� ����� ���� �׼�
	 * n: ������ ���� ��
	 * nlist: ���� �׼� ��������
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int m, n, result;
	public static int[] nlist;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	/**
	 * �Ž������� �ִ� �ּ� ���� �������� ã�� �޼���
	 */
	public static void solve() {
		for(int i=nlist.length-1; i>=0; i--) {
			if(m==0) {
				return;
			}
			result += m/nlist[i];
			m = m%nlist[i];
		}
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * ����� �Է��� �޴� �޼���
	 */
	public static void input() {
		m = sc.nextInt();
		n = sc.nextInt();
		nlist = new int[n];
		for(int i=0; i<n; i++) {
			nlist[i] = sc.nextInt();
		}
	}
}
/*
730
5
10 50 100 500 1250
*/