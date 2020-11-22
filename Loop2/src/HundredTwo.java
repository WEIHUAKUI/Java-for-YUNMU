/**
 * 提高：编写程序，求100～200间的全部素数
 * 
 * @author 魏华奎
 *
 */
public class HundredTwo {
	public static void main(String[] args) {
		System.out.println("100～200间的全部素数如下：");
		int n, i;// 定义n为除数，i为被除数
		for (n = 100; n >= 100 && n <= 200; n++) {
			for (i = 2; i < n; i++)// 被除数从2开始累加
				if (n % i == 0)
					break;// 条件判断：如果能被2及以上的数整除就结束转到下一个if，否则输出else
			if (i < n)
				continue;
			else
				System.out.printf("%d ", n);// 符合条件存在i=n的时候输出是素数
		}
	}
}
