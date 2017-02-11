import java.util.Scanner;
/**
 * ������ �ٵ��ǿ� ���� �ٵϾ˰� �� �ٵϾ��� ����� ���Ƽ� �ܷ�� �����̴�. ��
 * ���ǿ��� ����, ���� 19���� ������ �̷���� �ִ�.
 * �ٵϾ��� ���������� �ټ� ���� ���̸�
 * �� ���� �̱�� �ȴ�. ���⼭ �������̶� ����, ���� �Ǵ� �밢�� ���� ��θ� ���Ѵ�.
 * ��, ���� �׸��� �������� �̱� ����̴�. ������ ���� �� �̻��� ���������� ����
 * ��쿡�� �̱� ���� �ƴϴ�. �Է����� �ٵ����� � ���°� �־����� ��, ��������
 * �̰����, ����� �̰���� �Ǵ� ���� �ºΰ� �������� �ʾҴ����� �Ǵ��ϴ� ���α�
 * ���� �ۼ��Ͻÿ�.
 * ��, �������� ����� ���ÿ� �̱�ų� ������ �Ǵ� ����� �� ���� �̻󿡼� ����
 * �� �̱�� ���� �Է����� ������ �ʴ´�.
 * �Է�
 * �Է� ������ 19�ٿ� �� �ٸ��� 19���� ���ڷ� ǥ���Ǵµ�, ���� �ٵϾ��� 1, �� ��
 * �Ͼ��� 2, ���� ������ ���� �ڸ��� 0���� ǥ�õǸ�, ���ڴ� �� ĭ�� �� ǥ�õȴ�.
 * ���
 * ù ��° �ٿ� �������� �̰��� ��쿡�� 1��, ����� �̰��� ��쿡�� 2��, ����
 * �ºΰ� �������� �ʾ��� ��쿡�� 0�� ����Ѵ�. ������ �Ǵ� ����� �̰��� ��쿡
 * �� ��° �ٿ� ���ӵ� �ټ� ���� �ٵϾ� �߿��� ���� ���ʿ� �ִ� �ٵϾ�(���ӵ� ��
 * �� ���� �ٵϾ��� ���η� ���� ���, ���� ���� ���� �ִ� ��)�� ������ ��ȣ�� ����
 * �� ��ȣ�� ������� ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page128 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] board = new int[19][19];
	public static int row, col, result;
	public static void main(String[] args) {
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		if(search(1)) 
			output(1);
		else if(search(2))
			output(2);
		else
			output(0);
	}
	
	/**
	 * �ش� type�� ������ �̰���� �ƴ��� ã�� �޼���
	 * @param type
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean search(int type) {
		for(int j=0; j<19; j++) 
			for(int i=0; i<19; i++) 
				if(board[i][j]==type)
					if(check(type, i, j)) {
						row = i+1;
						col = j+1;
						return true;
					}
		return false;
	}
	
	public static boolean check(int type, int i, int j) {
		if(safe(i, j+4)) 
			for(int c=j; c<j+5; c++)
				if(board[i][c]!=type)
					return false;
		else if(safe(i+4, j)) 
			for(int r=i; r<i+5; r++) 
				if(board[r][j]!=type)
					return false;
		else if(safe(i+4, j+4))
			for(r=i, c=j; r<i+5 && c<j+5; r++,c++)
				if(board[r][c]!=type)
					return false;
		else if(safe (i-4, j+4))
			for(r=i, c=j; r>i-5 && c<j+5; r--,c++)
				if(board[r][c]!=type)
					return false;
		else
			return false;
		return true;
	}
	
	public static boolean safe(int i, int j) {
		return (0<=i && i<19) && (0<=j && j<19);
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 * @param type
	 */
	public static void output(int type) {
		System.out.println(type);
		if(type!=0)
			System.out.print(row+" "+col);
	}
}
