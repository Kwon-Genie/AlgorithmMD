import java.util.Scanner;
/**
 * ���� 9��9 �����ǿ� ������ 81���� �ڿ����� �־��� ��, �̵� �� �ִ��� ã��
 * �� �ִ��� �� �� �� ���� ��ġ�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page110 {
	/**
	 * sc: ������� �Է��� �޴µ� ���Ǵ� ����
	 * board: ������� �Է��� �޾� �����ϴ� ���� �迭 ũ��� 9X9�̴�.
	 * row: �ִ��� ���� �����ϴ� ����
	 * col: �ִ��� ���� �����ϴ� ����
	 * max: �ִ��� �����ϴ� ����
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int[][] board = new int[9][9];
	public static int row, col, max;
	public static void main(String[] args) {
		input();
		solve();
		printAnswer();
	}
	
	/**
	 * ������� ����ϴ� �޼���
	 */
	public static void printAnswer() {
		System.out.println(max);
		System.out.println(row + " " + col);
	}
	
	/**
	 * board ���߹迭���� �ִ��� ã�� �޼���
	 */
	public static void solve() {
		for(int i=0; i<9; i++) 
			for(int j=0; j<9; j++)
				if(board[i][j]>max) {
					max = board[i][j];
					row = i+1;
					col = j+1;
				}
	}
	
	/**
	 * ����ڷκ��� 9X9����� ������ �޾Ƽ� �����ϴ� �޼���
	 */
	public static void input() {
		for(int i=0; i<9; i++) 
			for(int j=0; j<9; j++) 
				board[i][j] = sc.nextInt();
	}
}
