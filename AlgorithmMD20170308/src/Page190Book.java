import java.util.Scanner;

/**
 * â���� �˰��� �߱� 190�� å�� �����ִ� �ڵ� ����
 * ��Ʈ��ŷ�� ���� ��ü Ž���� ��������
 * 
 * ���� �������� ������ ���� �μ����� ���ϰ� �ִ�. �б⸻�� ��������鼭 �μ���
 * ������ ������ ��� �����ؾ� �� ��Ȳ�� �Ǿ���.
 * ���� �������� ���� ������ ���� �ʴ� ������ �پ��� Ȱ���� �ϰ� �;� �Ѵ�.
 * �Է�
 * ù° �ٿ� ���� ����(B)�� �Էµȴ�. ( 10 <= B <= 35,000 )
 * ��° �ٿ� ������ ����� �� �ִ� Ȱ���� ��(n)�� �Էµȴ�. (1 <= n <= 21 )
 * ��° �ٿ� ������ �������� n���� Ȱ���� ���� ������ �Էµȴ�.
 * ���
 * ���� ������ �ʰ����� �����鼭 �ִ�� ����� �� �ִ� ������ ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page190Book {
	public static Scanner sc = new Scanner(System.in);
	public static int B, n, res;
	public static int[] act = new int[23];
	
	/**
	 * ��Ʈ��ŷ�� �ؼ� ���� ã������ ��üŽ�� �޼���
	 * @param i: ���� ��ġ
	 * @param sum: ���� ��
	 */
	public static void function(int i, int sum) {
		if(i==n+1) {
			if(sum<=B && sum>res) {
				res = sum;
				return;
			}
		}
		function(i+1, sum+act[i]);
		function(i, sum);
	}
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		B = sc.nextInt();
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			act[i] = sc.nextInt();
		}
		function(1,0);
		System.out.println(res);
	}
}
