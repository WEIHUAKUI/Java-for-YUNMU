import java.util.Scanner;

public class Hw {

	public static void main(String[] args) {
				double h,w;   //��������(hΪ����wΪ��
				Scanner sc=new Scanner(System.in);
				System.out.println("�����볤���εĳ�:");
				h=sc.nextDouble();
				System.out.println("�����볤���εĿ�:");
				w=sc.nextDouble();
				double area=h*w; //���������
				double ares=h*2+w*2;//�������ܳ�
				System.out.println("���������Ϊ"+area);
				System.out.println("�������ܳ�Ϊ"+ares);

	}

}
