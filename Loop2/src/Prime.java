import java.util.Scanner;

/**
 * ����һ������3������n���ж����Ƿ�����
 * 
 * @author κ����
 */
public class Prime {

	public static void main(String[] args) {
		int n, i;// ����nΪ�û�����������iΪ����
		System.out.println("������һ��������");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// �û�����һ������n���ж��ǲ�������
		if (n <= 2)
			System.out.println("������һ������2��������");
		else if (n > 2) {
			for (i = 2; i < n; i++)// ������2��ʼ�ۼ�
				if (n % i == 0)
					break;// �����жϣ�����ܱ�2�����ϵ��������ͽ���ת����һ��if���������else
			if (i < n)
				System.out.printf("%d ����������\n", n);// ȷ��i<n��ʱ�������������
			else
				System.out.printf("%d ��������\n", n);// ������������i=n��ʱ�����������
		}
	}

}
