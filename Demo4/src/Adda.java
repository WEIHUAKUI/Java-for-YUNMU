import java.util.Scanner;

public class Adda {

	public static void main(String[] args) {
		int n,a,num=0,sum=0;   //n代表加数的个数，a代表每位上的数字，num是下一位加数，sum代表求得的和
Scanner sc=new Scanner(System.in);
System.out.println("请输入加数的个数：");
n=sc.nextInt();
System.out.println("请输入数位上的数字：");
a=sc.nextInt();
num=a;  //第一个加数
for(int i=1;i<=n;i++) {
	sum=sum+a;  //求和
	num=num*10+a;  //求下一个加数
}
System.out.println("求得的和为："+sum);
	}

}
