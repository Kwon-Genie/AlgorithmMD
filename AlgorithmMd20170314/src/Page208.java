import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
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
public class Page208 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, count;
	public static ArrayList<elec> list = new ArrayList<elec>();
	
	/**
	 * ���� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	public static void output() {
		System.out.println(count);
	}
	
	public static void solve() {
		searchInter();
		while(isIntersect()) {
			sort(2);
//			System.out.println(list.get(list.size()-1).toString());
			list.get(list.size()-1).setInter(-1);
			count++;
			searchInter();
		}
	}
	
	/**
	 * �������� �ִ��� ���θ� ��ȯ�ϴ� �޼���
	 * @return
	 */
	public static boolean isIntersect() {
		for(elec e : list) {
			if(e.getInter()>0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * type�� 1�϶��� left�������� �������� ����
	 * type�� 2�� ���� ������ ���� ������ �������� ����
	 * @param type
	 */
	public static void sort(int type) {
		Collections.sort(list, new Comparator<elec>() {
			@Override
			public int compare(elec e1, elec e2) {
				if(type==1) {
					return e1.getLeft() < e2.getLeft()? -1:e1.getLeft() > e2.getLeft()? 1:0;						
				} else {
					return e1.getInter() < e2.getInter()? -1:e1.getInter() > e2.getInter()? 1:0;
				}
			}
		});
	}
	
	/**
	 * ������ ������ ã�� �����ϴ� �޼���
	 */
	public static void searchInter() {
		sort(1);
		for(int i=0; i<list.size(); i++) {
			if (list.get(i).getInter() != -1) {
				int interNum = 0;
				for (int up = 0; up < i; up++) {
					if (list.get(up).getInter()!=-1 && (list.get(up).getRight() > list.get(i).getRight())) {
						interNum++;
					}
				}
				for (int down = i + 1; down < list.size(); down++) {
					if (list.get(down).getInter()!=-1 && (list.get(down).getRight() < list.get(i).getRight())) {
						interNum++;
					}
				}
				list.get(i).setInter(interNum);
			}
		} 		
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

class elec {
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
}
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