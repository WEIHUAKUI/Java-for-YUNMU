import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		double a,b,c,max = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入a成绩:");
		a=sc.nextDouble();
		System.out.println("请输入b成绩:");
		b=sc.nextDouble();
		System.out.println("请输入c成绩:");
		c=sc.nextDouble();
		if(a>b&&a>c)max=a;
		if(b>a&&b>c)max=b;
		if(c>a&&c>b)max=c;
		System.out.println("最大值是"+max+"分");
			
		
		
		
	}

}
