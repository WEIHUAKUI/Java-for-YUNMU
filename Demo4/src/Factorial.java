/**@author κ����
 * ԭ��Ϊ˳��׳ˣ����˵�nʱ�Զ�ֹͣ
 * nΪ�û����������
 * i��������׳˽��
 * a�ۼӵ�nֹͣ
 */
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ����������׳�:");
		long n=sc.nextLong();//��������Ϊ����
		long i=1;//�ʼ�׳˵ĵ�һ����Ϊ1
		for(long a=1;a<=n;a++) {//��a��ʼ����1����a����nʱֹͣ����
			i*=a;//��a����n֮ǰ�������ۻ��˷�
	}
		System.out.printf("%d�Ľ׳�Ϊ:%d",n,i);//������
	}
	
}
