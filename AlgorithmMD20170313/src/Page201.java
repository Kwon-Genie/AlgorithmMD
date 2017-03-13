import java.util.Scanner;

/**
 * â���� �˰��� 201�� ���� ����
 * @since jdk1.8
 * @author Genie
 */
public class Page201 {
	public static Scanner sc = new Scanner(System.in);
	public static int H, W, count;
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0, 0);
		output();
	}
	
	/**
	 * h,w���� ���� ��θ� ã�� ������ ���� ���� ���� ������Ű�� �޼���
	 * @param h
	 * @param w
	 */
	public static void solve(int h, int w) {
		if(h>H || w>W) {
			return;
		} else if(h==H && w==W) {
			count++;
			return;
		}
		solve(h+1, w);
		if((double)H/W <= (double)h/(w+1)) {
			solve(h, w+1);
		}
	}
	
	/**
	 * ����� �Է� �޼��� 
	 */
	public static void input() {
		H = sc.nextInt();
		W = sc.nextInt();		
	}
	
	/**
	 * ��� ��� �޼���
	 */
	public static void output() {
		System.out.println(count);
	}
}
