import java.util.Scanner;

public class Leapyear {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个年份(整数):");
		int year=sc.nextInt();
		if((year%4==0&&year%100!=0)||year%400==0)
			{System.out.println("该年份为闰年");}
		else{System.out.println("该年份不是闰年");}

	}

}
