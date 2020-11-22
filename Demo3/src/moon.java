import java.util.Scanner;

public class moon {

	public static void main(String[] args) {
		double s,q;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入这个月所接工程的利润:");
		s=sc.nextDouble();
		if(s<=1000) {System.out.println("你的工资有"+(q=500));}
		else if(s>1000&&s<=2000) {System.out.println("你的工资有"+(q=s*0.1));}
		else if(s>2000&&s<=5000) {System.out.println("你的工资有"+(q=s*0.15));}
		else if(s>5000&&s<=10000) {System.out.println("你的工资有"+(q=s*0.2));}
		else if(s>10000) {System.out.println("你的工资有"+(q=s*0.25));}

	}

}
