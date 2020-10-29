import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
int a,b;
Scanner sc=new Scanner(System.in);
System.out.println("请输入第一个整数:");
a=sc.nextInt();
System.out.println("请输入第二个整数:");
b=sc.nextInt();
System.out.println(a>b?a:b+"较大");
	}

}
