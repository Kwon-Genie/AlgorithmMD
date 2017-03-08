import java.util.Scanner;

/**
 * â���� �˰��� �߱� 197�� å�� �����ִ� �ڵ� ����
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
public class Page197Book {
	/**
	 * sc: ������� �Է��� �ϱ����� Scanner ����
	 * n: ������ ���Ը� ��Ÿ���� ����
	 * w: ������ ���Ը� �� �� �ִ� ���� ���� ����Ʈ
	 * visit: ������ ���� �߰� ��� �������� Ȯ���ϴ� ����Ʈ(0: ������ ����, 1: ���� ���ÿ��� ���, 2: ������ ���ÿ��� ���)
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, end;
	public static int[] scale = {1, 3, 9, 27, 81, 243, 729};
	public static int[] chk = new int[7];
	public static long time1;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		time1= System.currentTimeMillis ();
		System.out.print(n+" ");
		solve(n, 0);
		long time2 = System.currentTimeMillis ();
		System.out.println ("\n"+( time2 - time1 ) / 1000.0 );
	}
	
	public static void solve(int n, int sum) {
		if(end==1) {
			return;
		}
		if(sum==n) {
			for(int c=2; c>0; c--) {
				for(int i=0; i<7; i++) {
					if(chk[i]==c) {
						System.out.print(scale[i]+" ");
					}
				}
				if(c==2) {
					System.out.print("0 ");
				}
			}
			end = 1;
		}
		for(int i=0; i<7; i++) {
			if(chk[i]==0) {
				chk[i] = 1;
				solve(n, sum+scale[i]);
				chk[i] = 2;
				solve(n+scale[i], sum);
				chk[i] = 0;
			}
		}
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