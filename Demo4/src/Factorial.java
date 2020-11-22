/**@author 魏华奎
 * 原理为顺序阶乘，当乘到n时自动停止
 * n为用户输入的数字
 * i用来保存阶乘结果
 * a累加到n停止
 */
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个数来计算阶乘:");
		long n=sc.nextLong();//输入数字为整型
		long i=1;//令开始阶乘的第一个数为1
		for(long a=1;a<=n;a++) {//令a开始等于1，当a等于n时停止计算
			i*=a;//当a等于n之前持续做累积乘法
	}
		System.out.printf("%d的阶乘为:%d",n,i);//输出结果
	}
	
}
