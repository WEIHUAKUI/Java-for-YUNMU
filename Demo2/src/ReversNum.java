import java.util.Scanner;

public class ReversNum {
public static void main(String[] args) {
	int num,numReverse,x1,x2,x3,y1;
	Scanner sc=new Scanner(System.in);
	System.out.println("������1����λ������");
	num=sc.nextInt();
	x3=num/100;  //��λ�ϵ���ֵ
	y1=num%100;   //ȡ��ȥ����λ
	x2=y1/10;    //ʮλ�ϵ���ֵ
	x1=y1%10;     //ȡ��ȥ��ʮλ�����¸�λ
	numReverse=x1*100+x2*10+x3;
	System.out.println("��ת�����ֵΪ��"+numReverse);
	
}
}
