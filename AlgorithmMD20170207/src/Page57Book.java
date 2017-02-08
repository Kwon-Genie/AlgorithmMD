import java.util.Scanner;

/**
 * n���� �̷���� ���� ���տ��� ���ϴ� �� k �̻��� ���� 
 * ó������ �����ϴ� ��ġ�� ã�� Ŭ����
 * å�� ���� �ִ� �ڵ� �ǽ�
 * @author Genie
 *
 */
public class Page57Book {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++)
			list[i] = sc.nextInt();
		int searchNum = sc.nextInt();
		System.out.println(lowerBound(list, 0, list.length, searchNum));
		
 	}
	
	/**
	 * lower bound�� ã�� �޼���
	 * @param list
	 * @param start
	 * @param end
	 * @param searchNum
	 * @return �ش� ��ġ
	 */
	public static int lowerBound(int[] list, int start, int end, int searchNum) {
		int middle;
		while(end-start>0) {
			middle=(start+end)/2;
			if(list[middle]<searchNum)
				start = middle+1;
			else
				end = middle;
		}
		return end+1;
	}
}
