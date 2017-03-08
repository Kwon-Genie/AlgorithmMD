import java.util.Scanner;

/**
 * � �賶�� W���Ը�ŭ ������ ���� �� �ִ�.
 * ���ǵ��� (���� wi, ���� vi) ������ ������ �ִµ�, ���ǵ��� �����ؼ� ��� 
 * ������ ������ �ִ밡 �ǰ� �Ϸ��� �Ѵ�.
 * ���ǵ��� �� ������ �ۿ� ������, ���� �賶�� ���Ը� �ʰ��ؼ��� �� �ȴ�.
 * �Է�
 * ù° �ٿ� ������ ���� n(1<= n <= 100)�� �賶�� ���� w(1 <= w <= 10000)�� �Էµȴ�.
 * ��° �ٺ��� n+1°�� ���� ���ǵ��� ������ wi, vi�� �� �ٿ� �ϳ��� �Էµȴ�.(1 <= wi, vi <= 100)
 * ���
 * �賶�� ���� W�� �ʰ����� �����鼭 ������ ������ ������ �ִ��� ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page193 {
	/**
	 * sc: ������� �Է��� �޴µ� ���� Scanner ����
	 * n: ������ ����
	 * bw: �賶�� ����
	 * wi: ������ ���԰���
	 * vi: ������ ��ġ����
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, bw, result;
	public static int[] wi, vi;
	public static long time1;
	
	/**
	 * ���� ���� �޼���
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
	 * �賶�� ���Ը� �ʰ����� �����鼭 ������ ���� ������ �ִ��� ã�� �޼���
	 * @param vSum: ������ ���������� ����� �Ķ����
	 * @param wSum: ������ ���������� ����� �Ķ����
	 * @param pos: ���� ������ ��ġ
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
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.println(result);
	}
	
	/**
	 * ������� �Է��� �޾Ƽ� ������ ���� �����ϴ� �޼���
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
�Է� ����
4 5
2 3
1 2 
3 3
2 2
��
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
