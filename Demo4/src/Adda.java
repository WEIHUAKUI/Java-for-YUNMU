import java.util.Scanner;

public class Adda {

	public static void main(String[] args) {
		int n,a,num=0,sum=0;   //n��������ĸ�����a����ÿλ�ϵ����֣�num����һλ������sum������õĺ�
Scanner sc=new Scanner(System.in);
System.out.println("����������ĸ�����");
n=sc.nextInt();
System.out.println("��������λ�ϵ����֣�");
a=sc.nextInt();
num=a;  //��һ������
for(int i=1;i<=n;i++) {
	sum=sum+a;  //���
	num=num*10+a;  //����һ������
}
System.out.println("��õĺ�Ϊ��"+sum);
	}

}
