import java.util.Scanner;

public class Num {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int num,numReverse,x1,x2,x3,y1;
		Scanner sc=new Scanner(System.in);
		        System.out.println("������һ����λ��������:");
		       num=sc.nextInt();
		       while(num!=0){
		            int a=num%10;
		            System.out.print(a);
		            num=num/10;}
		        /*x3=num/100;  //��λ�ϵ���ֵ
		        y1=num%100;   //ȡ��ȥ����λ
		        x2=y1/10;     //ʮλ�ϵ���ֵ
		        x1=y1%10;    //ȡ��ȥ��ʮλ�����¸�λ
		        numReverse=x1*100+x2*10+x3;
		        System.out.println("��ת�����ֵΪ"+numReverse);
		        */}
	}
	
