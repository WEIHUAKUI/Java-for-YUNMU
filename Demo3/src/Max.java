import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		double a,b,c,max = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("������a�ɼ�:");
		a=sc.nextDouble();
		System.out.println("������b�ɼ�:");
		b=sc.nextDouble();
		System.out.println("������c�ɼ�:");
		c=sc.nextDouble();
		if(a>b&&a>c)max=a;
		if(b>a&&b>c)max=b;
		if(c>a&&c>b)max=c;
		System.out.println("���ֵ��"+max+"��");
			
		
		
		
	}

}
