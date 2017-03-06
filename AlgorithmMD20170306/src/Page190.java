import java.util.Scanner;

public class Page190 {
	public static Scanner sc = new Scanner(System.in);
	public static int B, n, result= 2147483647;
	public static int[] list;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(B, 0);
		output();
	}
	
	/**
	 * �ִ�� ������ ���� ���� �� ����� ����
	 * @param remain
	 */
	public static void solve(int remain, int pos) {
		remain -=list[pos];
		if(remain<list[0]) {
			if(remain>=0 && result>remain) {
				System.out.println(remain);
				result = remain;
			}
			return;
		}
		for(int i=pos+1; i<n; i++) {
			solve(remain, i);
		}
	}
	
	/**
	 * ������� �Է��� �޴� �޼���
	 */
	public static void input() {
		B = sc.nextInt();
		n = sc.nextInt();
		list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = sc.nextInt();
		}
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.println(B-result);
	}
}
/*
40
6
7 13 17 19 29 31
*/
