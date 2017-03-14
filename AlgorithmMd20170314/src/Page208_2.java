import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * å ���� ���� �� �ڵ� �ۼ�
 * �������� �����뿡 ����Ǵ� ��ġ�� ������ ���������� ���ʴ�� ��ȣ�� �Ű�����.
 * �������� ������ �����ٵ��� �� �����뿡 ����Ǵ� ��ġ�� ��ȣ�� �־��� ��, 
 * �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� ���־� �ϴ� �������� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�
 * ù° �ٿ��� �� ������ ������ �������� ������ �־�����. �������� ������ 100������ �ڿ����̴�.
 * ��° �ٺ��� �� �ٿ� �ϳ��� �������� A������� ����Ǵ� ��ġ�� ��ȣ�� B������� ����Ǵ� ��ġ�� ��ȣ�� ���ʷ� �־�����.
 * ��ġ�� ��ȣ�� 500 ������ �ڿ����̰�, ���� ��ġ�� �� �� �̻��� �������� ����� �� ����.
 * ���
 * ù° �ٿ� �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� ���־� �ϴ� �������� �ּ� ������ ����Ѵ�.
 * 
 * @since jdk1.8
 * @author Genie
 */
public class Page208_2 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static ArrayList<elec> list = new ArrayList<elec>();
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 * @param result
	 */
	public static void output(int result) {
		System.out.println(n-result);
	}
	
	/**
	 * ���� Ǫ�� �޼���
	 */
	public static void solve() {
		sort();
		output(maxSortLength());
	}
	
	/**
	 * ������ ���� ����� �ִ� ���� ��ȯ
	 * @return
	 */
	public static int maxSortLength() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int length = 0;
			for(int j=i+1; j<n; j++) {
				if(list.get(i).getRight()<list.get(j).getRight()) {
					length++;
				}
			}
			l.add(length);
		}
		Collections.sort(l);
		return l.get(l.size()-1);
	}
	
	/**
	 * left�������� �������� ����
	 * @param type
	 */
	public static void sort() {
		Collections.sort(list, new Comparator<elec>() {
			@Override
			public int compare(elec e1, elec e2) {
				return e1.getLeft() < e2.getLeft()? -1:e1.getLeft() > e2.getLeft()? 1:0;						
				
			}
		});
	}
	
	/**
	 * ������� �Է��� �����ϴ� �޼���
	 */
	public static void input() {
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			list.add(new elec(sc.nextInt(), sc.nextInt()));
		}
	}
}

/*class elec {
	private int left;
	private int right;
	private int inter;
	
	elec(int left, int right) {
		this.left = left;
		this.right = right;
		this.inter = 0;
	}
	
	public int getLeft() {
		return left;
	}
	
	public int getRight() {
		return right;
	}
	
	public int getInter() {
		return inter;
	}
	
	public void setInter(int inter) {
		this.inter = inter;
	}
	
	public String toString() {
		return "left: "+getLeft()+", right: "+getRight()+", inter: "+getInter();
	}
}*/
/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
���: 3

7
1 3
4 7
6 6
7 4
8 5
9 8
19 1
*/