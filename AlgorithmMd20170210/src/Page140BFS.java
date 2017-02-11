import java.util.Scanner;
import java.util.ArrayList;

/**
 * ��ǻ�ͽǿ��� ���� ���� ���� �������� �ó������ �µ��� �����Ϸ��� �Ѵ�.
 * �ó���Ⱑ �ָ� �־ ���������� �����Ϸ��� �ϴµ�, �������� �µ� ���� ��ư
 * �� ������ ����.
 * 1) �µ��� 1�� �ø��� ��ư
 * 2) �µ��� 1�� ������ ��ư
 * 3) �µ��� 5�� �ø��� ��ư
 * 4) �µ��� 5�� ������ ��ư
 * 5) �µ��� 10�� �ø��� ��ư
 * 6) �µ��� 10�� ������ ��ư
 * �̿� ���� �� 6���� ��ư���� ��ǥ �µ��� �����ؾ� �Ѵ�.
 * ���� ���� �µ��� �����ϰ��� �ϴ� ��ǥ �µ��� �־����� �� ��ư���� �̿��Ͽ�
 * ��ǥ �µ��� �����ϰ��� �Ѵ�.
 * �� �� ��ư ������ �ּ� Ƚ���� ���Ͻÿ�. ���� ���, 7������ 34���� �����ϴ� ���,
 * 7 �� 17 �� 27 �� 32 �� 33 �� 34
 * �̷��� �� 5�� ������ �ȴ�.
 * �Է�
 * ���� �µ� a�� ��ǥ �µ� b�� �Էµȴ�(0 <= a, b <= 40).
 * ���
 * �ּ����� ��ư ������� ��ǥ �µ��� �Ǵ� ��ư ������ Ƚ���� ����Ѵ�.
 * 
 * @since jdk1.8 
 * @author Genie
 */
public class Page140BFS {
	public static Scanner sc = new Scanner(System.in);
	public static int result;
	public static int a, b;
	public static ArrayList<Temp> q = new ArrayList<Temp>();
	
	public static void main(String[] args) {
		a = sc.nextInt();
		b = sc.nextInt();
		temp(new Temp(a,0));
		System.out.println(result);
	}
	
	/**
	 * ��ǥ �µ������� �ּ�Ƚ���� ã��BFS �޼���
	 * @param temp
	 * @param cnt
	 */
	public static void temp(Temp t) {
		q.add(t);
		while(q.size()>0) {
			Temp curr = q.remove(0);
			if(curr.currTemp==b) {
				result = curr.cnt;
				return;
			}
			if(curr.currTemp>b) {
				q.add(new Temp(curr.currTemp-1, curr.cnt+1));
				q.add(new Temp(curr.currTemp-5, curr.cnt+1));
				q.add(new Temp(curr.currTemp-10, curr.cnt+1));
			} else {
				q.add(new Temp(curr.currTemp+1, curr.cnt+1));
				q.add(new Temp(curr.currTemp+5, curr.cnt+1));
				q.add(new Temp(curr.currTemp+10, curr.cnt+1));
			}
		}
	}
}

/**
 * BFS�� �ϱ����� q�� �ִ� data ����
 * @author Genie
 *
 */
class Temp {
	public int currTemp;
	public int cnt;
	
	public Temp(int currTemp, int cnt) {
		this.currTemp = currTemp;
		this.cnt = cnt;
	}
}
