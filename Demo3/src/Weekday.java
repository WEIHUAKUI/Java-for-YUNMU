import java.util.Scanner;

public class Weekday {

	public static void main(String[] args) {
		int num;     //用户输入数字
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入1-7之间的整数:");
		num=sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tueday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
			default:
				System.out.println("输入错误！");
				break;
		}

	}

}
