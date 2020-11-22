import java.util.Scanner;

public class WhileFactorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		  int n;//定义n为整型
		  System.out.println("请输入一个数来计算阶乘:");
		  n=in.nextInt();//输入一个n计算阶乘
		  int i=1,m=1;//设置i从1开始，m保存结果
		  while(i<=n)//当i小于n时继续，大于n后停止
		  {
		   m=m*i;//每一次乘以+1的数，到n停止
		   i++;//执行i++
		  }
			System.out.println(n+"的阶乘为:"+m);//输出结果
	}

}
