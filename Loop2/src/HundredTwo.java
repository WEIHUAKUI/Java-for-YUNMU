/**
 * ��ߣ���д������100��200���ȫ������
 * 
 * @author κ����
 *
 */
public class HundredTwo {
	public static void main(String[] args) {
		System.out.println("100��200���ȫ���������£�");
		int n, i;// ����nΪ������iΪ������
		for (n = 100; n >= 100 && n <= 200; n++) {
			for (i = 2; i < n; i++)// ��������2��ʼ�ۼ�
				if (n % i == 0)
					break;// �����жϣ�����ܱ�2�����ϵ��������ͽ���ת����һ��if���������else
			if (i < n)
				continue;
			else
				System.out.printf("%d ", n);// ������������i=n��ʱ�����������
		}
	}
}
