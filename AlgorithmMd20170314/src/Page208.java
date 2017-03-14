import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다.
 * 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 
 * 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
 * 입력
 * 첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100이하의 자연수이다.
 * 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.
 * 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
 * 출력
 * 첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
 * 
 * @since jdk1.8
 * @author Genie
 */
public class Page208 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, count;
	public static ArrayList<elec> list = new ArrayList<elec>();
	
	/**
	 * 메인 수행 메서드
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
	 * 교차점이 있는지 여부를 반환하는 메서드
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
	 * type이 1일때는 left기준으로 오름차순 정렬
	 * type이 2일 때는 교차점 갯수 순으로 오름차순 정렬
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
	 * 교차점 갯수를 찾아 저장하는 메서드
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
	 * 사용자의 입력을 저장하는 메서드
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
결과: 3

7
1 3
4 7
6 6
7 4
8 5
9 8
19 1
*/