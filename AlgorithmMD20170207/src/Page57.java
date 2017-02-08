import java.util.Scanner;

/**
 * n���� �̷���� ���� ���տ��� ���ϴ� �� k �̻��� ���� 
 * ó������ �����ϴ� ��ġ�� ã�� Ŭ����
 * @author Genie
 *
 */
public class Page57 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++) {
			list[i] = sc.nextInt();
		}
		int searchNum = sc.nextInt();
		System.out.println(findBig(list, searchNum));
	}
	
	/**
	 * ū ��ġ�� ã�� ��ȯ�ϴ� �޼���
	 * @param list
	 * @param searchNum
	 * @return
	 */
	public static int findBig(int[] list, int searchNum) {
		for(int i=0; i<list.length; i++) {
			if(list[i]>=searchNum)
				return i+1;
		}
		return list.length+1;
	}
}
