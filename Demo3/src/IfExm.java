import java.util.Scanner;

public class IfExm {

	public static void main(String[] args) {
		int Java;//�ɼ�
		int english;
		Scanner sc=new Scanner(System.in);
		System.out.println("���������Java�ɼ���0-100��:");
		Java=sc.nextInt();//����ɼ�
		//System.out.println("���������English�ɼ���0-100��:");
		//english=sc.nextInt();
		if (Java>90&&Java<100){//�ж�||english>90
			System.out.println("ûǮ");
			System.out.println("����С�������㰡");
		}else if (Java<90){                    //����������Ͻ��ִ����һ���ж�
            System.out.println("����һ���֣���P��");
            System.out.println("��������");
		}else if (Java>100){                    //����������Ͻ��ִ����һ���ж�
                System.out.println("��ȷ������ǳɼ����ɼ���ΧӦ��1-100��֮�䣬����������");
               System.out.println("�ⶼ���ỹ��Ҫ�ֻ�����Ϊʦ��������"); }

	}

}
