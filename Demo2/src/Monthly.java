import java.util.Scanner;

public class Monthly {

	public static void main(String[] args) {
		double a,b,c,d,e,f,g,h,k,q,w,s,x;//�����������û���������ܶa)������(b)������(c))
		Scanner sc=new Scanner(System.in);
		System.out.println("����������ܶԪ��:");
		a=sc.nextDouble();
		System.out.println("�������������꣩:");
		b=sc.nextDouble();
		System.out.println("�����������ʣ�����С����:");
		c=sc.nextDouble();
		d=c/12;//����������
		e=a*d;//�����ܶ�*������
		f=1+d;//������+1
		g=b*12;//����*12
		h=Math.pow(f, g);
		k=1/h;
		q=1-k;
		w=e/q;
		x=a/12*b;
		s=x+g;
		System.out.println("ÿ��������Ϣ�ܶ�Ϊ"+q+"Ԫ");
		System.out.println("ÿ�»�����ȶϢ��"+s+"Ԫ");
	}

}
