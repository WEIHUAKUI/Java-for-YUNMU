import java.util.Scanner;

/**
 * 输入一个大于3的整数n，判定它是否素数
 * 
 * @author 魏华奎
 */
public class Prime {

	public static void main(String[] args) {
		int n, i;// 定义n为用户输入整数，i为除数
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 用户输入一个整数n来判断是不是素数
		if (n <= 2)
			System.out.println("请输入一个大于2的整数。");
		else if (n > 2) {
			for (i = 2; i < n; i++)// 除数从2开始累加
				if (n % i == 0)
					break;// 条件判断：如果能被2及以上的数整除就结束转到下一个if，否则输出else
			if (i < n)
				System.out.printf("%d 不是素数。\n", n);// 确保i<n的时候输出不是素数
			else
				System.out.printf("%d 是素数。\n", n);// 符合条件存在i=n的时候输出是素数
		}
	}

}
