import java.util.Scanner;

public class chengji {

	public static void main(String[] args) {
		int num,a=0;     //用户输入数字
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的成绩:");
		num=sc.nextInt();
		if(num>=90&&num<=100) {a=9;}
		else if(num<90&&num>=80) {a=8;}
		else if(num<80&&num>=60) {a=6;}
		else if(num<60&&num>0) {a=0;}
		switch(a) {
		case 9:
			System.out.println("优秀");
			break;
		case 8:
			System.out.println("良好");
			break;
		case 6:
			System.out.println("及格");
			break;
		case 0:
			System.out.println("差");
			break;
			default:
				System.out.println("输入错误！");
				break;
		}


	}

}
