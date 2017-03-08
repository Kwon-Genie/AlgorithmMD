import java.util.Scanner;

/**
 * ���������� �̿��Ͽ� 1kg ������ ������ ���Ը� ����� �Ѵ�. 
 * �غ�Ǿ� �ִ� �ߴ� 1g, 3g, 9g, 27g, 81g, 243g, 729g�� ���� 7���� �߻��̴�.
 * ���������� ���� ���ÿ� ���ǰ� �߸� ������ �������ν� ������ ���Ը� �� �� �ִµ�,
 *  ���� ���, 25g�� ������ ��� ���ؼ��� ������ ���� ���￡ �÷������� �ȴ�.
 *  ������ ���԰� �ԷµǾ��� �� ������ ���ÿ� � �ߵ��� �÷����ƾ� ������ �̷������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *  �Է�
 *  1. ������ ���Ը� ��Ÿ���� �ϳ��� ���� n�� �Էµȴ�(1��n��1,000).
 *  2. n�� ������ ���԰� �� �׷������� ��Ÿ����.
 *  ���
 *  1. ������ ���� ���ÿ� ������ ���ÿ� �ø� �߸� 0���� �����Ͽ� ����Ѵ�.
 *  2. �� ���ÿ� �ø� �ߵ��� ���԰� ������ �ߺ��� �ϳ��� �������� �����Ͽ� ����Ѵ�.
 *  3. ������ ���Ը� ���� ������ ó���� ǥ���Ѵ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page197 {
	/**
	 * sc: ������� �Է��� �ϱ����� Scanner ����
	 * n: ������ ���Ը� ��Ÿ���� ����
	 * w: ������ ���Ը� �� �� �ִ� ���� ���� ����Ʈ
	 * visit: ������ ���� �߰� ��� �������� Ȯ���ϴ� ����Ʈ(0: ������ ����, 1: ���� ���ÿ��� ���, 2: ������ ���ÿ��� ���)
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] w = {1, 3, 9, 27, 81, 243, 729};
	public static int[] visit = new int[7];
	public static long time1;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		time1= System.currentTimeMillis (); 
		solve(n, 0, 0);
	}
	
	public static void solve(int left, int right, int pos) {
		if(left==right) {
			output();
			System.exit(0);
		} else if(pos==7) {
			return;
		}
		visit[pos] = 1;
		solve(left+w[pos], right, pos+1);
		visit[pos] = 2;
		solve(left, right+w[pos], pos+1);
		visit[pos] = 0;
		solve(left, right, pos+1);
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.print(n+" ");
		for(int i=0; i<visit.length; i++) {
			if(visit[i]==1) {
				System.out.print(w[i]+" ");
			}
		}
		System.out.print("0 ");
		for(int i=0; i<visit.length; i++) {
			if(visit[i]==2) {
				System.out.print(w[i]+" ");
			}
		}
		long time2 = System.currentTimeMillis ();
		System.out.println ("\n"+( time2 - time1 ) / 1000.0 );
	}
	
	/**
	 * ������� �Է��� �޾� ������ �����ϴ� �޼���
	 */
	public static void input() {
		n = sc.nextInt();
	}	
}
/*
�Է¿���
25
���
25 3 0 1 27
�Է¿���
40
���
40 0 1 3 9 27
*/